package negocio.pelicula;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class SAPeliculaTest {

	@Test
	public void registrarPeliculaExito() {
		SAPelicula saPelicula = new SAPeliculaImpl();
		TPelicula pelicula = new TPelicula(120, "Nombre");
		try {
			int res = saPelicula.registrarPelicula(pelicula);
			assertTrue(res > 0); //registrada correctamente
		} catch(Exception e) { fail(e.getMessage());}
	}
		
	@Test
	public void modificarPeliculaExito() {
		SAPelicula saPelicula = new SAPeliculaImpl();
		
		TPelicula pelicula = new TPelicula(1, 120, "Nombre");
		try {
			int res = saPelicula.modificarPelicula(pelicula);
			assertTrue(res > 0); //modificada correctamente
		} catch(Exception e) { fail(e.getMessage()); }
	}
	
	@Test
	public void modificarPeliculaFallo() {
		SAPelicula saPelicula = new SAPeliculaImpl();
		
		TPelicula pelicula = new TPelicula(200, 120, "Nombre");
		try {
			int res = saPelicula.modificarPelicula(pelicula);
			assertFalse(res > 0); //nada que modificar
		} catch(Exception e) { fail(e.getMessage()); }
	}

	@Test
	public void borrarPeliculaExito() {
		SAPelicula saPelicula = new SAPeliculaImpl();
		
		int id = 1;
		try {
			int res = saPelicula.borrarPelicula(id);
			assertTrue(res > 0); //borrada correctamente
		} catch(Exception e) {
			fail(e.getMessage());
		}	
	}

	@Test
	public void buscarPeliculaExito() {
		SAPelicula saPelicula = new SAPeliculaImpl();
		
		int id = 2;
		try {
			TPelicula res = saPelicula.buscarPeliculaPorID(id); 
			assertTrue(res != null); //no es nulo, existe
		} catch(Exception e) { fail(e.getMessage());}	
	}
	
	@Test
	public void buscarPeliculaFallo() {
		SAPelicula saPelicula = new SAPeliculaImpl();
		
		int id = 200;
		try {
			TPelicula res = saPelicula.buscarPeliculaPorID(id);  
			assertTrue(res == null); //es nulo, no existe
		} catch(Exception e) { fail(e.getMessage());}	
	}
	
	@Test
	public void mostrarListaPeliculasExito() {
		SAPelicula saPelicula = new SAPeliculaImpl();
		
		try {
			List<TPelicula> res = saPelicula.mostrarListaPeliculas();
			assertTrue(!res.isEmpty()); 
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void mostrarPeliculasPorFechaExito() {
		SAPelicula saPelicula = new SAPeliculaImpl();
		
		String fecha = "2020-10-10";
		try {
			List<TPelicula> res = saPelicula.mostrarPeliculasPorFecha(fecha);
			assertTrue(res != null && !res.isEmpty());
		} catch(Exception e) { fail(e.getMessage());}
	}
	
	@Test
	public void mostrarPeliculasPorFechaFallo() {
		SAPelicula saPelicula = new SAPeliculaImpl();
		
		String fecha = "1000-10-10";
		try {
			List<TPelicula> res = saPelicula.mostrarPeliculasPorFecha(fecha);
			assertFalse(res != null && !res.isEmpty());
		} catch(Exception e) { fail(e.getMessage());}
	}
	
}
