package presentacion.command.factura_tienda;

import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class AbrirFacturaTiendaCommand implements Command {

	public Context execute(Object data) {
		return new Context(Evento.ABRIR_FACTURA_TIENDA, SAFactoria.getInstancia().generarSAFacturaTienda().abrirFactura());
	}
}
