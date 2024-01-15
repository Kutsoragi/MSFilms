package negocio.factoria_sa;

import negocio.empleado.SAEmpleado;
import negocio.factura.SAFactura;
import negocio.facturaTienda.SAFacturaTienda;
import negocio.marca.SAMarca;
import negocio.pase.SAPase;
import negocio.pelicula.SAPelicula;
import negocio.producto.SAProducto;
import negocio.proveedor.SAProveedor;

public abstract class SAFactoria {
	
	private static SAFactoria instancia;
	
	public synchronized static SAFactoria getInstancia(){
		if(instancia == null){
			instancia = new SAFactoriaImpl();
		}
		return instancia;
	}
	
	// DAO
	public abstract SAPelicula generarSAPelicula();
	public abstract SAPase generarSAPase();
	public abstract SAEmpleado generarSAEmpleado();
	public abstract SAFactura generarSAFactura();
	
	// JPA
	public abstract SAMarca generarSAMarca();
	public abstract SAProveedor generarSAProveedor();
	public abstract SAProducto generarSAProducto();
	public abstract SAFacturaTienda generarSAFacturaTienda();
}
