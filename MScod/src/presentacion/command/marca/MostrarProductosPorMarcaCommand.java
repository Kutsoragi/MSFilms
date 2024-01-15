package presentacion.command.marca;

import java.util.List;

import negocio.factoria_sa.SAFactoria;
import negocio.marca.TMarca;
import negocio.producto.TProducto;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarProductosPorMarcaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			List<TProducto> res = SAFactoria.getInstancia().generarSAMarca().buscarProductosPorMarca((TMarca) data);
			if (res != null && !res.isEmpty())
				context = new Context(Evento.MOSTRAR_PRODUCTOS_POR_MARCA_OK, res);
			else
				context = new Context(Evento.MOSTRAR_PRODUCTOS_POR_MARCA_KO, "No hay productos que mostrar.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.MOSTRAR_PRODUCTOS_POR_MARCA_KO, e.getMessage());
		}
		
		return context;
	}
}
