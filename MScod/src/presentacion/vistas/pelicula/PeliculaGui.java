package presentacion.vistas.pelicula;

import presentacion.vistas.Gui;

public abstract class PeliculaGui implements Gui {

	private static PeliculaGui instance = null;
		
	public static synchronized PeliculaGui getInstance() {
		if (instance == null) {
			instance = new PeliculaGuiImpl();
		}
		return instance;
	}
}
