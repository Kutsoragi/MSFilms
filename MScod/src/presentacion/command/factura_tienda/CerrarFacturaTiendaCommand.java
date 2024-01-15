package presentacion.command.factura_tienda;

import negocio.factoria_sa.SAFactoria;
import negocio.facturaTienda.TCarritoTienda;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class CerrarFacturaTiendaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			boolean res = SAFactoria.getInstancia().generarSAFacturaTienda().cerrarFactura((TCarritoTienda) data);
			if (res) //La factura se cerro con exito
				context = new Context(Evento.CERRAR_FACTURA_TIENDA_OK, "La factura ha sido registrada con éxito.");
			else
				context = new Context(Evento.CERRAR_FACTURA_TIENDA_KO, "Ha habido un error al validar los datos.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.CERRAR_FACTURA_TIENDA_KO, e.getMessage());
		}

		return context;
	}
}
