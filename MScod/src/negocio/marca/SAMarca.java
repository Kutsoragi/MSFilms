/**
 * 
 */
package negocio.marca;

import java.util.List;

import negocio.producto.TProducto;


public interface SAMarca {
	
	public int registrarMarca(TMarca tMarca);

	public int editarMarca(TMarca tMarca);

	public int borrarMarca(int id);
	
	public TMarca buscarMarcaPorId(int id);

	public List<TMarca> mostrarMarcas();
	
	public List<TProducto> buscarProductosPorMarca(TMarca marca);
	
	public int obtenerCaloriasMediasDeMarca(int idMarca);
}