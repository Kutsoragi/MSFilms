package presentacion.vistas.proveedor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import negocio.proveedor.TProveedor;
import presentacion.controller.ApplicationController;
import presentacion.controller.Context;
import presentacion.controller.Evento;
import presentacion.utility.ErrorPanel;
import presentacion.utility.FormPanel;
import presentacion.utility.MostrarPanel;
import presentacion.utility.PanelButton;
import presentacion.utility.PanelGridBagConstraints;
import presentacion.utility.RoundButton;
import presentacion.utility.TablePanel;
import presentacion.vistas.Gui;

@SuppressWarnings("serial")
public class ProveedorPanel extends JPanel implements Gui {

	private int INICIO_PANEL_HEIGHT = 300;
	
	private String nombre = "PROVEEDOR";
	
	private JPanel inicioPanel, panelActual;
	private ErrorPanel errorPanel;
	
	public ProveedorPanel() {
		init();
	}
	
	public void init() {
		setLayout(new BorderLayout());
		setOpaque(false);
		setMaximumSize(new Dimension(1024, 460));
		
		inicioPanel = new JPanel(new GridBagLayout());
		inicioPanel.setOpaque(false);
		inicioPanel.setMaximumSize(new Dimension(1024, INICIO_PANEL_HEIGHT));
		
		GridBagConstraints c = new PanelGridBagConstraints();
		
		JButton registrarBtn = new PanelButton("resources/icons/operaciones/registrar.png");
		registrarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarPanel();
				System.out.println("Registrar");
			}
		});
		inicioPanel.add(registrarBtn, c);
		
		c.gridx++;
		JButton modificarBtn = new PanelButton("resources/icons/operaciones/modificar.png");
		modificarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificarPanel();
				System.out.println("Modificar");
			}
		});
		inicioPanel.add(modificarBtn, c);
		
		c.gridx++;
		JButton borrarBtn = new PanelButton("resources/icons/operaciones/borrar.png");
		borrarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrarPanel();
				System.out.println("Borrar");
			}
		});
		inicioPanel.add(borrarBtn, c);
		
		c.gridx = 0;
		c.gridy++;
		JButton buscarBtn = new PanelButton("resources/icons/operaciones/buscar.png");
		buscarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarPanel();
				System.out.println("Buscar");
			}
		});
		inicioPanel.add(buscarBtn, c);
		
		c.gridx++;
		JButton listarBtn = new PanelButton("resources/icons/operaciones/listar.png");
		listarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationController.getInstance().handleRequest(new Context(Evento.MOSTRAR_PROVEEDORES, null));
				System.out.println("Mostrar Proveedores");
			}
		});
		inicioPanel.add(listarBtn, c);
		
		/*
		c.gridx++;
		JButton mostrarPorFechaBtn = new PanelButton("resources/icons/operaciones/mostrar-por-dinero-cobrado-tras-fecha.png");
		mostrarPorFechaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorDineroCobradoTrasFechaPanel();
				System.out.println("Mostrar Por Dinero Cobrado Tras Fecha");
			}
		});
		inicioPanel.add(mostrarPorFechaBtn, c);
		*/
		
		//--
		
		errorPanel = new ErrorPanel(460 - INICIO_PANEL_HEIGHT);
		
		RoundButton backBtn = new RoundButton(100);
		backBtn.setMaximumSize(new Dimension(70,70));
		backBtn.setBackground(new Color(51,83,148));
		backBtn.setBorder(null);
		backBtn.setFocusPainted(false);
		backBtn.setIcon("resources/icons/back.png");
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Volver");
				
				errorPanel.clear();
				if (panelActual.equals(inicioPanel)) 
					ApplicationController.getInstance().handleRequest(new Context(Evento.MOSTRAR_INICIO, null));
				else {
					remove(panelActual);
					inicioPanel.setVisible(true);
					panelActual = inicioPanel;
				}
			}
		});
		errorPanel.add(backBtn);
		
		inicioPanel.setBorder(BorderFactory.createEmptyBorder((460-INICIO_PANEL_HEIGHT)/2,0,0,0));
		add(inicioPanel, BorderLayout.CENTER);
		add(errorPanel, BorderLayout.PAGE_END);
		panelActual = inicioPanel;
	}
	
	//-- METODOS AUXILIARES
	
	private void updatePanel(JPanel newPanel, Integer offset) {
		if (panelActual.equals(inicioPanel))
			inicioPanel.setVisible(false);
		else
			remove(panelActual);
		
		newPanel.setBorder(BorderFactory.createEmptyBorder(offset == null ? (460-INICIO_PANEL_HEIGHT)/2 : offset,0,0,0));
		add(newPanel, BorderLayout.CENTER);
		errorPanel.clear();
		revalidate();
		repaint();
		panelActual = newPanel;
	}
	
	//-- PANELES
	
	private void registrarPanel() {
		final FormPanel panel = new FormPanel(Arrays.asList("NOMBRE", "TELEFONO", "EMAIL", "DIRECCION"));
		
		panel.addEnterActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = panel.getFieldText("NOMBRE");	
					String telefono = panel.getFieldText("TELEFONO");
					String email = panel.getFieldText("EMAIL");
					String direccion = panel.getFieldText("DIRECCION");
					ApplicationController.getInstance().handleRequest(new Context(Evento.REGISTRAR_PROVEEDOR, new TProveedor(nombre, telefono, email, direccion)));
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipos de datos no válidos o inexistentes.", false);
				} catch (IllegalArgumentException ex) {
					errorPanel.showOutputMessage(ex.getMessage(), false);
				}
			}
		});
		
		updatePanel(panel, null);
	}
	
	private void modificarPanel() {
		final FormPanel panel = new FormPanel(Arrays.asList("ID", "NOMBRE", "TELEFONO", "EMAIL", "DIRECCION"));
		
		panel.addEnterActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(panel.getFieldText("ID"));
					String nombre = panel.getFieldText("NOMBRE");	
					String telefono = panel.getFieldText("TELEFONO");
					String email = panel.getFieldText("EMAIL");
					String direccion = panel.getFieldText("DIRECCION");
					ApplicationController.getInstance().handleRequest(new Context(Evento.MODIFICAR_PROVEEDOR, new TProveedor(id, nombre, telefono, email, direccion)));
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipos de datos no válidos o inexistentes.", false);
				} catch (IllegalArgumentException ex) {
					errorPanel.showOutputMessage(ex.getMessage(), false);
				}
			}
		});
		
		updatePanel(panel, null);
	}
	
	private void borrarPanel() {
		final FormPanel panel = new FormPanel(Arrays.asList("ID"));
		
		panel.addEnterActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(panel.getFieldText("ID"));
					ApplicationController.getInstance().handleRequest(new Context(Evento.BORRAR_PROVEEDOR, id));
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipo de dato no válido o inexistente.", false);
				}
			}
		});
		
		updatePanel(panel, null);
	}
	
	private void buscarPanel() {
		final FormPanel panel = new FormPanel(Arrays.asList("ID"));
		
		panel.addEnterActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(panel.getFieldText("ID"));
					ApplicationController.getInstance().handleRequest(new Context(Evento.BUSCAR_PROVEEDOR, id));
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipo de dato no válido o inexistente.", false);
				}
			}
		});
		
		updatePanel(panel, null);
	}
	
	private void mostrarPanel(TProveedor p) { // Muestra un transfer dado
		MostrarPanel panel = new MostrarPanel(Arrays.asList("ID", "NOMBRE", "TELEFONO", "EMAIL", "DIRECCION"));
		panel.setLabelText("ID", Integer.toString(p.getId()));
		panel.setLabelText("NOMBRE", p.getNombre());
		panel.setLabelText("TELEFONO", p.getTelefono());
		panel.setLabelText("EMAIL", p.getEmail());
		panel.setLabelText("DIRECCION", p.getDireccion());
		updatePanel(panel, 50);
	}	
	
	private void mostrarProveedorPanel(List<TProveedor> proveedores) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false);
		panel.setMaximumSize(new Dimension(1024, 460));
		
		TablePanel tablePanel = new TablePanel(new Dimension(775, 275), Arrays.asList("ID", "NOMBRE", "TELEFONO", "EMAIL", "DIRECCION"));		
		for (TProveedor p: proveedores)
			tablePanel.addRow(new Object[]{Integer.toString(p.getId()), p.getNombre(), p.getTelefono(), p.getEmail(), p.getDireccion()}, false);
		
		panel.add(tablePanel);
		
		updatePanel(panel, null);
	}
	
	/*
	private void mostrarPorDineroCobradoTrasFechaPanel() {
		final FormPanel panel = new FormPanel(Arrays.asList("DINERO", "FECHA"));
		
		panel.addEnterActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationController.getInstance().handleRequest(new Context(MOSTRAR_POR_DINERO_COBRADO_TRAS_FECHA_PROVEEDOR, panel.getFieldText("FECHA")));
			}
		});
		
		updatePanel(panel, null);
	}*/

	//-- METODOS IMPLEMENTADOS
	
	public String getNombre() {
		return nombre;
	}
	
	public JPanel getPanel() {
		return this;
	}
	
	public void abrir() {
		setVisible(true);
	}
	
	public void cerrar() {
		setVisible(false);
	}
	
	@SuppressWarnings("unchecked")
	public void actualizar(Context responseContext) {
		switch (responseContext.getEvent()) {
		
			//SUCCESS
			case REGISTRAR_PROVEEDOR_OK:
			case MODIFICAR_PROVEEDOR_OK:
			case BORRAR_PROVEEDOR_OK:
				errorPanel.showOutputMessage((String) responseContext.getDataObject(), true);
				break;
			case BUSCAR_PROVEEDOR_OK:
				mostrarPanel((TProveedor) responseContext.getDataObject());
				break;
			case MOSTRAR_PROVEEDORES_OK:
				mostrarProveedorPanel((List<TProveedor>) responseContext.getDataObject());
				break;
				
			//ERROR
			case REGISTRAR_PROVEEDOR_KO:
			case MODIFICAR_PROVEEDOR_KO:
			case BORRAR_PROVEEDOR_KO:
			case BUSCAR_PROVEEDOR_KO:
			case MOSTRAR_PROVEEDORES_KO:
				errorPanel.showOutputMessage((String) responseContext.getDataObject(), false);
				break;
			default:
				errorPanel.showOutputMessage("Evento desconocido: " + responseContext.getEvent().toString(), false);
				break;
		}
	}
}
