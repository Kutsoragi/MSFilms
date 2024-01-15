package negocio.facturaTienda;

public class TLineaFacturaTienda {
	
	private int idFactura;
	private int idProducto;
	private int cantidad;
	private double precio;
	
	public TLineaFacturaTienda() {
		
	}
	
	public TLineaFacturaTienda(int idFactura, int idProducto, int cantidad) {
		if (idFactura < 1) throw new IllegalArgumentException("ID de Factura incorrecto.");
		if (idProducto < 1) throw new IllegalArgumentException("ID de Producto incorrecto.");
		if (cantidad < 1) throw new IllegalArgumentException("Cantidad insuficiente para devolver.");
		
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	public TLineaFacturaTienda(int idProducto, int cantidad) {
		if (idProducto < 1) throw new IllegalArgumentException("ID de Producto incorrecto.");
		if (cantidad < 1) throw new IllegalArgumentException("Cantidad insuficiente para devolver.");
		
		this.idProducto = idProducto;
		this.cantidad = cantidad;
	}
	
	public TLineaFacturaTienda(int idFactura, int idProducto, int cantidad, int precio) {
		if (idFactura < 1) throw new IllegalArgumentException("ID de Factura incorrecto.");
		if (idProducto < 1) throw new IllegalArgumentException("ID de Producto incorrecto.");
		if (cantidad < 1) throw new IllegalArgumentException("Cantidad insuficiente para devolver.");
		
		this.idFactura = idFactura;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.precio = precio;
	}
	
	public int getIdFactura() {
		return idFactura;
	}
	
	public int getIdProducto() {
		return idProducto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
}