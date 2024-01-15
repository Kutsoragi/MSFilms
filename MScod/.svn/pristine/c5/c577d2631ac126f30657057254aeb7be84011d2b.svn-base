package negocio.factura;

public class SAFacturaTest  {

	/*@Test
	public void añadirPaseExito() {
		SAPase saPase = new SAPaseImpl();
		SAFactura saFactura = new SAFacturaImpl();
		
		TPase pase = new TPase("09:00", "11:00", "2020-05-27", 5, 1, 1);
	
		int idPase = 1; // el pase registrado
		int cantidad = 1;
		try {
			saPase.registrarPase(pase);
			saFactura.abrirFactura();
			
			TFactura res = saFactura.añadirPase(idPase, cantidad);
			assertTrue(res != null);
		} catch(Exception e) { fail(e.getMessage());}
	}
		
	@Test
	public void añadirPaseFallo() {
		SAPase saPase = new SAPaseImpl();
		SAFactura saFactura = new SAFacturaImpl();
		
		TPase pase = new TPase("09:00", "11:00", "2020-05-27", 5, 1, 1);
	
		int idPase = 2; // pase que no existe
		int cantidad = 1;
		try {
			saPase.registrarPase(pase);
			saFactura.abrirFactura();
			
			TFactura res = saFactura.añadirPase(idPase, cantidad);
			assertTrue(res == null);
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void quitarPaseExito() {
		SAPase saPase = new SAPaseImpl();
		SAFactura saFactura = new SAFacturaImpl();
		
		TPase pase = new TPase("09:00", "11:00", "2020-05-27", 5, 1, 1);
	
		int idPase = 1;
		int cantidad = 1;
		try {
			saPase.registrarPase(pase);
			saFactura.abrirFactura();
			saFactura.añadirPase(idPase, cantidad);
			
			TFactura res = saFactura.quitarPase(idPase, cantidad);
			assertTrue(res != null);
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void quitarPaseFallo() {
		SAFactura saFactura = new SAFacturaImpl();
	
		int idPase = 1;
		int cantidad = 1;
		try {
			saFactura.abrirFactura();
			saFactura.añadirPase(idPase, cantidad);
			
			TFactura res = saFactura.quitarPase(idPase, cantidad);
			assertTrue(res == null);
		} catch(Exception e) { fail(e.getMessage());}
	}

	@Test
	public void cerrarFacturaExito() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		SAFactura saFactura = new SAFacturaImpl();
		
		TEmpleadoCompleto empleado = new TEmpleadoCompleto ("12345678F","Pablo", true, 1000);
		try {
			saFactura.abrirFactura();
			saEmpleado.registrarEmpleado(empleado);
			boolean res = saFactura.cerrarFactura(1);
			assertTrue(res); // cerrada con exito
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void cerrarFacturaFallo() {
		SAFactura saFactura = new SAFacturaImpl();
		try {
			saFactura.abrirFactura();
			boolean res = saFactura.cerrarFactura(1);
			assertTrue(!res); // cerrada sin exito
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void devolverPaseExito() {
		SAPase saPase = new SAPaseImpl();
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		SAFactura saFactura = new SAFacturaImpl();
		
		TPase pase = new TPase("09:00", "11:00", "2020-05-27", 5, 1, 1);
		TEmpleadoCompleto empleado = new TEmpleadoCompleto ("12345678F","Pablo", true, 1000);
		
		int idPase = 1;
		int cantidad = 10;
		try {
			saPase.registrarPase(pase);
			saEmpleado.registrarEmpleado(empleado);
			saFactura.abrirFactura();
			saFactura.añadirPase(idPase, cantidad);
			saFactura.cerrarFactura(1);
			
			boolean res = saFactura.devolverPase(1, idPase, cantidad/2);
			assertTrue(res); // pase devuelto correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void devolverPaseFallo() {
		SAPase saPase = new SAPaseImpl();
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		SAFactura saFactura = new SAFacturaImpl();
		
		TPase pase = new TPase("09:00", "11:00", "2020-05-27", 5, 1, 1);
		TEmpleadoCompleto empleado = new TEmpleadoCompleto ("12345678F","Pablo", true, 1000);
		
		int idPase = 1;
		int cantidad = 10;
		try {
			saPase.registrarPase(pase);
			saEmpleado.registrarEmpleado(empleado);
			saFactura.abrirFactura();
			saFactura.añadirPase(idPase, cantidad);
			saFactura.cerrarFactura(1);
			
			boolean res = saFactura.devolverPase(1, 2, cantidad/2); // devolver pase inexistente en factura
			assertTrue(!res); // pase devuelto sin exito
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void devolverPaseCantidadFallo() { // mas cantidad a devolver que la cantidad total del pase en la factura
		SAPase saPase = new SAPaseImpl();
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		SAFactura saFactura = new SAFacturaImpl();
		
		TPase pase = new TPase("09:00", "11:00", "2020-05-27", 5, 1, 1);
		TEmpleadoCompleto empleado = new TEmpleadoCompleto ("12345678F","Pablo", true, 1000);
		
		int idPase = 1;
		int cantidad = 10;
		try {
			saPase.registrarPase(pase);
			saEmpleado.registrarEmpleado(empleado);
			saFactura.abrirFactura();
			saFactura.añadirPase(idPase, cantidad);
			saFactura.cerrarFactura(1);
			
			saFactura.devolverPase(1, 1, cantidad*2); // devolver pase doble de cantidad
		} catch(Exception e) { assertEquals("La cantidad excede la correspendiente en la factura (" + cantidad + ").", e.getMessage());}
	}
		
	@Test
	public void buscarFacturaExito() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		SAFactura saFactura = new SAFacturaImpl();
		
		TEmpleadoCompleto empleado = new TEmpleadoCompleto ("12345678F","Pablo", true, 1000);
		try {
			saFactura.abrirFactura();
			saEmpleado.registrarEmpleado(empleado);
			saFactura.cerrarFactura(1);
			
			TFactura res = saFactura.buscarFacturaPorID(1);
			assertTrue(res != null); // factura existe
		} catch(Exception e) { fail(e.getMessage()); }
	}
	
	@Test
	public void buscarFacturaFallo() {
		SAFactura saFactura = new SAFacturaImpl();
		try {
			TFactura res = saFactura.buscarFacturaPorID(1);
			assertFalse(res != null); // factura no existe
		} catch(Exception e) { fail(e.getMessage()); }
	}
	
	@Test
	public void listarFacturasExito() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		SAFactura saFactura = new SAFacturaImpl();
		
		TEmpleadoCompleto empleado = new TEmpleadoCompleto ("12345678F","Pablo", true, 1000);
		try {
			saFactura.abrirFactura();
			saEmpleado.registrarEmpleado(empleado);
			saFactura.cerrarFactura(1);
			
			List<TFactura> res = saFactura.listarFacturas();
			assertTrue(!res.isEmpty()); // hay facturas que mostrar
		} catch(Exception e) { fail(e.getMessage()); }
	}

	@Test
	public void listarFacturasVacioExito() {
		SAFactura saFactura = new SAFacturaImpl();
		try {
			List<TFactura> res = saFactura.listarFacturas();
			assertFalse(!res.isEmpty()); // no hay facturas que mostrar
		} catch(Exception e) { fail(e.getMessage()); }
	}
	*/
}
