package presentacion.command.marca;

import negocio.factoria_sa.SAFactoria;
import negocio.marca.TMarca;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class ModificarMarcaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		int res = SAFactoria.getInstancia().generarSAMarca().editarMarca((TMarca) data);
		if (res > 0)
			context = new Context(Evento.MODIFICAR_MARCA_OK, "Marca modificada con éxito.");
		else
			context = new Context(Evento.MODIFICAR_MARCA_KO, "Marca no encontrada.");
		
		return context;
	}
}
