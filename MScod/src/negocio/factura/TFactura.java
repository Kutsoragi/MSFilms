package negocio.factura;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


public class TFactura {
	
	private int id, idEmpleado;
	private String fecha;

	public TFactura(){
		fecha = fechaActual();
	}
	
	public TFactura(int id, String fecha, int cantidadTotal, int idEmpleado) {
		if (id < 1) throw new IllegalArgumentException("ID incorrecto.");
		if (cantidadTotal < 0) throw new IllegalArgumentException("Cantidad Total negativa.");
		
		this.id = id;
		this.fecha = fecha;
		this.idEmpleado = idEmpleado;
	}
	
	public TFactura(int id, int idEmpleado, String fecha) {//Constructor para el daoFactura
		if (id < 1 || idEmpleado < 1) throw new IllegalArgumentException("ID incorrecto.");
		
		this.id = id;
		this.fecha = fecha;
		this.idEmpleado = idEmpleado;
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
	
	private String fechaActual(){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		return df.format(date);
	}
	
	public int getIdEmpleado() {
		return idEmpleado;
	}
	
	public void setIdEmpleado(int idEmpleado){
		this.idEmpleado = idEmpleado;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}
