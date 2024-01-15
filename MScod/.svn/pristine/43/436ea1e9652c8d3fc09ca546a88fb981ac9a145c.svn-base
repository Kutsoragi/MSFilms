package negocio.factoria_sa;
import negocio.empleado.SAEmpleado;
import negocio.empleado.SAEmpleadoImpl;
import negocio.factura.SAFactura;
import negocio.factura.SAFacturaImpl;
import negocio.facturaTienda.SAFacturaTienda;
import negocio.facturaTienda.SAFacturaTiendaImp;
import negocio.marca.SAMarca;
import negocio.marca.SAMarcaImp;
import negocio.pase.SAPase;
import negocio.pase.SAPaseImpl;
import negocio.pelicula.SAPelicula;
import negocio.pelicula.SAPeliculaImpl;
import negocio.producto.SAProducto;
import negocio.producto.SAProductoImp;
import negocio.proveedor.SAProveedor;
import negocio.proveedor.SAProveedorImp;

public class SAFactoriaImpl extends SAFactoria{

	@Override
	public SAPelicula generarSAPelicula() {
		return new SAPeliculaImpl();
	}

	@Override
	public SAPase generarSAPase() {
		return new SAPaseImpl();
	}

	@Override
	public SAEmpleado generarSAEmpleado() {
		return new SAEmpleadoImpl();
	}

	@Override
	public SAFactura generarSAFactura() {
		return new SAFacturaImpl();
	}
	
	@Override
	public SAMarca generarSAMarca() {
		return new SAMarcaImp();
	}

	@Override
	public SAProveedor generarSAProveedor() {
		return new SAProveedorImp();
	}

	@Override
	public SAProducto generarSAProducto() {
		return new SAProductoImp();
	}

	@Override
	public SAFacturaTienda generarSAFacturaTienda() {
		return new SAFacturaTiendaImp();
	}
}
