package presentacion.command.factura;

import negocio.factoria_sa.SAFactoria;
import negocio.factura.TLineaFactura;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class DevolverPaseFacturaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			boolean res = SAFactoria.getInstancia().generarSAFactura().devolverPase((TLineaFactura) data);
			if (res)
				context = new Context(Evento.DEVOLVER_PASE_OK, "Pases devueltos correctamente.");
			else
				context = new Context(Evento.DEVOLVER_PASE_KO, "Pase no encontrado en la Factura.");
		} catch(Exception e) {
			context = new Context(Evento.DEVOLVER_PASE_KO, e.getMessage());
		}
		
		return context;
	}
}
