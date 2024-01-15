package negocio.facturaTienda;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

import negocio.producto.Producto;

@Entity
@Table(name = "factura_tienda")

/*@NamedQueries({
	@NamedQuery(name = "negocio.facturaTienda.FacturaTienda.mostrarFacturas", query = "SELECT f FROM FacturaTienda f")
  })*/
 
public class FacturaTienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura_tienda")
	private int id;

	@Column(name = "precio")
	private double precio;

	@Column(name = "fecha")
	@Temporal(TemporalType.DATE)
	private Calendar fecha;

	@OneToMany(mappedBy = "factura")
	private List<LineaFacturaTienda> lineasFactura;

	@Version
	private int version;

	public FacturaTienda() {
	}

	public FacturaTienda(List<Producto> listaProductos, double precio, Calendar fecha, boolean activo) {
		this.precio = precio;
		this.fecha = fecha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getFecha() {
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = format1.format(this.fecha.getTime());
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public List<LineaFacturaTienda> getLineasFactura() {
		return lineasFactura;
	}

	public void setLineasFactura(List<LineaFacturaTienda> lineasFactura) {
		this.lineasFactura = lineasFactura;
	}


}