package negocio.producto;

import javax.persistence.*;

import negocio.marca.Marca;
import negocio.proveedor.Proveedor;


@Entity
@Table(name = "producto")
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries({
	@NamedQuery(name = "negocio.producto.Producto.buscarPorMasDeCiertoStock", query = "SELECT p FROM Producto p WHERE p.stock > :stock AND p.activo = 1"),
	@NamedQuery(name = "negocio.producto.Producto.mostrarProductos", query = "SELECT p FROM Producto p WHERE p.activo = 1")
})
public abstract class Producto {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	private Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "id_marca")
	private Marca marca;
	
	@Column(name = "precio")
	private double precio;
	
	@Column(name = "calorias")
	protected Integer calorias;
	
	@Column(name = "stock")
	private Integer stock;
	
	@Column(name = "activo", columnDefinition = "boolean default true")
	private boolean activo;
	
	@Version
	private Integer version;
	
	public Producto() {
	}
	
	public Producto(Integer id,double precio,Integer calorias,Integer version,Integer stock) {
		this.id=id;
		this.precio=precio;
		this.calorias=calorias;
		this.version=version;
		this.stock=stock;		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Integer getCalorias() {
		return calorias;
	}

	public void setCalorias(Integer calorias) {
		this.calorias = calorias;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}
	
	public abstract Integer calculateCalorias();
}