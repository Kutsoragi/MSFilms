package negocio.proveedor;

import java.util.List;

import javax.persistence.*;

import negocio.producto.Producto;
@Entity
@Table(name = "proveedores")
@NamedQueries({
	@NamedQuery(name = "negocio.proveedor.Proveedor.buscarPorNombre", query = "SELECT p FROM Proveedor p WHERE p.nombre = :nombre")
})
public class Proveedor {
		
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_proveedor")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "num_telefono")
	private String numeroTelefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "direccion")
	private String direccion;
	
	@Column(name = "activo", columnDefinition = "boolean default true")
	private boolean activo;
	
	@OneToMany(mappedBy = "proveedor")
	private List<Producto> listaProductos;
	
	@Version
	private int version;
	
	public Proveedor(){
	}

	public Proveedor(String nombre,String numeroTelefono, String email, String direccion, boolean activo) {
		this.nombre = nombre;
		this.numeroTelefono = numeroTelefono;
		this.email = email;
		this.direccion = direccion;
		this.activo = activo;
	}
	
	public int getId() {

		return this.id;
	}

	public void setId(int id) {
		this.id=id;
	}

	public int getVersion() {
		return version;
	}
	
	public void setVersion(int version) {
		this.version = version;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	
	public String getNumeroTelefono() {
		return this.numeroTelefono;
	}

	public void setNumeroTelefono(String  string) {
		this.numeroTelefono= string;
	}
	
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email=email;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion=direccion;
	}
	
	public List<Producto> getListaProductos(){
		return listaProductos;
	}
	
	public void setListaProductos(List<Producto> listaProductos){
		this.listaProductos = listaProductos;
	}
	
	public boolean isActivo() {
		return this.activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo=activo;
	}
}