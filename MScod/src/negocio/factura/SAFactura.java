package negocio.factura;

import java.util.LinkedList;

public interface SAFactura {
	
	public TCarrito abrirFactura ();
	public TCarrito añadirPase(TCarrito carrito) throws Exception;
	public TCarrito quitarPase(TCarrito carrito);
	public boolean cerrarFactura(TCarrito carrito) throws Exception;
	
	public TCarrito buscarFacturaPorID(int id) throws Exception;
	public LinkedList<TCarrito> listarFacturas() throws Exception;
	
	public boolean devolverPase(TLineaFactura lineaFactura) throws Exception;
}
