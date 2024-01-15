package negocio.empleado;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class SAEmpleadoTest {

	@Test
	public void registrarEmpleadoExito() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		
		TEmpleado empleado = new TEmpleadoCompleto("12345678X", "Nombre", true, 2000);
		try {
			int res = saEmpleado.registrarEmpleado(empleado);
			assertTrue(res > 0); //registrado correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}
		
	@Test
	public void registrarEmpleadoFallo() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		
		TEmpleado empleado = new TEmpleadoCompleto("12345678X", "Nombre3", true, 2020);
		try {
			int res = saEmpleado.registrarEmpleado(empleado);
			assertTrue(res <= 0); //registrado sin exito. Ya existe un empleado con ese DNI
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void modificarEmpleadoExito() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		
		TEmpleado empleado = new TEmpleadoCompleto("12345678X", "NombreNuevo", true, 20200);
		try {
			int res = saEmpleado.modificarEmpleado(empleado);
			assertTrue(res > 0); //modificado correctamente
		} catch(Exception e) { fail(e.getMessage()); }
	}
	
	@Test
	public void modificarEmpleadoFallo() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		
		TEmpleado empleado = new TEmpleadoCompleto("00000000A", "NombreNuevo", true, 20200);
		try {
			int res = saEmpleado.modificarEmpleado(empleado);
			assertFalse(res > 0); //nada que modificar
		} catch(Exception e) { fail(e.getMessage()); }
	}

	@Test
	public void borrarEmpleadoExito() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		
		int id = 1;
		try {
			int res = saEmpleado.borrarEmpleado(id);
			assertTrue(res > 0); //borrado correctamente
		} catch(Exception e) {
			fail(e.getMessage());
		}	
	}

	@Test
	public void buscarEmpleadoExito() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		
		int id = 2;
		try {
			TEmpleado res = saEmpleado.buscarEmpleadoPorID(id); 
			assertTrue(res != null); //no es nulo, existe
		} catch(Exception e) { fail(e.getMessage());}	
	}
	
	@Test
	public void buscarEmpleadoFallo() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		
		int id = 200;
		try {
			TEmpleado res = saEmpleado.buscarEmpleadoPorID(id);  
			assertTrue(res == null); //es nulo, no existe
		} catch(Exception e) { fail(e.getMessage());}	
	}
	
	@Test
	public void mostrarListaEmpleadosExito() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		
		try {
			List<TEmpleado> res = saEmpleado.mostrarListaEmpleados();
			assertTrue(!res.isEmpty()); 
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void mostrarEmpleadosPorJornadaExito() {
		SAEmpleado saEmpleado = new SAEmpleadoImpl();
		
		boolean esCompleta = true;
		try {
			List<TEmpleado> res = saEmpleado.mostrarEmpleadosPorJornada(esCompleta);
			assertTrue(res != null && !res.isEmpty());
		} catch(Exception e) { fail(e.getMessage());}
	}
}
