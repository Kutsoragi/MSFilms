package presentacion.command.empleado;

import java.util.List;

import negocio.empleado.TEmpleado;
import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarListaEmpleadoCommand implements Command {

	public Context execute(Object data) {
		Context context;
		List<TEmpleado> res;
		try {
			res = SAFactoria.getInstancia().generarSAEmpleado().mostrarListaEmpleados();
			if (res != null)
				context = new Context(Evento.MOSTRAR_LISTA_EMPLEADO_OK, res);
			else
				context = new Context(Evento.MOSTRAR_LISTA_EMPLEADO_KO, "No hay Empleados que mostrar.");
		} catch (Exception e) {
			context = new Context(Evento.MOSTRAR_LISTA_EMPLEADO_KO, e.getMessage());
		}
		
		return context;
	}
}
