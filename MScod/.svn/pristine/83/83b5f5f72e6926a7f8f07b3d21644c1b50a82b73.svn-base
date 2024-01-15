package presentacion.launcher;

import javax.swing.SwingUtilities;

import presentacion.vistas.main.MainGui;

public class AppLauncher {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {			
					MainGui.getInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
