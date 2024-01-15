package presentacion.command.proveedor;

import presentacion.command.Command;
import presentacion.controller.Context;

public class MostrarPorDineroCobradoTrasFechaCommand implements Command {

	public Context execute(Object data) {
		Context context = null;
		/*
		try {
			List<TProveedor> res = new ArrayList<TProveedor>(); // = SAFactoria.getInstancia().generarSAProveedor().mostrarQueryChunga((String) data);
			if (!res.isEmpty())
				context = new Context(Evento.MOSTRAR_POR_DINERO_COBRADO_TRAS_FECHA_PROVEEDOR_OK, res);
			else
				context = new Context(Evento.MOSTRAR_POR_DINERO_COBRADO_TRAS_FECHA_PROVEEDOR_KO, "No hay Proveedores que mostrar.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.MOSTRAR_POR_DINERO_COBRADO_TRAS_FECHA_PROVEEDOR_KO, e.getMessage());
		}
		*/
		return context;
	}
}
