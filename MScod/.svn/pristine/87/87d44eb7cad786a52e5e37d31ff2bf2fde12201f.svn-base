package presentacion.command.pelicula;

import java.util.List;

import negocio.factoria_sa.SAFactoria;
import negocio.pelicula.TPelicula;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarListaPeliculaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		List<TPelicula> res;
		try {
			res = SAFactoria.getInstancia().generarSAPelicula().mostrarListaPeliculas();
			if (res != null)
				context = new Context(Evento.MOSTRAR_LISTA_PELICULA_OK, res);
			else
				context = new Context(Evento.MOSTRAR_LISTA_PELICULA_KO, "No hay Péliculas que mostrar.");
		} catch (Exception e) {
			context = new Context(Evento.MOSTRAR_LISTA_PELICULA_KO, e.getMessage());
		}
		
		return context;
	}
}
