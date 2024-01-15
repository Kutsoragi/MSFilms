package presentacion.controller;

public class Context {

	private Evento event;
	private Object data;
	
	public Context(Evento event, Object data) {
		this.event = event;
		this.data = data;
	}
	
	public Evento getEvent() {
		return event;
	}
	
	public Object getDataObject() {
		return data;
	}
}
