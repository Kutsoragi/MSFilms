package presentacion.command.marca;

import java.util.List;

import negocio.factoria_sa.SAFactoria;
import negocio.marca.TMarca;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarMarcasCommand implements Command {

	public Context execute(Object data) {
		Context context;
		List<TMarca> res = SAFactoria.getInstancia().generarSAMarca().mostrarMarcas();
		if (res != null)
			context = new Context(Evento.MOSTRAR_MARCAS_OK, res);
		else
			context = new Context(Evento.MOSTRAR_MARCAS_KO, "No hay Marcas que mostrar.");
		
		return context;
	}
}
