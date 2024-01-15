package integracion.factura;

import java.util.LinkedList;

import negocio.factura.TFactura;

public interface DAOFactura {

	public int insertarFactura(TFactura tFactura);
	TFactura buscarFacturaPorID(int id);
	LinkedList<TFactura> mostrarListaFacturas();

}
