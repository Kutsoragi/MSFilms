package presentacion.command.producto;

import java.util.List;

import negocio.factoria_sa.SAFactoria;
import negocio.producto.TProducto;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarProductosCommand implements Command {

	public Context execute(Object data) {
		Context context;
		List<TProducto> res = SAFactoria.getInstancia().generarSAProducto().mostrarProductos();
		if (res != null)
			context = new Context(Evento.MOSTRAR_PRODUCTOS_OK, res);
		else
			context = new Context(Evento.MOSTRAR_PRODUCTOS_KO, "No hay Productos que mostrar.");
		
		return context;
	}
}
