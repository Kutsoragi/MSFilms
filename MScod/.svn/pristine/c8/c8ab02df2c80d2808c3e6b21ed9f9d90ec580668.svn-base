package integracion.factoria_dao;
import integracion.empleado.DAOEmpleado;
import integracion.empleado.DAOEmpleadoImpl;
import integracion.factura.DAOFactura;
import integracion.factura.DAOFacturaImpl;
import integracion.factura.DAOLineaFactura;
import integracion.factura.DAOLineaFacturaImpl;
import integracion.pase.DAOPase;
import integracion.pase.DAOPaseImpl;
import integracion.pelicula.DAOPelicula;
import integracion.pelicula.DAOPeliculaImpl;

public class DAOFactoriaImpl extends DAOFactoria{
	
	public DAOPelicula generarDAOPelicula() {
		return new DAOPeliculaImpl();
	}

	public DAOPase generarDAOPase() {
		return new DAOPaseImpl();
	}
	
	public DAOEmpleado generarDAOEmpleado() {
		return new DAOEmpleadoImpl();
	}

	public DAOFactura generarDAOFactura() {
		return new DAOFacturaImpl();
	}
	
	public DAOLineaFactura generarDAOLineaFactura() {
		return new DAOLineaFacturaImpl();
	}

}
