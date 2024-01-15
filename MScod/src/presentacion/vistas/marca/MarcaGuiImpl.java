package presentacion.vistas.marca;

import javax.swing.JPanel;

import presentacion.controller.Context;
import presentacion.vistas.Gui;

public class MarcaGuiImpl extends MarcaGui {

	Gui panel;
	
	public MarcaGuiImpl() {
		panel = new MarcaPanel();
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
