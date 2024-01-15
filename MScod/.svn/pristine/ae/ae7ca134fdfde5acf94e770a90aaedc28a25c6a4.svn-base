package presentacion.command.proveedor;

import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class BorrarProveedorCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			int res = SAFactoria.getInstancia().generarSAProveedor().borrarProveedor((Integer) data);
			if (res > 0)
				context = new Context(Evento.BORRAR_PROVEEDOR_OK, "Proveedor borrado con éxito.");
			else
				context = new Context(Evento.BORRAR_PROVEEDOR_KO, "Proveedor no encontrado.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.BORRAR_PROVEEDOR_KO, e.getMessage());
		}
		
		return context;
	}
}
