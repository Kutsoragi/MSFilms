package presentacion.command.marca;

import negocio.factoria_sa.SAFactoria;
import negocio.marca.TMarca;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class BuscarMarcaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			TMarca res = SAFactoria.getInstancia().generarSAMarca().buscarMarcaPorId((Integer) data);
			if (res != null)
				context = new Context(Evento.BUSCAR_MARCA_OK, res);
			else
				context = new Context(Evento.BUSCAR_MARCA_KO, "Marca no encontrada.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.BUSCAR_MARCA_KO, e.getMessage());
		}
		
		return context;
	}
}
