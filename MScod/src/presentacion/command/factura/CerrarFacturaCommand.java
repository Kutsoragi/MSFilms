package presentacion.command.factura;

import negocio.factoria_sa.SAFactoria;
import negocio.factura.TCarrito;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class CerrarFacturaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			boolean res = SAFactoria.getInstancia().generarSAFactura().cerrarFactura((TCarrito) data);
			if (res) //La factura se cerro con exito
				context = new Context(Evento.CERRAR_FACTURA_OK, "La factura ha sido registrada con éxito.");
			else
				context = new Context(Evento.CERRAR_FACTURA_KO, "Ha habido un error al validar los datos.");
		} catch(Exception e) {
			context = new Context(Evento.CERRAR_FACTURA_KO, e.getMessage());
		}
		
		return context;
	}
}
