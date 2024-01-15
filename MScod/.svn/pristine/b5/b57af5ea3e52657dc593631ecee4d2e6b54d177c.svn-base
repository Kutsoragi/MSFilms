/**
 * 
 */
package negocio.facturaTienda;

import java.util.LinkedList;


public class TCarritoTienda {
	
	private TFacturaTienda factura;
	private LinkedList<TLineaFacturaTienda> lineasFactura;
	
	// atributos auxiliares para añadir y quitiar productos
	private int idProductoAux;
	private int cantidadAux;
	
	private double precioTotal;
	
	public TCarritoTienda() {
		this.factura = new TFacturaTienda();
		this.lineasFactura = new LinkedList<TLineaFacturaTienda>();
		
		this.precioTotal = 0;
	}
	
	public TCarritoTienda(TFacturaTienda factura) {
		this.factura = factura;
		this.lineasFactura = new LinkedList<TLineaFacturaTienda>();
		
		this.precioTotal = 0;
	}
	
	public TCarritoTienda(TFacturaTienda factura, LinkedList<TLineaFacturaTienda> lineasFactura, double precioTotal) {
		this.factura = factura;
		this.lineasFactura = lineasFactura;
		this.precioTotal = precioTotal;
	}
	
	//-- 
	
		public TFacturaTienda getFactura() {
			return factura;
		}

		public LinkedList<TLineaFacturaTienda> getLineasFactura() {
			return this.lineasFactura;
		}

		public double getPrecioTotal() {
			return precioTotal;
		}
		
		public int getIdProductoAuxiliar() {
			return idProductoAux;
		}	
		
		public int getCantidadAuxiliar() {
			return cantidadAux;
		}	
		
		//-- 
		
		public void setPrecioTotal(double precioTotal) {
			this.precioTotal = precioTotal;
		}
		
		public void setIdProductoAuxiliar(int idProducto) {
			if (idProducto < 1)
				throw new IllegalArgumentException("ID de Producto incorrecto.");
			this.idProductoAux = idProducto;
		}
		
		public void setCantidadAuxiliar(int cantidad) {
			if (cantidad < 1)
				throw new IllegalArgumentException("Cantidad insuficiente para añadir.");
			this.cantidadAux = cantidad;
		}

}