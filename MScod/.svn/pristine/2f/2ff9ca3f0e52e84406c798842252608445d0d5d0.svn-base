package integracion.pase;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import negocio.pase.TPase;

public class DAOPaseTest {

	@Test
	public void registrarPaseExito() {
		DAOPase daoPase = new DAOPaseImpl();
		
		TPase pase = new TPase("09:00", "11:00", "2020-05-27", 5, 1, 1, 20);
		try {
			int res = daoPase.registrarPase(pase);
			assertTrue(res > 0); //registrado correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}
		
	@Test
	public void modificarPaseExito() {
		DAOPase daoPase = new DAOPaseImpl();
		
		TPase pase = new TPase(1, "09:00", "12:00", "2020-09-21", 5, 1, 1, 20);
		try {
			int res = daoPase.modificarPase(pase);
			assertTrue(res > 0); //modificado correctamente
		} catch(Exception e) { fail(e.getMessage()); }
	}

	@Test
	public void borrarPaseExito() {
		DAOPase daoPase = new DAOPaseImpl();
		
		int id = 1;
		try {
			int res = daoPase.borrarPase(id);
			assertTrue(res > 0); //borrado correctamente
		} catch(Exception e) {
			fail(e.getMessage());
		}	
	}
	
	@Test
	public void franjaValidaExito() {
		DAOPase daoPase = new DAOPaseImpl();
		
		TPase pase = new TPase(1, "13:00", "18:00", "2020-09-21", 5, 1, 1, 20);
		try {
			boolean res = daoPase.franjaValida(pase); 
			assertTrue(res); // si es true es valida
		} catch(Exception e) { fail(e.getMessage());}	
	}

	@Test
	public void franjaValidaFallo() {
		DAOPase daoPase = new DAOPaseImpl();
		
		TPase pase = new TPase(1, "13:00", "18:00", "2020-09-21", 5, 1, 1, 20);
		try {
			boolean res = daoPase.franjaValida(pase); 
			assertTrue(!res);
		} catch(Exception e) { fail(e.getMessage());}	
	}
	
	@Test
	public void buscarPaseExito() {
		DAOPase daoPase = new DAOPaseImpl();
		
		int id = 2;
		try {
			TPase res = daoPase.buscarPasePorID(id); 
			assertTrue(res != null); //no es nulo, existe
		} catch(Exception e) { fail(e.getMessage());}	
	}
	
	@Test
	public void buscarPaseFallo() {
		DAOPase daoPase = new DAOPaseImpl();
		
		int id = 200;
		try {
			TPase res = daoPase.buscarPasePorID(id);  
			assertTrue(res == null); //es nulo, no existe
		} catch(Exception e) { fail(e.getMessage());}	
	}
	
	@Test
	public void mostrarListaPasesExito() {
		DAOPase daoPase = new DAOPaseImpl();
		
		try {
			List<TPase> res = daoPase.mostrarListaPases();
			assertTrue(!res.isEmpty()); 
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void mostrarPasesPorPeliculaExito() {
		DAOPase daoPase = new DAOPaseImpl();
		
		int idPelicula = 2;
		try {
			List<TPase> res = daoPase.mostrarPasesPorPeliculas(idPelicula);
			assertTrue(res != null && !res.isEmpty());
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void mostrarPasesPorPeliculaFallo() {
		DAOPase daoPase = new DAOPaseImpl();
		
		int idPelicula = 200;
		try {
			List<TPase> res = daoPase.mostrarPasesPorPeliculas(idPelicula);
			assertFalse(res != null && !res.isEmpty());
		} catch(Exception e) { fail(e.getMessage());}
	}
}
