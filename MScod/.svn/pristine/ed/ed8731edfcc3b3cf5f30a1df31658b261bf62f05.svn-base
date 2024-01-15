package presentacion.vistas.proveedor;

import javax.swing.JPanel;

import presentacion.controller.Context;
import presentacion.vistas.Gui;

public class ProveedorGuiImpl extends ProveedorGui {

	Gui panel;
	
	public ProveedorGuiImpl() {
		panel = new ProveedorPanel();
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
