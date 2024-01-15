package negocio.facturaTienda;

import javax.persistence.*;

import negocio.producto.Producto;

@Entity
@Table(name = "linea_factura_tienda")

@NamedQueries({
	@NamedQuery(name = "negocio.facturaTienda.LineaFacturaTienda.buscarLinea", query = "SELECT f FROM LineaFacturaTienda f WHERE f.idLinea = :id")
  })
public class LineaFacturaTienda {

	@EmbeddedId @GeneratedValue(strategy = GenerationType.IDENTITY)
	private LineaFacturaTiendaID idLinea;
	
	@ManyToOne
	@MapsId("idFactura")
	private FacturaTienda factura;
	
	@ManyToOne
	@MapsId("idProducto")
	private Producto producto;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "precio")
	private double precio;
	
	@Version
	private int version;
	
	public LineaFacturaTienda(){
		
	}
	
	public LineaFacturaTienda(int idFactura, int idProducto){
		idLinea = new LineaFacturaTiendaID(idFactura, idProducto);
	}

	public LineaFacturaTiendaID getIdLinea() {
		return idLinea;
	}

	public void setIdLinea(LineaFacturaTiendaID idLinea) {
		this.idLinea = idLinea;
	}

	public FacturaTienda getFactura() {
		return factura;
	}

	public void setFactura(FacturaTienda factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
}
