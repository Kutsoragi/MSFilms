package presentacion.command.marca;

import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class BorrarMarcaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			int res = SAFactoria.getInstancia().generarSAMarca().borrarMarca((Integer) data);
			if (res > 0)
				context = new Context(Evento.BORRAR_MARCA_OK, "Marca borrada con éxito.");
			else
				context = new Context(Evento.BORRAR_MARCA_KO, "Marca no encontrada.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.BORRAR_MARCA_KO, e.getMessage());
		}
		
		return context;
	}
}
