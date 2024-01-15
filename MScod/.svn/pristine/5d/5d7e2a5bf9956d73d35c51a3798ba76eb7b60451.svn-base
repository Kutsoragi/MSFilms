package presentacion.command.pelicula;

import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class BorrarPeliculaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			int res = SAFactoria.getInstancia().generarSAPelicula().borrarPelicula((Integer) data);
			if (res > 0)
				context = new Context(Evento.BORRAR_PELICULA_OK, "Pélicula borrada con éxito.");
			else
				context = new Context(Evento.BORRAR_PELICULA_KO, "Pélicula no encontrada.");
		} catch(Exception e) {
			context = new Context(Evento.BORRAR_PELICULA_KO, e.getMessage());
		}
		
		return context;
	}
}
