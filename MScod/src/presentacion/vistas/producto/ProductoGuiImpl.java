package presentacion.vistas.producto;

import javax.swing.JPanel;

import presentacion.controller.Context;
import presentacion.vistas.Gui;

public class ProductoGuiImpl extends ProductoGui {

	Gui panel;
	
	public ProductoGuiImpl() {
		panel = new ProductoPanel();
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
