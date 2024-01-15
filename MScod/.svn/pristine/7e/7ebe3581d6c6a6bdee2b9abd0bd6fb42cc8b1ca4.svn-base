package presentacion.command.pase;

import java.util.List;

import negocio.factoria_sa.SAFactoria;
import negocio.pase.TPase;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarListaPaseCommand implements Command {

	public Context execute(Object data) {
		Context context;
		List<TPase> res;
		try {
			res = SAFactoria.getInstancia().generarSAPase().mostrarListaPases();
			if (res != null)
				context = new Context(Evento.MOSTRAR_LISTA_PASE_OK, res);
			else
				context = new Context(Evento.MOSTRAR_LISTA_PASE_KO, "No hay Pases que mostrar.");
		} catch (Exception e) {
			context = new Context(Evento.MOSTRAR_LISTA_PASE_KO, e.getMessage());
		}
		
		return context;
	}
}
