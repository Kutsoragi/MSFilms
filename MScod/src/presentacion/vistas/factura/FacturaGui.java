package presentacion.vistas.factura;

import presentacion.vistas.Gui;

public abstract class FacturaGui implements Gui {

	private static FacturaGui instance = null;
		
	public static synchronized FacturaGui getInstance() {
		if (instance == null) {
			instance = new FacturaGuiImpl();
		}
		return instance;
	}
}
