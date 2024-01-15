package presentacion.command.pase;

import java.util.List;

import negocio.factoria_sa.SAFactoria;
import negocio.pase.TPase;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarPorPeliculaPaseCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			List<TPase> res = SAFactoria.getInstancia().generarSAPase().mostrarPasesPorPelicula((Integer) data);
			if (res !=null){
				if (!res.isEmpty())
					context = new Context(Evento.MOSTRAR_POR_PELICULA_PASE_OK, res);
				else
					context = new Context(Evento.MOSTRAR_POR_PELICULA_PASE_KO, "No hay Pases que mostrar.");	
			}
			else{
				context = new Context(Evento.MOSTRAR_POR_PELICULA_PASE_KO, "No se encuentra la pelicula.");
			}
			
		} catch(Exception e) {
			context = new Context(Evento.MOSTRAR_POR_PELICULA_PASE_KO, e.getMessage());
		}
		
		return context;
	}
}
