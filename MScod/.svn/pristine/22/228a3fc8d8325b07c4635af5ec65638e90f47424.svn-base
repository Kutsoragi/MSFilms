package presentacion.vistas.empleado;

import presentacion.vistas.Gui;

public abstract class EmpleadoGui implements Gui {

	private static EmpleadoGui instance = null;
		
	public static synchronized EmpleadoGui getInstance() {
		if (instance == null) {
			instance = new EmpleadoGuiImpl();
		}
		return instance;
	}
}
