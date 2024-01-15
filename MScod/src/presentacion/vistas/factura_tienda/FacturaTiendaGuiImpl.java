package presentacion.vistas.factura_tienda;

import javax.swing.JPanel;

import presentacion.controller.Context;
import presentacion.vistas.Gui;

public class FacturaTiendaGuiImpl extends FacturaTiendaGui {

	Gui panel;
	
	public FacturaTiendaGuiImpl() {
		panel = new FacturaTiendaPanel();
	}
	
	public String getNombre() {
		return panel.getNombre();
	}
	
	public JPanel getPanel() {
		return panel.getPanel();
	}
	
	public void actualizar(Context responseContext) {
		panel.actualizar(responseContext);
	}
}
