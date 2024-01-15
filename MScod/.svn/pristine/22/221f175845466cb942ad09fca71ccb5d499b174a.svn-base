package negocio.marca;


import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import negocio.producto.TProducto;

public class SAMarcaTest {
	
	@Test
	public void registrarMarcaExito(){
		SAMarca saMarca = new SAMarcaImp();
		
		TMarca tMarca = new TMarca("nombreMarcaTest");
		try{
			int res = saMarca.registrarMarca(tMarca);
			assertTrue(res > 0); //registrado correctamente
		}catch(Exception e) { fail(e.getMessage());}
		
	}

	@Test
	public void registrarMarcaFallo(){
		SAMarca saMarca = new SAMarcaImp();
		
		TMarca tMarca = new TMarca("Fanta");
		try{
			int res = saMarca.registrarMarca(tMarca);
			assertTrue(res <= 0); //no se pudo registrar, existe una marca con el mismo nombre
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void editarMarcaExito(){
		SAMarca saMarca = new SAMarcaImp();
		
		TMarca tMarca = new TMarca(2, "Risquetos");
		try{
			int res = saMarca.editarMarca(tMarca);
			assertTrue(res > 0); //editado correctamente
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void editarMarcaFallo(){
		SAMarca saMarca = new SAMarcaImp();
		
		TMarca tMarca = new TMarca(2, "Fanta");
		try{
			int res = saMarca.editarMarca(tMarca);
			assertTrue(res <= 0); //ya existe una marca con el mismo nombre
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void borrarMarcaExito(){
		SAMarca saMarca = new SAMarcaImp();
		
		int id = 2;
		try{
			int res = saMarca.borrarMarca(id);
			assertTrue(res > 0); //borrado correctamente
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void borrarMarcaFallo(){
		SAMarca saMarca = new SAMarcaImp();
		
		int id = 2000;
		try{
			int res = saMarca.borrarMarca(id);
			assertTrue(res <= 0); //no existe una marca on ese id
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void buscarMarcaPorIdExito(){
		SAMarca saMarca = new SAMarcaImp();
		
		int id = 1;
		try{
			TMarca res = saMarca.buscarMarcaPorId(id);
			assertTrue(res != null); //econtrada correctamente
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void buscarMarcaPorIdFallo(){
		SAMarca saMarca = new SAMarcaImp();
		
		int id = 1000;
		try{
			TMarca res = saMarca.buscarMarcaPorId(id);
			assertTrue(res == null); //no existe una marca con ese id
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void mostrarMarcasExito(){
		SAMarca saMarca = new SAMarcaImp();
		
	
		try{
			List<TMarca> res = saMarca.mostrarMarcas();
			assertTrue(res != null); //listada correctamente
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void buscarProductosPorMarcaExito(){
		SAMarca saMarca = new SAMarcaImp();
		
		TMarca tMarca = new TMarca(1, "Fanta");
		try{
			List<TProducto> res = saMarca.buscarProductosPorMarca(tMarca);
			assertTrue(res != null); //listada correctamente
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void buscarProductosPorMarcaFallo(){
		SAMarca saMarca = new SAMarcaImp();
		
		TMarca tMarca = new TMarca(2000, "Monster");
		try{
			List<TProducto> res = saMarca.buscarProductosPorMarca(tMarca);
			assertTrue(res == null); //la marca no existe
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void obtenerCaloriasMediasDeMarcaExito(){
		SAMarca saMarca = new SAMarcaImp();
		
		int id = 1;
		try{
			int res = saMarca.obtenerCaloriasMediasDeMarca(id);
			assertTrue(res >= 0); //listada correctamente
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void obtenerCaloriasMediasDeMarcaFallo(){
		SAMarca saMarca = new SAMarcaImp();
		
		int id = 5000;
		try{
			int res = saMarca.obtenerCaloriasMediasDeMarca(id);
			assertTrue(res < 0); //no existe la marca
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
}
