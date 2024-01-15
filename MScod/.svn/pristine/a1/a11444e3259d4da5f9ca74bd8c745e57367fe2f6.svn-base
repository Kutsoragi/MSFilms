package negocio.marca;

public class TMarca {

	private int id;
	private String nombre;
	private boolean activo;

	public TMarca() {}
	
	public TMarca(String nombre) {
		if (nombre.trim().length() == 0) throw new IllegalArgumentException("Nombre incorrecto.");
		
		this.id = 0;
		this.nombre = nombre;
	}
	
	public TMarca(int id, String nombre) {
		if (id < 1) throw new IllegalArgumentException("ID incorrecto.");
		if (nombre.trim().length() == 0) throw new IllegalArgumentException("Nombre incorrecto.");
		
		this.id = id;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public boolean getActivo() {
		return activo;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setActivo(boolean activo) {
		this.activo = activo;
	}
}
