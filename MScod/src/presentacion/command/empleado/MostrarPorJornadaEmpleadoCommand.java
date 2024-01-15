package presentacion.command.empleado;

import java.util.List;

import negocio.empleado.TEmpleado;
import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarPorJornadaEmpleadoCommand implements Command {

	public Context execute(Object data) {
		Context context;
		List<TEmpleado> res;
		try {
			res = SAFactoria.getInstancia().generarSAEmpleado().mostrarEmpleadosPorJornada((Boolean) data);
			if (!res.isEmpty())
				context = new Context(Evento.MOSTRAR_POR_JORNADA_EMPLEADO_OK, res);
			else
				context = new Context(Evento.MOSTRAR_POR_JORNADA_EMPLEADO_KO, "No hay Empleados que mostrar.");	
		} catch (Exception e) {
			context = new Context(Evento.MOSTRAR_POR_JORNADA_EMPLEADO_KO, e.getMessage());	
		}
		
		return context;
	}
}
