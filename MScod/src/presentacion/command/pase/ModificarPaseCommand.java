package presentacion.command.pase;

import negocio.factoria_sa.SAFactoria;
import negocio.pase.TPase;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class ModificarPaseCommand implements Command {

	public Context execute(Object data) {
		Context context;	
		int res;
		try {
			res = SAFactoria.getInstancia().generarSAPase().modificarPase((TPase) data);
			if (res > 0)
				context = new Context(Evento.MODIFICAR_PASE_OK, "Pase modificado con éxito.");
			else
				context = new Context(Evento.MODIFICAR_PASE_KO, "Hubo un error al modificar el pase.");
		} catch (Exception e) {
			context = new Context(Evento.MODIFICAR_PASE_KO, e.getMessage());
		}
		
		return context;
	}
}
