package presentacion.command.factura_tienda;

import negocio.factoria_sa.SAFactoria;
import negocio.facturaTienda.TCarritoTienda;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class QuitarProductoCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			TCarritoTienda res = SAFactoria.getInstancia().generarSAFacturaTienda().quitarProducto((TCarritoTienda) data);
			if (res != null)
				context = new Context(Evento.QUITAR_PRODUCTO_OK, res);
			else
				context = new Context(Evento.QUITAR_PRODUCTO_KO, "Producto no encontrado en la Factura.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.QUITAR_PRODUCTO_KO, e.getMessage());
		}
		return context;
	}
}
