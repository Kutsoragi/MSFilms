package presentacion.vistas.empleado;

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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import negocio.empleado.TEmpleado;
import negocio.empleado.TEmpleadoCompleto;
import negocio.empleado.TEmpleadoParcial;
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
public class EmpleadoPanel extends JPanel implements Gui {

	private int INICIO_PANEL_HEIGHT = 300;
	
	private String nombre = "EMPLEADO";
	
	private JPanel inicioPanel, panelActual;
	private ErrorPanel errorPanel;
	
	public EmpleadoPanel() {
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
				int resJornada = jornadaOptionPane(); //Si retorna OK es jornada Completa  
				if (resJornada == JOptionPane.YES_OPTION)
					registrarPanel(true);
				else if (resJornada == JOptionPane.NO_OPTION)
					registrarPanel(false);
				System.out.println("Registrar");
			}
		});
		inicioPanel.add(registrarBtn, c);
		
		c.gridx++;
		JButton modificarBtn = new PanelButton("resources/icons/operaciones/modificar.png");
		modificarBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int resJornada = jornadaOptionPane(); //Si retorna OK es jornada Completa 
				if (resJornada == JOptionPane.YES_OPTION)
					modificarPanel(true);
				else if (resJornada == JOptionPane.NO_OPTION)
					modificarPanel(false);
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
		JButton mostrarListaBtn = new PanelButton("resources/icons/operaciones/listar.png");
		mostrarListaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationController.getInstance().handleRequest(new Context(Evento.MOSTRAR_LISTA_EMPLEADO, null));
				System.out.println("Mostrar Lista");
			}
		});
		inicioPanel.add(mostrarListaBtn, c);
		
		c.gridx++;
		JButton mostrarPorJornadaBtn = new PanelButton("resources/icons/operaciones/mostrar-por-jornada.png");
		mostrarPorJornadaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				int resJornada = jornadaOptionPane(); //Si retorna OK es jornada Completa 
				if (resJornada == JOptionPane.YES_OPTION)
					ApplicationController.getInstance().handleRequest(new Context(Evento.MOSTRAR_POR_JORNADA_EMPLEADO, true));
				else if (resJornada == JOptionPane.NO_OPTION)
					ApplicationController.getInstance().handleRequest(new Context(Evento.MOSTRAR_POR_JORNADA_EMPLEADO, false));

				System.out.println("Mostrar Por Jornada");
			}
		});
		inicioPanel.add(mostrarPorJornadaBtn, c);
		
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
	
	private int jornadaOptionPane() {
		final JComponent[] input = new JComponent[] { new JLabel("Seleccione la Jornada") };
		Object[] options = {"Completa", "Parcial"};	
		return JOptionPane.showOptionDialog(null, input, "Jornada Empleado", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
	}
	
	//-- PANELES
	
	private void mainFormPanel(final boolean jornadaCompleta, final Evento event) { //Se aplica a Registrar y Modificar
		final FormPanel panel;
		
		if (jornadaCompleta == true)
			panel = new FormPanel(Arrays.asList("NOMBRE", "DNI", "SUELDO"));
		else
			panel = new FormPanel(Arrays.asList("NOMBRE", "DNI", "HORAS", "SUELDO/H"));
				
		panel.addEnterActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nombre = panel.getFieldText("NOMBRE");
					String dni = panel.getFieldText("DNI");
					if (jornadaCompleta == true) {
						double sueldo = Double.parseDouble(panel.getFieldText("SUELDO"));
						ApplicationController.getInstance().handleRequest(new Context(event, new TEmpleadoCompleto(dni, nombre, true, sueldo)));
					} else {
						int horas = Integer.parseInt(panel.getFieldText("HORAS"));
						double sueldoPorHora = Double.parseDouble(panel.getFieldText("SUELDO/H"));
						ApplicationController.getInstance().handleRequest(new Context(event, new TEmpleadoParcial(dni, nombre, true, horas, sueldoPorHora)));
					}
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipos de datos no válidos o inexistentes.", false);
				} catch (IllegalArgumentException ex) {
					errorPanel.showOutputMessage(ex.getMessage(), false);
				}
			}
		});
			
		updatePanel(panel, null);
	}
	
	private void registrarPanel(final boolean jornadaCompleta) {
		mainFormPanel(jornadaCompleta, Evento.REGISTRAR_EMPLEADO);
	}
	
	private void modificarPanel(final boolean jornadaCompleta) {
		mainFormPanel(jornadaCompleta, Evento.MODIFICAR_EMPLEADO);
	}
	
	private void borrarPanel() {
		final FormPanel panel = new FormPanel(Arrays.asList("ID"));
		
		panel.addEnterActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(panel.getFieldText("ID"));	
					ApplicationController.getInstance().handleRequest(new Context(Evento.BORRAR_EMPLEADO, id));
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
					ApplicationController.getInstance().handleRequest(new Context(Evento.BUSCAR_EMPLEADO, id));
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipo de dato no válido o inexistente.", false);
				}
			}
		});
		
		updatePanel(panel, null);
	}
	
	private void mostrarPanel(TEmpleado e) { // Muestra un transfer dado
		MostrarPanel panel;
		
		if (e.isCompleto()) {
			panel = new MostrarPanel(Arrays.asList("ID", "DNI", "NOMBRE", "JORNADA", "SUELDO", "ACTIVO"));
			panel.setLabelText("JORNADA", "Completa");
			panel.setLabelText("SUELDO", Double.toString(((TEmpleadoCompleto) e).getSueldo()));
		} else {	
			panel = new MostrarPanel(Arrays.asList("ID", "DNI", "NOMBRE", "JORNADA", "HORAS", "SUELDO/H", "ACTIVO"));
			panel.setLabelText("JORNADA", "Parcial");
			panel.setLabelText("HORAS", Integer.toString(((TEmpleadoParcial) e).getHoras()));
			panel.setLabelText("SUELDO/H", Double.toString(((TEmpleadoParcial) e).getSueldoPorHoras()));
		}

		panel.setLabelText("ID", Integer.toString(e.getID()));
		panel.setLabelText("DNI", e.getDNI());
		panel.setLabelText("NOMBRE", e.getNombre());
		panel.setLabelText("ACTIVO", Boolean.toString(e.isActivo()));
		
		updatePanel(panel, 50);
	}	
	
	private void mostrarListaPanel(List<TEmpleado> empleados) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false);
		panel.setMaximumSize(new Dimension(1024, 460));
		
		TablePanel tablePanel = new TablePanel(new Dimension(775, 275), Arrays.asList("ID", "DNI", "NOMBRE", "JORNADA", "SUELDO", "HORAS", "SUELDO/H"));		
		for (TEmpleado e : empleados) {
			Object[] datos = new Object[]{Integer.toString(e.getID()), e.getDNI(), e.getNombre(), e.isCompleto() ? "Completa" : "Parcial", e.getSueldo(), e.getHoras(), e.getSueldoPorHoras()};
			tablePanel.addRow(datos, false);
		}
		
		panel.add(tablePanel);
		
		updatePanel(panel, null);
	}

	//-- METODOS IMPLEMENTADOS
	
	public String getNombre() {
		return nombre;
	}
	
	public JPanel getPanel() {
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public void actualizar(Context responseContext) {
		switch(responseContext.getEvent()) {
			case REGISTRAR_EMPLEADO_OK:
			case MODIFICAR_EMPLEADO_OK:
			case BORRAR_EMPLEADO_OK:
				errorPanel.showOutputMessage((String) responseContext.getDataObject(), true);
				break;
			case BUSCAR_EMPLEADO_OK:
				mostrarPanel((TEmpleado) responseContext.getDataObject());
				break;
			case MOSTRAR_LISTA_EMPLEADO_OK:
			case MOSTRAR_POR_JORNADA_EMPLEADO_OK:
				mostrarListaPanel((List<TEmpleado>) responseContext.getDataObject());
				break;
			case REGISTRAR_EMPLEADO_KO:
			case MODIFICAR_EMPLEADO_KO:
			case BORRAR_EMPLEADO_KO:
			case BUSCAR_EMPLEADO_KO:
			case MOSTRAR_LISTA_EMPLEADO_KO:
			case MOSTRAR_POR_JORNADA_EMPLEADO_KO:
				errorPanel.showOutputMessage((String) responseContext.getDataObject(), false);
				break;
			default:
				errorPanel.showOutputMessage("Evento desconocido: " + responseContext.getEvent().toString(), false);
				break;
		}
	}
}
