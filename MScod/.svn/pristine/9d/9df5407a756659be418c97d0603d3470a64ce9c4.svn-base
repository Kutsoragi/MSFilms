package presentacion.command.producto;

import negocio.factoria_sa.SAFactoria;
import negocio.producto.TProducto;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class BuscarProductoCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			TProducto res = SAFactoria.getInstancia().generarSAProducto().buscarProductoPorId((Integer) data);
			if (res != null)
				context = new Context(Evento.BUSCAR_PRODUCTO_OK, res);
			else
				context = new Context(Evento.BUSCAR_PRODUCTO_KO, "Producto no encontrado.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.BUSCAR_PRODUCTO_KO, e.getMessage());
		}
		
		return context;
	}

}
