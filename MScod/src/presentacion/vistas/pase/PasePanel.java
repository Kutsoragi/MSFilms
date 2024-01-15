package presentacion.vistas.pase;

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

import negocio.pase.TPase;
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
public class PasePanel extends JPanel implements Gui {

	private int INICIO_PANEL_HEIGHT = 300;
	
	private String nombre = "PASE";
	
	private JPanel inicioPanel, panelActual;
	private ErrorPanel errorPanel;
	
	public PasePanel() {
		init();
	}
	
	public void init() {
		setLayout(new BorderLayout());
		setBackground(new Color(235, 237, 241));
		setMaximumSize(new Dimension(1024, 460));
		
		inicioPanel = new JPanel(new GridBagLayout());
		inicioPanel.setBackground(new Color(235, 237, 241));
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
		JButton mostrarListaBtn = new PanelButton("resources/icons/operaciones/listar.png");
		mostrarListaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ApplicationController.getInstance().handleRequest(new Context(Evento.MOSTRAR_LISTA_PASE, null));
				System.out.println("Mostrar Lista");
			}
		});
		inicioPanel.add(mostrarListaBtn, c);
		
		c.gridx++;
		JButton mostrarPorPeliculaBtn = new PanelButton("resources/icons/operaciones/mostrar-por-pelicula.png");
		mostrarPorPeliculaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorPeliculaPanel();
				System.out.println("Mostrar Por Pelicula");
			}
		});
		inicioPanel.add(mostrarPorPeliculaBtn, c);	
		
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
		final FormPanel panel = new FormPanel(Arrays.asList("FECHA", "HORA INICIO", "HORA FIN", "ID PELICULA", "ID SALA", "STOCK", "PRECIO"));
		
		panel.addEnterActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String fecha = panel.getFieldText("FECHA");	
					String horaInicio = panel.getFieldText("HORA INICIO");
					String horaFin = panel.getFieldText("HORA FIN");
					int idPelicula = Integer.parseInt(panel.getFieldText("ID PELICULA"));
					int idSala = Integer.parseInt(panel.getFieldText("ID SALA"));
					double precio = Double.parseDouble(panel.getFieldText("PRECIO"));
					int stock = Integer.parseInt(panel.getFieldText("STOCK"));
					TPase pase = new TPase(horaInicio, horaFin, fecha, precio, idPelicula, idSala, stock);
					ApplicationController.getInstance().handleRequest(new Context(Evento.REGISTRAR_PASE, pase));
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
		final FormPanel panel = new FormPanel(Arrays.asList("ID", "FECHA", "HORA INICIO", "HORA FIN", "ID PELICULA", "ID SALA", "STOCK", "PRECIO"));
		
		panel.addEnterActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(panel.getFieldText("ID"));	
					String fecha = panel.getFieldText("FECHA");
					String horaInicio = panel.getFieldText("HORA INICIO");
					String horaFin = panel.getFieldText("HORA FIN");
					int idPelicula = Integer.parseInt(panel.getFieldText("ID PELICULA"));
					int idSala = Integer.parseInt(panel.getFieldText("ID SALA"));
					double precio = Double.parseDouble(panel.getFieldText("PRECIO"));
					int stock = Integer.parseInt(panel.getFieldText("STOCK"));
					TPase pase = new TPase(id, horaInicio, horaFin, fecha, precio, idPelicula, idSala, stock);
					ApplicationController.getInstance().handleRequest(new Context(Evento.MODIFICAR_PASE, pase));
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
					ApplicationController.getInstance().handleRequest(new Context(Evento.BORRAR_PASE, id));
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
					ApplicationController.getInstance().handleRequest(new Context(Evento.BUSCAR_PASE, id));
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipo de dato no válido o inexistente.", false);
				}
			}
		});
		
		updatePanel(panel, null);
	}
	
	private void mostrarPanel(TPase p) { // Muestra un transfer dado
		MostrarPanel panel = new MostrarPanel(Arrays.asList("ID", "FECHA", "HORA INICIO", "HORA FIN", "ID PELICULA", "ID SALA", "STOCK", "PRECIO"));
		panel.setLabelText("ID", Integer.toString(p.getID()));
		panel.setLabelText("FECHA", p.getFecha().toString());
		panel.setLabelText("HORA INICIO", p.getHoraInicio());
		panel.setLabelText("HORA FIN", p.getHoraFin());
		panel.setLabelText("ID PELICULA", Integer.toString(p.getPelicula()));
		panel.setLabelText("ID SALA", Integer.toString(p.getSala()));
		panel.setLabelText("STOCK", Integer.toString(p.getStock()));
		panel.setLabelText("PRECIO", Double.toString(p.getPrecio()));
		updatePanel(panel, 50);
	}	
	
	private void mostrarListaPanel(List<TPase> pases) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false);
		panel.setMaximumSize(new Dimension(1024, 460));
		
		TablePanel tablePanel = new TablePanel(new Dimension(775, 275), Arrays.asList("ID", "FECHA", "HORA INICIO", "HORA FIN", "ID PELICULA", "ID SALA", "STOCK", "PRECIO"));		
		for (TPase p : pases)
			tablePanel.addRow(new Object[]{Integer.toString(p.getID()), p.getFecha(), p.getHoraInicio(), p.getHoraFin(), p.getPelicula(), p.getSala(), p.getStock(), Double.toString(p.getPrecio())}, false);
		
		panel.add(tablePanel);
		
		updatePanel(panel, null);
	}
	
	private void mostrarPorPeliculaPanel() {
		final FormPanel panel = new FormPanel(Arrays.asList("ID PELICULA"));
		
		panel.addEnterActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(panel.getFieldText("ID PELICULA"));	
					ApplicationController.getInstance().handleRequest(new Context(Evento.MOSTRAR_POR_PELICULA_PASE, id));
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipo de dato no válido o inexistente.", false);
				}
			}
		});

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
			
			//SUCCESS
			case REGISTRAR_PASE_OK:
			case MODIFICAR_PASE_OK:
			case BORRAR_PASE_OK:
				errorPanel.showOutputMessage((String) responseContext.getDataObject(), true);
				break;
			case BUSCAR_PASE_OK:
				mostrarPanel((TPase) responseContext.getDataObject());
				break;
			case MOSTRAR_LISTA_PASE_OK:
			case MOSTRAR_POR_PELICULA_PASE_OK:
				mostrarListaPanel((List<TPase>) responseContext.getDataObject());
				break;
				
			//ERROR
			case REGISTRAR_PASE_KO:
			case MODIFICAR_PASE_KO:
			case BORRAR_PASE_KO:
			case BUSCAR_PASE_KO:
			case MOSTRAR_LISTA_PASE_KO:
			case MOSTRAR_POR_PELICULA_PASE_KO:
				errorPanel.showOutputMessage((String) responseContext.getDataObject(), false);
				break;
			default:
				errorPanel.showOutputMessage("Evento desconocido: " + responseContext.getEvent().toString(), false);
				break;
		}
	}
}
