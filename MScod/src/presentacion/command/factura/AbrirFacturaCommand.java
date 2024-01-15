package presentacion.command.factura;

import negocio.factoria_sa.SAFactoria;
import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

public class AbrirFacturaCommand implements Command {

	public Context execute(Object data) {
		return new Context(Evento.ABRIR_FACTURA, SAFactoria.getInstancia().generarSAFactura().abrirFactura());
	}
}
