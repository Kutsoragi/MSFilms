package presentacion.command.gui;

import presentacion.command.Command;
import presentacion.controller.Context;
import presentacion.controller.Evento;

// Command generico para mostrar cualquier GUI
public class MostrarGuiCommand implements Command {

	private Evento event;
	
	public MostrarGuiCommand(Evento event) {
		this.event = event;
	}
	
	public Context execute(Object data) {
		return new Context(event, null);
	}
}
