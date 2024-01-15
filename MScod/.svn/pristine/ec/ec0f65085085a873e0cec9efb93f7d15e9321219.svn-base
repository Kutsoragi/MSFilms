package presentacion.vistas.proveedor;

import presentacion.vistas.Gui;

public abstract class ProveedorGui implements Gui {

	private static ProveedorGui instance = null;
		
	public static synchronized ProveedorGui getInstance() {
		if (instance == null) {
			instance = new ProveedorGuiImpl();
		}
		return instance;
	}
}
