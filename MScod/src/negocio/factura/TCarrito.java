package negocio.factura;

import java.util.LinkedList;

public class TCarrito {
	private TFactura factura;
	private LinkedList<TLineaFactura> lineasFactura;
	
	// atributos auxiliares para añadir y quitiar pases
	private int idPaseAux;
	private int cantidadAux;
	
	private double precioTotal;
	
	public TCarrito() {
		this.factura = new TFactura();
		this.lineasFactura = new LinkedList<TLineaFactura>();
		
		this.precioTotal = 0;
	}
	
	public TCarrito(TFactura factura) {
		this.factura = factura;
		this.lineasFactura = new LinkedList<TLineaFactura>();
		
		this.precioTotal = 0;
	}
	
	public TCarrito(TFactura factura, LinkedList<TLineaFactura> lineasFactura, double precioTotal) {
		this.factura = factura;
		this.lineasFactura = lineasFactura;
		this.precioTotal = precioTotal;
	}

	//-- 
	
	public TFactura getFactura() {
		return factura;
	}

	public LinkedList<TLineaFactura> getLineasFactura() {
		return this.lineasFactura;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}
	
	public int getIdPaseAuxiliar() {
		return idPaseAux;
	}	
	
	public int getCantidadAuxiliar() {
		return cantidadAux;
	}	
	
	//-- 
	
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	
	public void setIdPaseAuxiliar(int idPase) {
		if (idPase < 1)
			throw new IllegalArgumentException("ID de Pase incorrecto.");
		this.idPaseAux = idPase;
	}
	
	public void setCantidadAuxiliar(int cantidad) {
		if (cantidad < 1)
			throw new IllegalArgumentException("Cantidad insuficiente para añadir.");
		this.cantidadAux = cantidad;
	}

}
