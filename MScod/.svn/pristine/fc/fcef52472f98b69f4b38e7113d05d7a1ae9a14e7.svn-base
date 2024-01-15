package presentacion.controller;

import presentacion.command.Command;
import presentacion.command.CommandFactory;
import presentacion.dispatcher.Dispatcher;

public class ApplicationControllerImpl extends ApplicationController {
	
	public void handleRequest(Context requestContext) {
		Command command = CommandFactory.getInstance().getCommand(requestContext.getEvent());
		Context responseContext = command.execute(requestContext.getDataObject());
		Dispatcher.getInstance().dispatch(responseContext);
	}
}
