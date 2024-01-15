package presentacion.command.factura_tienda;

import negocio.factoria_sa.SAFactoria;
import negocio.facturaTienda.TCarritoTienda;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class BuscarFacturaTiendaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		try {
			TCarritoTienda res = SAFactoria.getInstancia().generarSAFacturaTienda().buscarFacturaPorId((Integer) data);
			if (res != null)
				context = new Context(Evento.BUSCAR_FACTURA_TIENDA_OK, res);
			else
				context = new Context(Evento.BUSCAR_FACTURA_TIENDA_KO, "Factura no encontrada.");
		} catch(IllegalArgumentException e) {
			context = new Context(Evento.BUSCAR_FACTURA_TIENDA_KO, e.getMessage());
		}
		
		return context;
	}
}
