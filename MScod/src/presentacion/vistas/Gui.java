package presentacion.vistas;

import javax.swing.JPanel;

import presentacion.controller.Context;

public interface Gui {
	public String getNombre();
	public JPanel getPanel();
	public void actualizar(Context responseContext);
}
