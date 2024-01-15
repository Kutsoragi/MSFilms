package presentacion.command.producto;

import negocio.factoria_sa.SAFactoria;
import negocio.producto.TProducto;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class RegistrarProductoCommand implements Command {

	public Context execute(Object data) {
		Context context;
		int res = SAFactoria.getInstancia().generarSAProducto().registrarProducto((TProducto) data);
		if (res > 0)
			context = new Context(Evento.REGISTRAR_PRODUCTO_OK, "Producto registrado con ID: " + res + ".");
		else
			context = new Context(Evento.REGISTRAR_PRODUCTO_KO, "Ya existe un Producto con ese Nombre.");
		
		return context;
	}
}
