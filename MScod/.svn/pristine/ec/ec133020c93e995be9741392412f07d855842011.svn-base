package presentacion.command.proveedor;

import java.util.List;

import negocio.factoria_sa.SAFactoria;
import negocio.proveedor.TProveedor;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarProveedoresCommand implements Command {

	public Context execute(Object data) {
		Context context;
		List<TProveedor> res = SAFactoria.getInstancia().generarSAProveedor().listarProveedores();
		if (res != null)
			context = new Context(Evento.MOSTRAR_PROVEEDORES_OK, res);
		else
			context = new Context(Evento.MOSTRAR_PROVEEDORES_KO, "No hay Proveedores que mostrar.");
		
		return context;
	}
}
