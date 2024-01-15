package presentacion.command.pelicula;

import negocio.factoria_sa.SAFactoria;
import negocio.pelicula.TPelicula;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class ModificarPeliculaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		int res;
		try {
			res = SAFactoria.getInstancia().generarSAPelicula().modificarPelicula((TPelicula) data);
			if (res > 0)
				context = new Context(Evento.MODIFICAR_PELICULA_OK, "Pélicula modificada con éxito.");
			else
				context = new Context(Evento.MODIFICAR_PELICULA_KO, "Pélicula no encontrada.");
		} catch (Exception e) {
			context = new Context(Evento.MODIFICAR_PELICULA_KO, e.getMessage());
		}
		
		return context;
	}
}
