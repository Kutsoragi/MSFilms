package presentacion.command.factura_tienda;

import negocio.factoria_sa.SAFactoria;
import negocio.facturaTienda.TCarritoTienda;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class AnadirProductoCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			TCarritoTienda res = SAFactoria.getInstancia().generarSAFacturaTienda().añadirProducto((TCarritoTienda) data);
			if (res != null)
				context = new Context(Evento.AÑADIR_PRODUCTO_OK, res);
			else
				context = new Context(Evento.AÑADIR_PRODUCTO_KO, "Producto no encontrado.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.AÑADIR_PRODUCTO_KO, e.getMessage());
		}
		
		return context;
	}
}
