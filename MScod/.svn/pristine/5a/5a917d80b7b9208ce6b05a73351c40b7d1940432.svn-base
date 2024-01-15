package presentacion.vistas.pase;

import javax.swing.JPanel;

import presentacion.controller.Context;
import presentacion.vistas.Gui;

public class PaseGuiImpl extends PaseGui {

	Gui panel;
	
	public PaseGuiImpl() {
		panel = new PasePanel();
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
