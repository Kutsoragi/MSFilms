package presentacion.command.proveedor;

import negocio.factoria_sa.SAFactoria;
import negocio.proveedor.TProveedor;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class ModificarProveedorCommand implements Command {

	public Context execute(Object data) {
		Context context;
		int res = SAFactoria.getInstancia().generarSAProveedor().editarProveedor((TProveedor) data);
		if (res > 0)
			context = new Context(Evento.MODIFICAR_PROVEEDOR_OK, "Proveedor modificado con éxito.");
		else
			context = new Context(Evento.MODIFICAR_PROVEEDOR_KO, "Proveedor no encontrado.");
		
		return context;
	}
}
