package presentacion.vistas.marca;

import presentacion.vistas.Gui;

public abstract class MarcaGui implements Gui {

	private static MarcaGui instance = null;
		
	public static synchronized MarcaGui getInstance() {
		if (instance == null) {
			instance = new MarcaGuiImpl();
		}
		return instance;
	}
}
