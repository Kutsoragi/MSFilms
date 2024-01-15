package integracion.factura;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import negocio.factura.TFactura;

public class DAOFacturaTest {
	
	/*@Test
	public void devolverPaseExito() {
		DAOFactura daoFactura = new DAOFacturaImpl();
		
		int idPase = 1;
		int cantidad = 10;
		try {
			boolean res = daoFactura.devolverPase(1, idPase, cantidad/2);
			assertTrue(res); // pase devuelto correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}*/
		
	@Test
	public void buscarFacturaExito() {
		DAOFactura daoFactura = new DAOFacturaImpl();
		
		int idFactura = 1;
		try {
			TFactura res = daoFactura.buscarFacturaPorID(idFactura);
			assertTrue(res != null); // factura existe
		} catch(Exception e) { fail(e.getMessage()); }
	}
	
	@Test
	public void buscarFacturaFallo() {
		DAOFactura daoFactura = new DAOFacturaImpl();
		
		int idFactura = 200;
		try {
			TFactura res = daoFactura.buscarFacturaPorID(idFactura);
			assertFalse(res != null); // factura no existe
		} catch(Exception e) { fail(e.getMessage()); }
	}
	
	@Test
	public void listarFacturasExito() {
		DAOFactura daoFactura = new DAOFacturaImpl();
		
		try {
			List<TFactura> res = daoFactura.mostrarListaFacturas();
			assertTrue(!res.isEmpty()); // hay facturas que mostrar
		} catch(Exception e) { fail(e.getMessage()); }
	}
}
