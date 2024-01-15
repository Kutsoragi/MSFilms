package presentacion.vistas.pase;

import presentacion.vistas.Gui;

public abstract class PaseGui implements Gui {

	private static PaseGui instance = null;
		
	public static synchronized PaseGui getInstance() {
		if (instance == null) {
			instance = new PaseGuiImpl();
		}
		return instance;
	}
}
