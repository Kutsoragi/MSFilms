package presentacion.command.factura_tienda;

import java.util.LinkedList;

import negocio.factoria_sa.SAFactoria;
import negocio.facturaTienda.TCarritoTienda;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class ListarFacturasTiendaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		LinkedList<TCarritoTienda> res = SAFactoria.getInstancia().generarSAFacturaTienda().listarFacturas();
		if (!res.isEmpty())
			context = new Context(Evento.LISTAR_FACTURAS_TIENDA_OK, res);
		else
			context = new Context(Evento.LISTAR_FACTURAS_TIENDA_KO, "No hay Facturas que mostrar.");	
		
		return context;
	}
}
