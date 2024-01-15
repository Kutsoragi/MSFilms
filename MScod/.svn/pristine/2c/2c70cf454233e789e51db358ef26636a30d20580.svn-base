package presentacion.vistas.factura_tienda;

import presentacion.vistas.Gui;

public abstract class FacturaTiendaGui implements Gui {

	private static FacturaTiendaGui instance = null;
		
	public static synchronized FacturaTiendaGui getInstance() {
		if (instance == null) {
			instance = new FacturaTiendaGuiImpl();
		}
		return instance;
	}
}