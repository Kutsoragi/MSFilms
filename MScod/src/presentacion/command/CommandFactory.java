package presentacion.command;

import presentacion.controller.Evento;

public abstract class CommandFactory {
	
	private static CommandFactory instance;
	
	public static CommandFactory getInstance() {
		if (instance == null)
			instance = new CommandFactoryImpl();
		return instance;
	}

	public abstract Command getCommand(Evento event);
}
