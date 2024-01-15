package presentacion.command.pelicula;

import negocio.factoria_sa.SAFactoria;
import negocio.pelicula.TPelicula;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class BuscarPeliculaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			TPelicula res = SAFactoria.getInstancia().generarSAPelicula().buscarPeliculaPorID((Integer) data);
			if (res != null)
				context = new Context(Evento.BUSCAR_PELICULA_OK, res);
			else
				context = new Context(Evento.BUSCAR_PELICULA_KO, "Pélicula no encontrada.");
		} catch(Exception e) {
			context = new Context(Evento.BUSCAR_PELICULA_KO, e.getMessage());
		}
		
		return context;
	}
}
