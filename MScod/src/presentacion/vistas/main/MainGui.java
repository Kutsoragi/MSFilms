package presentacion.vistas.main;

import presentacion.vistas.Gui;

public abstract class MainGui implements Gui {

	private static MainGui instance = null;
		
	public static synchronized MainGui getInstance() {
		if (instance == null) {
			instance = new MainGuiImpl();
		}
		return instance;
	}
}
