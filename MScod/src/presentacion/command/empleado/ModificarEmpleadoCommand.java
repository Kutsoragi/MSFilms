package presentacion.command.empleado;

import negocio.empleado.TEmpleado;
import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class ModificarEmpleadoCommand implements Command {

	public Context execute(Object data) {
		Context context;		
		int res;
		try {
			res = SAFactoria.getInstancia().generarSAEmpleado().modificarEmpleado((TEmpleado) data);
			if (res > 0)
				context = new Context(Evento.MODIFICAR_EMPLEADO_OK, "Empleado modificado con éxito.");
			else
				context = new Context(Evento.MODIFICAR_EMPLEADO_KO, "Empleado no encontrado.");
		} catch (Exception e) {
			context = new Context(Evento.MODIFICAR_EMPLEADO_KO, e.getMessage());
		}
		
		return context;
	}
}
