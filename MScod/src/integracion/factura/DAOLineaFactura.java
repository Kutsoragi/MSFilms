package integracion.factura;

import java.util.LinkedList;

import negocio.factura.TLineaFactura;

public interface DAOLineaFactura {
	public void insertarLineaFactura(TLineaFactura tLineaFactura);
	public TLineaFactura buscarLinea(int idFactura, int idPase);
	public LinkedList<TLineaFactura> mostrarLineas(int idFactura);
	public void modificarLinea(TLineaFactura tLineaFactura);
	public void eliminarLinea(TLineaFactura tLineaFactura);
}
