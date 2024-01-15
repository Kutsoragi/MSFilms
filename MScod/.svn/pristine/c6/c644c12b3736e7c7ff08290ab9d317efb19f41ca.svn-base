package presentacion.command.proveedor;

import negocio.factoria_sa.SAFactoria;
import negocio.proveedor.TProveedor;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class BuscarProveedorCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			TProveedor res = SAFactoria.getInstancia().generarSAProveedor().buscarProveedorPorId((Integer) data);
			if (res != null)
				context = new Context(Evento.BUSCAR_PROVEEDOR_OK, res);
			else
				context = new Context(Evento.BUSCAR_PROVEEDOR_KO, "Proveedor no encontrado.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.BUSCAR_PROVEEDOR_KO, e.getMessage());
		}
		
		return context;
	}
}
