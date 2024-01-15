package negocio.facturaTienda;

import java.util.LinkedList;

public interface SAFacturaTienda {
	
	public TCarritoTienda abrirFactura(); //
	public TCarritoTienda añadirProducto(TCarritoTienda carrito); //
	public TCarritoTienda quitarProducto(TCarritoTienda carrito); //
	public boolean cerrarFactura(TCarritoTienda carrito);
	
	public boolean devolverProducto(TLineaFacturaTienda lineaFactura);
	public TCarritoTienda buscarFacturaPorId(int id);
	public LinkedList<TCarritoTienda> listarFacturas();
}