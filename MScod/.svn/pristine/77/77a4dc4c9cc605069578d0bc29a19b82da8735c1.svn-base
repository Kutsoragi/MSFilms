package presentacion.vistas.pelicula;

import javax.swing.JPanel;

import presentacion.controller.Context;
import presentacion.vistas.Gui;

public class PeliculaGuiImpl extends PeliculaGui {

	Gui panel;
	
	public PeliculaGuiImpl() {
		panel = new PeliculaPanel();
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
