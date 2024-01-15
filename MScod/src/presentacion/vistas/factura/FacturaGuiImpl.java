package presentacion.vistas.factura;

import javax.swing.JPanel;

import presentacion.controller.Context;
import presentacion.vistas.Gui;

public class FacturaGuiImpl extends FacturaGui {

	Gui panel;
	
	public FacturaGuiImpl() {
		panel = new FacturaPanel();
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