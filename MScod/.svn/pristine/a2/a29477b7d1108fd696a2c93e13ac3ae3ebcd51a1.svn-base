package presentacion.command.factura;

import java.util.LinkedList;

import negocio.factoria_sa.SAFactoria;
import negocio.factura.TCarrito;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class MostrarListaFacturaCommand implements Command {

	public Context execute(Object data) {
		Context context;
		LinkedList<TCarrito> res;
		try {
			res = SAFactoria.getInstancia().generarSAFactura().listarFacturas();
			if (!res.isEmpty())
				context = new Context(Evento.MOSTRAR_LISTA_FACTURA_OK, res);
			else
				context = new Context(Evento.MOSTRAR_LISTA_FACTURA_KO, "No hay Facturas que mostrar.");	
		} catch (Exception e) {
			context = new Context(Evento.MOSTRAR_LISTA_FACTURA_KO, e.getMessage());	
		}
		
		return context;
	}
}
