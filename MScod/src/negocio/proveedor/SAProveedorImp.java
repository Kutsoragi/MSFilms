
package negocio.proveedor;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;

import java.util.ArrayList;
import java.util.List;

import negocio.entityManagerUtil.EntityManagerFact;
import negocio.producto.Producto;


public class SAProveedorImp implements SAProveedor {

	public int registrarProveedor(TProveedor tProveedor) {
		
		int idProveedor = -1;
		
		//Iniciamos la transaccion
		EntityManager em = EntityManagerFact.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos el proveedor por nombre
		TypedQuery<Proveedor> proveedorLectura = em.createNamedQuery("negocio.proveedor.Proveedor.buscarPorNombre",Proveedor.class);
		proveedorLectura.setParameter("nombre", tProveedor.getNombre());
		
		// Creamos el proveedor
		Proveedor proveedor;
		
		//no hay ningun proveedor con el mismo nombre
		if(proveedorLectura.getResultList().size() == 0){ 
			
			// asignamos los atributos
			proveedor = new Proveedor();
			proveedor.setNombre(tProveedor.getNombre());
			proveedor.setNumeroTelefono(tProveedor.getTelefono());
			proveedor.setEmail(tProveedor.getEmail());
			proveedor.setDireccion(tProveedor.getDireccion());
			proveedor.setActivo(true);
			
			// Damos de alta
			em.persist(proveedor);
			em.getTransaction().commit();
			idProveedor = proveedor.getId();
			
		}else{ // Reactivamos
			 proveedor = proveedorLectura.getSingleResult();
			
			if(!proveedor.isActivo()){
				// Actualizamos los valores
				proveedor.setNombre(tProveedor.getNombre());
				proveedor.setNumeroTelefono(tProveedor.getTelefono());
				proveedor.setEmail(tProveedor.getEmail());
				proveedor.setDireccion(tProveedor.getDireccion());
				// reactivamos
				proveedor.setActivo(true);
				em.getTransaction().commit();
				idProveedor = proveedor.getId();
			}
			else
				em.getTransaction().rollback();
		}
		
		em.close();
		
		return idProveedor;
		
	}

	public int editarProveedor(TProveedor tProveedor) {
		
		int idProveedor = -1;
		
		//Iniciamos la transaccion
		EntityManager em = EntityManagerFact.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos el proveedor 
		Proveedor proveedorLectura = em.find(Proveedor.class, tProveedor.getId(), LockModeType.OPTIMISTIC_FORCE_INCREMENT);
		
		// si existe en la base de datos y esta activo
		if(proveedorLectura != null && proveedorLectura.isActivo()){ 
			
			// Buscamos si hay un proveedor con el mismo nombre
			TypedQuery<Proveedor> proveedorLecturaPorNombre = em.createNamedQuery("negocio.proveedor.Proveedor.buscarPorNombre",Proveedor.class);
			proveedorLecturaPorNombre.setParameter("nombre", tProveedor.getNombre());
			
			//Si no hay un proveedor con el mismo nombre
			if (proveedorLecturaPorNombre.getResultList().size() == 0 ||
					proveedorLecturaPorNombre.getSingleResult().getId() == proveedorLectura.getId()) {
				
				proveedorLectura.setNombre(tProveedor.getNombre());
				proveedorLectura.setNumeroTelefono(tProveedor.getTelefono());
				proveedorLectura.setEmail(tProveedor.getEmail());
				proveedorLectura.setDireccion(tProveedor.getDireccion());
				em.getTransaction().commit();
				idProveedor = proveedorLectura.getId();
			}
			else{
				em.getTransaction().rollback();
				throw new IllegalArgumentException("Ya existe un proveedor con ese nombre");
			}
		} else
			em.getTransaction().rollback();
		
		em.close();
		
		return idProveedor;
		
	}

	public TProveedor buscarProveedorPorId(int id) {
		TProveedor res = null;
		
		//Iniciamos la transaccion
		EntityManager em = EntityManagerFact.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		//Creamos y ejecutamos la query
		Proveedor p = em.find(Proveedor.class, id);
		
		if (p != null && p.isActivo()) {
			res = new TProveedor();
			res.setId(p.getId());
			res.setNombre(p.getNombre());
			res.setTelefono(p.getNumeroTelefono());
			res.setEmail(p.getEmail());
			res.setDireccion(p.getDireccion());
			res.setActivo(p.isActivo());
			em.getTransaction().commit();
		}
		else
			em.getTransaction().rollback();
					
		
		em.close();
		
		return res;
	}

	public int borrarProveedor(int id) {
	
		int idProveedor = -1;
			
		//Iniciamos la transaccion
		EntityManager em = EntityManagerFact.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		// Buscamos el proveedor por id
		Proveedor proveedorLectura = em.find(Proveedor.class, id);
		
		//Si existe y esta activo
		if(proveedorLectura != null && proveedorLectura.isActivo()){ 
			
			boolean tieneActivos = false;
			
			
			// comprueba si hay algun producto activo
			for(Producto p: proveedorLectura.getListaProductos()){ 
				em.lock(p, LockModeType.OPTIMISTIC_FORCE_INCREMENT);
				if(p.isActivo()){
					tieneActivos = true;
				}
			}
			
			if(!tieneActivos){
				proveedorLectura.setActivo(false);
				em.getTransaction().commit();
				idProveedor = proveedorLectura.getId();
			}
			else{
				em.getTransaction().rollback();
				throw new IllegalArgumentException("El proveedor tiene productos activos asociados");
			}
		}
		else
			em.getTransaction().rollback();
		
		em.close();

		return idProveedor;
	}

	public List<TProveedor> listarProveedores() {
		
		List<TProveedor> proveedores = new ArrayList<TProveedor>();
		
		//Iniciamos la transaccion
		EntityManager em = EntityManagerFact.getInstance().createEntityManager();
		em.getTransaction().begin();
		
		//Creamos y ejecutamos la query
		TypedQuery<Proveedor> proveedoresLeidos = em.createQuery("SELECT p FROM Proveedor p WHERE p.activo = true", Proveedor.class);
		
		//Metemos las secciones en la lista
		for(Proveedor p : proveedoresLeidos.getResultList()) {
			TProveedor res = new TProveedor();
			res.setId(p.getId());
			res.setNombre(p.getNombre());
			res.setTelefono(p.getNumeroTelefono());
			res.setEmail(p.getEmail());
			res.setDireccion(p.getDireccion());
			res.setActivo(p.isActivo());
			proveedores.add(res);
		}
		
		em.getTransaction().commit();
		em.close();
		
		return proveedores;
	}
	
}