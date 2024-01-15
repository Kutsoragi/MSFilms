package presentacion.command.marca;

import negocio.factoria_sa.SAFactoria;
import negocio.marca.TMarca;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class RegistrarMarcaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		int res = SAFactoria.getInstancia().generarSAMarca().registrarMarca((TMarca) data);
		if (res > 0)
			context = new Context(Evento.REGISTRAR_MARCA_OK, "Marca registrada con ID: " + res + ".");
		else
			context = new Context(Evento.REGISTRAR_MARCA_KO, "La Marca no se pudo registrar con éxito.");
		
		return context;
	}
}
