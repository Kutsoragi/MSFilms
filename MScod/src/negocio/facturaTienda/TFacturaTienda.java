/**
 * 
 */
package negocio.facturaTienda;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TFacturaTienda {
	private int id;
	private double precio;
	private String fecha;

	public TFacturaTienda(){
		fecha = fechaActual();
	}
	
	public TFacturaTienda(int id, String fecha, int precio) {
		if (id < 1) throw new IllegalArgumentException("ID incorrecto.");
		if (precio < 0) throw new IllegalArgumentException("Precio incorrecto.");
		
		this.id = id;
		this.fecha = fecha;
		this.precio = precio;
	}
	
	public TFacturaTienda(int id, int precio, String fecha) {
		if (id < 1) throw new IllegalArgumentException("ID incorrecto.");
		if (precio < 0) throw new IllegalArgumentException("Precio incorrecto.");
		
		this.id = id;
		this.fecha = fecha;
		this.precio = precio;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

	public String getFecha() {
		return fecha;
	}
	
	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	private String fechaActual(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return df.format(date);
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}