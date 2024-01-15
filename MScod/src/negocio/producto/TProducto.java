package negocio.producto;


public abstract class TProducto {
	
	private Integer id;
	private Integer idProveedor;
	private Integer idMarca;
	private double precio;
	private Integer calorias;
	private Integer stock;
	private boolean activo;

	public TProducto(){
		
	}
	
	public TProducto(int id, int idProveedor, int idMarca, double precio, int stock, int calorias) {
		if (id < 1) throw new IllegalArgumentException("ID de Producto incorrecto.");
		if (idProveedor < 1) throw new IllegalArgumentException("ID de Proveedor incorrecto.");
		if (idMarca < 1) throw new IllegalArgumentException("ID de Marca incorrecto.");
		this.id = id;
		this.idProveedor = idProveedor;
		this.idMarca = idMarca;
		this.precio = precio;
		this.stock = stock;
		this.calorias = calorias;
	}
	
	public TProducto(int idProveedor, int idMarca, double precio, int stock, int calorias) {
		if (idProveedor < 1) throw new IllegalArgumentException("ID de Proveedor incorrecto.");
		if (idMarca < 1) throw new IllegalArgumentException("ID de Marca incorrecto.");
		this.idProveedor = idProveedor;
		this.idMarca = idMarca;
		this.precio = precio;
		this.stock = stock;
		this.calorias = calorias;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Integer id) {
		this.idProveedor = id;
	}
	
	public Integer getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Integer id) {
		this.idMarca = id;
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

	public abstract Integer getPeso();
	public abstract void setPeso(Integer tamanyo);
	public abstract Integer getVolumen();
	public abstract void setVolumen(Integer volumen);
}