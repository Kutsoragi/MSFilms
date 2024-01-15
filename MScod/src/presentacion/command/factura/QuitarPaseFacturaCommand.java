package presentacion.command.factura;

import negocio.factoria_sa.SAFactoria;
import negocio.factura.TCarrito;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class QuitarPaseFacturaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			TCarrito res = SAFactoria.getInstancia().generarSAFactura().quitarPase((TCarrito) data);
			if (res != null)
				context = new Context(Evento.QUITAR_PASE_OK, res);
			else
				context = new Context(Evento.QUITAR_PASE_KO, "Pase no encontrado en la Factura.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.QUITAR_PASE_KO, e.getMessage());
		}
		return context;
	}
}
