package negocio.facturaTienda;

import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;

import negocio.entityManagerUtil.EntityManagerFact;
import negocio.producto.Producto;



public class SAFacturaTiendaImp implements SAFacturaTienda{

	public TCarritoTienda abrirFactura() {
		return new TCarritoTienda();
	}

	private TLineaFacturaTienda getLinea(LinkedList<TLineaFacturaTienda> lineasFactura, int idProducto) {
		TLineaFacturaTienda lineaFactura = null;
		ListIterator<TLineaFacturaTienda> iterator = lineasFactura.listIterator();
		while (lineaFactura == null && iterator.hasNext()) {
			TLineaFacturaTienda linea = iterator.next();
			if (linea.getIdProducto() == idProducto)
				lineaFactura = linea;
		}
		return lineaFactura;
	}
	
	private void removeLineaFactura(LinkedList<TLineaFacturaTienda> lineasFactura, int idProducto) {
		ListIterator<TLineaFacturaTienda> iterator = lineasFactura.listIterator();
		while(iterator.hasNext()) {
		    if(iterator.next().getIdProducto() == idProducto)
		    	iterator.remove();
		}
	}
	
	public TCarritoTienda añadirProducto(TCarritoTienda carrito) {
		
		int idProducto =  carrito.getIdProductoAuxiliar();
		int cantidad = carrito.getCantidadAuxiliar();
		LinkedList<TLineaFacturaTienda> lineasFactura = carrito.getLineasFactura();
		
		TLineaFacturaTienda lineaFactura = getLinea(lineasFactura, idProducto);
		if (lineaFactura != null)
			lineaFactura.setCantidad(lineaFactura.getCantidad() + cantidad);
		else
			lineasFactura.add(new TLineaFacturaTienda(idProducto, cantidad));
		
		return carrito;
	}
	
	public TCarritoTienda quitarProducto(TCarritoTienda carrito) {
		int idProducto =  carrito.getIdProductoAuxiliar();
		int cantidad = carrito.getCantidadAuxiliar();
		LinkedList<TLineaFacturaTienda> lineasFactura = carrito.getLineasFactura();
		
		TLineaFacturaTienda lineaFactura = getLinea(lineasFactura, idProducto);
		if (lineaFactura != null) {
			int nuevaCantidad = lineaFactura.getCantidad() - cantidad;
			if (nuevaCantidad <= 0)
				removeLineaFactura(lineasFactura, idProducto);
			else
				lineaFactura.setCantidad(nuevaCantidad);
		} else {
			throw new NullPointerException("El producto especificado no existe en la factura.");
		}
		
		return carrito;
	}
	
	public TCarritoTienda buscarFacturaPorId(int id) {
		TCarritoTienda carrito = null;
		TFacturaTienda factura = new TFacturaTienda();
		LinkedList<TLineaFacturaTienda> lineasFactura = new LinkedList<TLineaFacturaTienda>();
		double precioTotal = 0;
		if (id < 1)
			throw new IllegalArgumentException("ID incorrecto.");
		
		//Iniciamos la transaccion
		EntityManager em = EntityManagerFact.getInstance().createEntityManager();
		em.getTransaction().begin();
		//Buscamos la factura
		FacturaTienda facturaLeida = em.find(FacturaTienda.class, id, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		if(facturaLeida != null){
			factura.setFecha(facturaLeida.getFecha().toString());
			factura.setID(facturaLeida.getId());
			factura.setPrecio(facturaLeida.getPrecio());
			List<LineaFacturaTienda> lista = facturaLeida.getLineasFactura();
			for(LineaFacturaTienda l : lista){
				TLineaFacturaTienda lineaTienda = new TLineaFacturaTienda();
				lineaTienda.setCantidad(l.getCantidad());
				lineaTienda.setPrecio(l.getPrecio());
				lineaTienda.setIdProducto(l.getProducto().getId());
				lineaTienda.setIdFactura(l.getFactura().getId());
				lineasFactura.add(lineaTienda);
				precioTotal += l.getPrecio();
			}
			carrito = new TCarritoTienda(factura, lineasFactura, precioTotal);
			em.getTransaction().commit();
		}
		else
			em.getTransaction().rollback();
		
		em.close();
		return carrito;
	}

	public boolean devolverProducto(TLineaFacturaTienda lineaFactura) {
		boolean valid = false;
		
		//Iniciamos la transaccion
		EntityManager em = EntityManagerFact.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<LineaFacturaTienda> query = em.createQuery("SELECT f FROM LineaFacturaTienda f WHERE f.idLinea = :id", LineaFacturaTienda.class);
		LineaFacturaTiendaID id = new LineaFacturaTiendaID(lineaFactura.getIdFactura(), lineaFactura.getIdProducto());
		query.setParameter("id", id);
		if(query.getResultList().size() > 0){
			LineaFacturaTienda linea = query.getSingleResult();
			em.lock(linea, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			int nuevaCantidad = linea.getCantidad() - lineaFactura.getCantidad();
			if (nuevaCantidad > 0) {
				linea.setCantidad(nuevaCantidad);
				linea.setPrecio(linea.getPrecio() - lineaFactura.getCantidad() * linea.getProducto().getPrecio());
				em.persist(linea);
				Producto producto = em.find(Producto.class, linea.getProducto().getId());
				producto.setStock(producto.getStock() + lineaFactura.getCantidad());
				em.persist(producto);
			} else {
				em.remove(linea);
				em.refresh(linea.getFactura());
				Producto producto = em.find(Producto.class, linea.getProducto().getId());
				producto.setStock(producto.getStock() + linea.getCantidad());
				em.persist(producto);
			}
			em.getTransaction().commit();
			valid = true;
		}
		else
			em.getTransaction().rollback();
		
		em.close();
		return valid;
	}

	public LinkedList<TCarritoTienda> listarFacturas() {
		
		LinkedList<TCarritoTienda> listaFacturas = new LinkedList<TCarritoTienda>();
		
		//Iniciamos la transaccion
		EntityManager em = EntityManagerFact.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<FacturaTienda> query = em.createQuery("SELECT f FROM FacturaTienda f", FacturaTienda.class);
		List<FacturaTienda> lista = query.getResultList();
		if (lista.size() > 0){
			for (FacturaTienda fact: lista){
				TFacturaTienda factura = new TFacturaTienda();
				LinkedList<TLineaFacturaTienda> lineasFactura = new LinkedList<TLineaFacturaTienda>();
				double precioTotal = 0;
				factura.setFecha(fact.getFecha().toString());
				factura.setID(fact.getId());
				factura.setPrecio(fact.getPrecio());
				List<LineaFacturaTienda> list = fact.getLineasFactura();
				for(LineaFacturaTienda l : list){
					TLineaFacturaTienda lineaTienda = new TLineaFacturaTienda();
					lineaTienda.setCantidad(l.getCantidad());
					lineaTienda.setPrecio(l.getPrecio());
					lineaTienda.setIdProducto(l.getProducto().getId());
					lineaTienda.setIdFactura(l.getFactura().getId());
					lineasFactura.add(lineaTienda);
					precioTotal += l.getPrecio();
				}
				TCarritoTienda carrito = new TCarritoTienda(factura, lineasFactura, precioTotal);
				listaFacturas.add(carrito);
			}
			em.getTransaction().commit();
		}
		else
			em.getTransaction().rollback();
		
		em.close();
		return listaFacturas;
	}

	public boolean cerrarFactura(TCarritoTienda carrito) {
		boolean ok = true;
		
		//Iniciamos la transaccion
		EntityManager em = EntityManagerFact.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		// validar productos
		for (TLineaFacturaTienda l : carrito.getLineasFactura()) {
			Producto producto = em.find(Producto.class, l.getIdProducto(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
			if (producto == null || !producto.isActivo()){
				ok = false;
			}
			else if (producto != null && producto.getStock() < l.getCantidad()){
				ok = false;
			}
			
			// calcular precio de linea
			if (ok) l.setPrecio(l.getCantidad()*producto.getPrecio());
		}
		if(ok){// los datos son validos y la factura es creable
			TFacturaTienda tFactura = carrito.getFactura();
			FacturaTienda factura = new FacturaTienda();
			List<LineaFacturaTienda> listaLineasPersistentes= new ArrayList<LineaFacturaTienda>();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			try {
				cal.setTime(sdf.parse(tFactura.getFecha()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			factura.setPrecio(tFactura.getPrecio());
			factura.setFecha(cal);
			em.persist(factura);
			//em.getTransaction().commit();
			for (TLineaFacturaTienda tLinea : carrito.getLineasFactura()){
				Producto producto = em.find(Producto.class, tLinea.getIdProducto(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				producto.setStock(producto.getStock() - tLinea.getCantidad());
				em.persist(producto);
				LineaFacturaTienda linea = new LineaFacturaTienda();
				LineaFacturaTiendaID idLinea = new LineaFacturaTiendaID(factura.getId(), producto.getId());
				linea.setCantidad(tLinea.getCantidad());
				linea.setFactura(factura);
				linea.setProducto(producto);
				linea.setPrecio(tLinea.getPrecio());
				linea.setIdLinea(idLinea);
				em.persist(linea);
				listaLineasPersistentes.add(linea);
			}
			factura.setLineasFactura(listaLineasPersistentes);
			em.getTransaction().commit();
		}
		else{
			em.getTransaction().rollback();
			em.close();
			throw new IllegalArgumentException("Uno de los productos no existe o no tiene stock");
		}
		em.close();
		return ok;
	}

	
}