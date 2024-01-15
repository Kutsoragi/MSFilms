package negocio.facturaTienda;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;


public class SAFacturaTest {
	
	@Test
	public void abrirFacturaExito() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		try {
			TCarritoTienda res = saFacturaTienda.abrirFactura();
			assertTrue(res != null); //factura abierta correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void añadirProductoExito() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		TFacturaTienda tFacturaTienda = new TFacturaTienda(1,50,"2021-05-14");
		TLineaFacturaTienda tLineaFacturaTienda = new TLineaFacturaTienda(1,1,1);
		
		LinkedList<TLineaFacturaTienda> lista = new LinkedList<TLineaFacturaTienda>();
		lista.add(tLineaFacturaTienda);
		
		TCarritoTienda carrito = new TCarritoTienda(tFacturaTienda, lista, 500);
		
		try {
			TCarritoTienda res = saFacturaTienda.añadirProducto(carrito);
			assertTrue(res != null); //producto añadido correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void añadirProductoFallo() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		TFacturaTienda tFacturaTienda = new TFacturaTienda(1,50,"2021-05-14");
		TLineaFacturaTienda tLineaFacturaTienda = new TLineaFacturaTienda(1,1000,1);
		
		LinkedList<TLineaFacturaTienda> lista = new LinkedList<TLineaFacturaTienda>();
		lista.add(tLineaFacturaTienda);
		
		TCarritoTienda carrito = new TCarritoTienda(tFacturaTienda, lista, 500);
		
		try {
			TCarritoTienda res = saFacturaTienda.añadirProducto(carrito);
			assertTrue(res == null); //fallo al añadir producto porque no existe el producto 1000
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void quitarProductoExito() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		TFacturaTienda tFacturaTienda = new TFacturaTienda(1,50,"2021-05-14");
		TLineaFacturaTienda tLineaFacturaTienda = new TLineaFacturaTienda(1,1,1);
		
		LinkedList<TLineaFacturaTienda> lista = new LinkedList<TLineaFacturaTienda>();
		lista.add(tLineaFacturaTienda);
		
		TCarritoTienda carrito = new TCarritoTienda(tFacturaTienda, lista, 500);
		
		try {
			TCarritoTienda res = saFacturaTienda.quitarProducto(carrito);
			assertTrue(res != null); //producto quitado correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void quitarProductoFallo() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		TFacturaTienda tFacturaTienda = new TFacturaTienda(1,50,"2021-05-14");
		TLineaFacturaTienda tLineaFacturaTienda = new TLineaFacturaTienda(1,1000,1);
		
		LinkedList<TLineaFacturaTienda> lista = new LinkedList<TLineaFacturaTienda>();
		lista.add(tLineaFacturaTienda);
		
		TCarritoTienda carrito = new TCarritoTienda(tFacturaTienda, lista, 500);
		
		try {
			TCarritoTienda res = saFacturaTienda.quitarProducto(carrito);
			assertTrue(res == null); ///fallo al quitar producto porque no existe el producto 1000
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	
	@Test
	public void cerrarFacturaExito() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		TFacturaTienda tFacturaTienda = new TFacturaTienda(1,50,"2021-05-14");
		TLineaFacturaTienda tLineaFacturaTienda = new TLineaFacturaTienda(1,1,1);
		
		LinkedList<TLineaFacturaTienda> lista = new LinkedList<TLineaFacturaTienda>();
		lista.add(tLineaFacturaTienda);
		
		TCarritoTienda carrito = new TCarritoTienda(tFacturaTienda, lista, 500);
		
		try {
			boolean res = saFacturaTienda.cerrarFactura(carrito);
			assertTrue(res == true); //factura cerrada correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void cerrarFacturaFallo() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		TFacturaTienda tFacturaTienda = new TFacturaTienda(1,50,"2021-05-14");
		TLineaFacturaTienda tLineaFacturaTienda = new TLineaFacturaTienda(1,1000,1);
		
		LinkedList<TLineaFacturaTienda> lista = new LinkedList<TLineaFacturaTienda>();
		lista.add(tLineaFacturaTienda);
		
		TCarritoTienda carrito = new TCarritoTienda(tFacturaTienda, lista, 500);
		
		try {
			boolean res = saFacturaTienda.cerrarFactura(carrito);
			assertTrue(res == false); //factura no cerrada ya que no existe el producto con id 1000
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void devolverProductoExito() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		TLineaFacturaTienda tLineaFacturaTienda = new TLineaFacturaTienda(1,1,1);
		
		try {
			boolean res = saFacturaTienda.devolverProducto(tLineaFacturaTienda);
			assertTrue(res == true); //producto devuelto correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void devolverProductoFallo() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		TLineaFacturaTienda tLineaFacturaTienda = new TLineaFacturaTienda(1000,1,1);
		
		try {
			boolean res = saFacturaTienda.devolverProducto(tLineaFacturaTienda);
			assertTrue(res == false); //no existe el id 1000 de tLineaFacturaTienda
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void buscarFacturaPorIdExito() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		int id = 1;
		
		try {
			TCarritoTienda res = saFacturaTienda.buscarFacturaPorId(id);
			assertTrue(res != null); //factura devuelta correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void buscarFacturaPorIdFallo() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		int id = 1000;
		
		try {
			TCarritoTienda res = saFacturaTienda.buscarFacturaPorId(id);
			assertTrue(res == null); //no existe el id 1000
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void listarFacturasExito() {
		SAFacturaTienda saFacturaTienda = new SAFacturaTiendaImp();
		
		try {
			LinkedList<TCarritoTienda> res = saFacturaTienda.listarFacturas();
			assertTrue(res != null); //carritos listados correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}

}
