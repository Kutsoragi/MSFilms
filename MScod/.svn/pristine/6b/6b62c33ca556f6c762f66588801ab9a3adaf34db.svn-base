package presentacion.command.proveedor;

import negocio.factoria_sa.SAFactoria;
import negocio.proveedor.TProveedor;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class RegistrarProveedorCommand implements Command {
	
	public Context execute(Object data) {
		Context context;
		int res = SAFactoria.getInstancia().generarSAProveedor().registrarProveedor((TProveedor) data);
		if (res > 0)
			context = new Context(Evento.REGISTRAR_PROVEEDOR_OK, "Proveedor registrado con ID: " + res + ".");
		else
			context = new Context(Evento.REGISTRAR_PROVEEDOR_KO, "El Proveedor no se pudo registrar con éxito.");
		
		return context;
	}
}
