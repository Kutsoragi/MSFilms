package presentacion.command.producto;

import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class BorrarProductoCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			int res = SAFactoria.getInstancia().generarSAProducto().borrarProducto((Integer) data);
			if (res > 0)
				context = new Context(Evento.BORRAR_PRODUCTO_OK, "Producto borrado con éxito.");
			else
				context = new Context(Evento.BORRAR_PRODUCTO_KO, "Producto no encontrado.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.BORRAR_PRODUCTO_KO, e.getMessage());
		}
		
		return context;
	}
}
