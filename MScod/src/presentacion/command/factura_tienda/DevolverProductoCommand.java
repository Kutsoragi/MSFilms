package presentacion.command.factura_tienda;

import negocio.factoria_sa.SAFactoria;
import negocio.facturaTienda.TLineaFacturaTienda;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class DevolverProductoCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			boolean res = SAFactoria.getInstancia().generarSAFacturaTienda().devolverProducto((TLineaFacturaTienda) data);
			if (res)
				context = new Context(Evento.DEVOLVER_PRODUCTO_OK, "Productos devueltos correctamente.");
			else
				context = new Context(Evento.DEVOLVER_PRODUCTO_KO, "Producto no encontrado en la Factura.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.DEVOLVER_PRODUCTO_KO, e.getMessage());
		}
		
		return context;
	}
}
