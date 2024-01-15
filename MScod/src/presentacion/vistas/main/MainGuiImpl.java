package presentacion.vistas.main;

import javax.swing.JPanel;

import presentacion.controller.Context;
import presentacion.vistas.Gui;

public class MainGuiImpl extends MainGui {

	Gui frame;
	
	public MainGuiImpl() {
		frame = new MainFrame();
	}
	
	public String getNombre() {
		return frame.getNombre();
	}
	
	public JPanel getPanel() {
		return frame.getPanel();
	}
	
	public void actualizar(Context responseContext) {
		frame.actualizar(responseContext);
	}
}
