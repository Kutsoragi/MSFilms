package presentacion.command.producto;

import java.util.List;

import negocio.factoria_sa.SAFactoria;
import negocio.producto.TProducto;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarProductosConMasDeXStockCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			List<TProducto> res = SAFactoria.getInstancia().generarSAProducto().mostrarProductoConMasDeXstock((Integer) data);
			if (!res.isEmpty())
				context = new Context(Evento.MOSTRAR_PRODUCTOS_CON_MAS_DE_X_STOCK_OK, res);
			else
				context = new Context(Evento.MOSTRAR_PRODUCTOS_CON_MAS_DE_X_STOCK_KO, "No hay Productos que mostrar.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.MOSTRAR_PRODUCTOS_CON_MAS_DE_X_STOCK_KO, e.getMessage());
		}
		
		return context;
	}
}
