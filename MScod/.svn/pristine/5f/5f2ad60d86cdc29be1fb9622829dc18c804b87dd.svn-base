package presentacion.command.empleado;

import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class BorrarEmpleadoCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			int res = SAFactoria.getInstancia().generarSAEmpleado().borrarEmpleado((Integer) data);
			if (res > 0)
				context = new Context(Evento.BORRAR_EMPLEADO_OK, "Empleado borrado con éxito.");
			else
				context = new Context(Evento.BORRAR_EMPLEADO_KO, "Empleado no encontrado.");
		} catch(Exception e) {
			context = new Context(Evento.BORRAR_EMPLEADO_KO, e.getMessage());
		}
		
		return context;
	}
}
