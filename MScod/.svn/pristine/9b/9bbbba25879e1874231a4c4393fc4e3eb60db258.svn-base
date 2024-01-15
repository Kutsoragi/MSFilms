package presentacion.command.producto;

import negocio.factoria_sa.SAFactoria;
import negocio.producto.TProducto;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class ModificarProductoCommand implements Command {

	public Context execute(Object data) {
		Context context;		
		int res = SAFactoria.getInstancia().generarSAProducto().editarProducto((TProducto) data);
		if (res > 0)
			context = new Context(Evento.MODIFICAR_PRODUCTO_OK, "Producto modificado con éxito.");
		else
			context = new Context(Evento.MODIFICAR_PRODUCTO_KO, "Producto no encontrado.");
		
		return context;
	}
}
