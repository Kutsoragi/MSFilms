package presentacion.vistas.empleado;

import javax.swing.JPanel;

import presentacion.controller.Context;
import presentacion.vistas.Gui;

public class EmpleadoGuiImpl extends EmpleadoGui {

	Gui panel;
	
	public EmpleadoGuiImpl() {
		panel = new EmpleadoPanel();
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
