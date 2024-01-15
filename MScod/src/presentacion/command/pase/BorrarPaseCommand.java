package presentacion.command.pase;

import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class BorrarPaseCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			int res = SAFactoria.getInstancia().generarSAPase().borrarPase((Integer) data);
			if (res > 0)
				context = new Context(Evento.BORRAR_PASE_OK, "Pase borrado con éxito.");
			else
				context = new Context(Evento.BORRAR_PASE_KO, "Pase no encontrado.");
		} catch(Exception e) {
			context = new Context(Evento.BORRAR_PASE_KO, e.getMessage());
		}
		
		return context;
	}
}
