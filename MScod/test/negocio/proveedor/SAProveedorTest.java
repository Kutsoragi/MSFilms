package negocio.proveedor;


import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

public class SAProveedorTest {
	
	@Test
	public void registrarProveedorExito(){
		SAProveedor saProveedor = new SAProveedorImp();
		
		TProveedor tProveedor = new TProveedor("nombreTest","666666666","test@test.es","test");
		try{
			int res = saProveedor.registrarProveedor(tProveedor);
			assertTrue(res > 0); //registrado correctamente
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void registrarProveedorFallo(){
		SAProveedor saProveedor = new SAProveedorImp();
		
		TProveedor tProveedor = new TProveedor("nombreTest","666666666","test@test.es","test");
		try{
			int res = saProveedor.registrarProveedor(tProveedor);
			assertTrue(res <= 0); //registrado sin exito porque hay un proveedor con el mismo nombre
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	
	@Test
	public void editarProveedorExito(){
		SAProveedor saProveedor = new SAProveedorImp();
		
		TProveedor tProveedor = new TProveedor("nombreTestEditado","666666666","test@test.es","editado");
		try{
			int res = saProveedor.editarProveedor(tProveedor);
			assertTrue(res > 0); //editado correctamente
		}catch(Exception e){
			fail(e.getMessage());
		}
	
	}
	
	@Test
	public void editarProveedorFallo(){
		SAProveedor saProveedor = new SAProveedorImp();
		
		TProveedor tProveedor = new TProveedor("nombreTest","666666666","test@test.es","editado");
		try{
			int res = saProveedor.editarProveedor(tProveedor);
			assertTrue(res <= 0); //editado sin exito porque hay un proveedor con el mismo nombre
		}catch(Exception e){
			fail(e.getMessage());
		}
	}
	
	@Test
	public void buscarProveedorPorIdExito(){
		SAProveedor saProveedor = new SAProveedorImp();
		
		int id = 1;
		try{
			TProveedor tProveedor = saProveedor.buscarProveedorPorId(id);
			assertTrue(tProveedor != null); //encontrado correctamente
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void buscarProveedorPorIdFallo(){
		SAProveedor saProveedor = new SAProveedorImp();
		
		int id = 2000;
		try{
			TProveedor tProveedor = saProveedor.buscarProveedorPorId(id);
			assertTrue(tProveedor == null); //proveedor no encontrado
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	
	@Test
	public void borrarProveedorExito(){
		SAProveedor saProveedor = new SAProveedorImp();
		
		int id = 12;
		try{
			int res = saProveedor.borrarProveedor(id);
			assertTrue(res > 0); //borrado correctamente
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void borrarProveedorFallo(){
		SAProveedor saProveedor = new SAProveedorImp();
		
		int id = 2000;
		try{
			int res = saProveedor.borrarProveedor(id);
			assertTrue(res <= 0); //borrar sin exito porque no existe el id
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	
	@Test
	public void listarProveedoresExito(){
		SAProveedor saProveedor = new SAProveedorImp();
		
		try{
			List<TProveedor> res = saProveedor.listarProveedores();
			assertTrue(res != null); //Proveedores listados
		}catch(Exception e) { fail(e.getMessage());}
		
	}
	

}
