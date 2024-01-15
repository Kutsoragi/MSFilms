package presentacion.command.marca;

import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarCaloriasMediasDeMarcaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			int res = SAFactoria.getInstancia().generarSAMarca().obtenerCaloriasMediasDeMarca((Integer) data);
			
			if (res > -1)
				context = new Context(Evento.MOSTRAR_CALORIAS_MEDIAS_DE_MARCA_OK, res);
			else
				context = new Context(Evento.MOSTRAR_CALORIAS_MEDIAS_DE_MARCA_KO, "No se pudieron obtener las calorias medias de la Marca con ID " + Integer.toString((Integer) data) + ".");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.MOSTRAR_CALORIAS_MEDIAS_DE_MARCA_KO, e.getMessage());
		}
		
		return context;
	}
}
