package negocio.proveedor;


public class TProveedor {
	
	
	private int id;
	private String nombre, telefono, email, direccion;
	private boolean activo;

	public TProveedor() {}
	
	public TProveedor(String nombre, String telefono, String email, String direccion) {
		if (nombre.trim().length() == 0) throw new IllegalArgumentException("Nombre incorrecto.");
		if (!telefono.trim().matches("^[6-9][0-9]{8}$") || telefono.trim().length() == 0) throw new IllegalArgumentException("Telefono incorrecto. Formato: [6-9]XX XX XX XX");
		if (!email.trim().matches("^\\w+@\\w+\\.\\w+$") || email.trim().length() == 0) throw new IllegalArgumentException("Email incorrecto. Formato: palabra@palabra.palabra");
		if (direccion.trim().length() == 0) throw new IllegalArgumentException("Direccion incorrecta.");
		
		this.id = 0;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}
	
	public TProveedor(int id, String nombre, String telefono, String email, String direccion) {
		if (id < 1) throw new IllegalArgumentException("ID incorrecto.");
		if (nombre.trim().length() == 0) throw new IllegalArgumentException("Nombre incorrecto.");
		if (!telefono.trim().matches("^[6-9][0-9]{8}$") || telefono.trim().length() == 0) throw new IllegalArgumentException("Telefono incorrecto. Formato: [6-9]XX XX XX XX");
		if (!email.trim().matches("^\\w+@\\w+\\.\\w+$") || email.trim().length() == 0) throw new IllegalArgumentException("Email incorrecto. Formato: palabra@palabra.palabra");
		if (direccion.trim().length() == 0) throw new IllegalArgumentException("Direccion incorrecta.");
		
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getDireccion() {
		return this.direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public boolean getActivo() {
		return this.activo;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

}