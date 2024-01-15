package presentacion.command.pelicula;

import negocio.factoria_sa.SAFactoria;
import negocio.pelicula.TPelicula;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class RegistrarPeliculaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		int res;
		try {
			res = SAFactoria.getInstancia().generarSAPelicula().registrarPelicula((TPelicula) data);
			if (res > 0)
				context = new Context(Evento.REGISTRAR_PELICULA_OK, "Pélicula registrada con ID: " + res + ".");
			else
				context = new Context(Evento.REGISTRAR_PELICULA_KO, "La Pélicula no se pudo registrar con éxito.");
		} catch (Exception e) {
			context = new Context(Evento.REGISTRAR_PELICULA_KO, e.getMessage());
		}
		
		return context;
	}
}
