package presentacion.vistas.producto;

import presentacion.vistas.Gui;

public abstract class ProductoGui implements Gui {

	private static ProductoGui instance = null;
		
	public static synchronized ProductoGui getInstance() {
		if (instance == null) {
			instance = new ProductoGuiImpl();
		}
		return instance;
	}
}
