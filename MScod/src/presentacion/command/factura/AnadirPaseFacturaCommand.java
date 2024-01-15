package presentacion.command.factura;

import negocio.factoria_sa.SAFactoria;
import negocio.factura.TCarrito;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class AnadirPaseFacturaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			TCarrito res = SAFactoria.getInstancia().generarSAFactura().añadirPase((TCarrito) data);
			if (res != null)
				context = new Context(Evento.AÑADIR_PASE_OK, res);
			else
				context = new Context(Evento.AÑADIR_PASE_KO, "Pase no encontrado.");
		} catch(Exception e) {
			context = new Context(Evento.AÑADIR_PASE_KO, e.getMessage());
		}
		
		return context;
	}
}
