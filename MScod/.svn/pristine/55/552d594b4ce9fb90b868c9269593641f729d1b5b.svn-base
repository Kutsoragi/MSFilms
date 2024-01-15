package presentacion.vistas.factura;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import negocio.factura.Pair;
import negocio.factura.TCarrito;
import negocio.factura.TLineaFactura;
import negocio.pase.TPase;
import presentacion.controller.ApplicationController;
import presentacion.controller.Context;
import presentacion.controller.Evento;
import presentacion.utility.ErrorPanel;
import presentacion.utility.FacturaTable;
import presentacion.utility.FormPanel;
import presentacion.utility.PanelButton;
import presentacion.utility.PanelGridBagConstraints;
import presentacion.utility.RoundButton;
import presentacion.utility.TablePanel;
import presentacion.vistas.Gui;

@SuppressWarnings("serial")
public class FacturaPanel extends JPanel implements Gui {

	private int INICIO_PANEL_HEIGHT = 300;
	
	private String nombre = "FACTURA";
	
	private JPanel inicioPanel, panelActual;
	private ErrorPanel errorPanel;
	
	private TCarrito carritoAux;
	private TablePanel carritoTable;
	private JLabel carritoPrecio;
	
	public FacturaPanel() {
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
		
		JButton abrirFacturaBtn = new PanelButton("resources/icons/operaciones/abrir-factura.png");
		abrirFacturaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carritoPanel();
				ApplicationController.getInstance().handleRequest(new Context(Evento.ABRIR_FACTURA, null));
				System.out.println("Abrir Factura");
			}
		});
		inicioPanel.add(abrirFacturaBtn, c);
		
		c.gridx++;
		JButton devolverPaseBtn = new PanelButton("resources/icons/operaciones/devolver-pase.png");
		devolverPaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				devolverPasePanel();
				System.out.println("Devolver Pase");
			}
		});
		inicioPanel.add(devolverPaseBtn, c);
		
		c.gridx++;
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
				ApplicationController.getInstance().handleRequest(new Context(Evento.MOSTRAR_LISTA_FACTURA, null));
				System.out.println("Listar");
			}
		});
		inicioPanel.add(listarBtn, c);
		
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
	
	private JButton createToolButton(String iconPath, Color color, String tooltip) {
		RoundButton button = new RoundButton(100);
		button.setMaximumSize(new Dimension(35, 35));
		button.setBackground(color);
		button.setBorder(null);
		button.setFocusPainted(false);
		button.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		button.setToolTipText(tooltip);
		button.setIcon(iconPath);
		
		return button;
	}
	
	private Pair<Integer, Integer> paseOptionPane(String operacion) {
		JTextField idPaseField = new JTextField();
		JTextField cantidadPaseField = new JTextField();
		final JComponent[] input = new JComponent[] {
		        new JLabel("ID Pase"),
		        idPaseField,
		        new JLabel("Cantidad"),
		        cantidadPaseField,
		};
		Object[] options = {operacion, "Cancelar"};
		int result = JOptionPane.showOptionDialog(null, input, operacion + " Pase", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
		if (result == JOptionPane.OK_OPTION) {
			int idPase = Integer.parseInt(idPaseField.getText());
			int cantidadPase = Integer.parseInt(cantidadPaseField.getText());
			return new Pair<Integer, Integer>(idPase, cantidadPase);
		}
		
		return null;
	}
	
	private Integer empleadoOptionPane() {
		JTextField idEmpleadoField = new JTextField();
		final JComponent[] input = new JComponent[] {
		        new JLabel("ID Empleado"),
		        idEmpleadoField,
		};
		Object[] options = {"Aceptar", "Cancelar"};
		int result = JOptionPane.showOptionDialog(null, input, "Empleado Factura", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (result == JOptionPane.OK_OPTION)
			return Integer.valueOf(idEmpleadoField.getText());
		
		return null;
	}
	
	//-- PANELES
	
	private void carritoPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false);
		panel.setMaximumSize(new Dimension(1024, 460));
		
		JPanel facturaPanel = new JPanel();
		facturaPanel.setLayout(new BoxLayout(facturaPanel, BoxLayout.X_AXIS));
		facturaPanel.setOpaque(false);
		facturaPanel.setMaximumSize(new Dimension(1024, 320));
		
		JPanel toolPanel = new JPanel();
		toolPanel.setLayout(new BoxLayout(toolPanel, BoxLayout.Y_AXIS));
		toolPanel.setBackground(new Color(70, 70, 70));
		toolPanel.setMaximumSize(new Dimension(80, 320));
		
		//--
		
		TablePanel paseTable = new TablePanel(new Dimension(600, 320), Arrays.asList("ID PASE", "CANTIDAD"));//, "PRECIO"));
		
		//--
		
		JLabel totalTitle = new JLabel("TOTAL: ");
		totalTitle.setForeground(new Color(230,230,230));
		totalTitle.setFont(new Font("Arial", Font.BOLD, 12));
		totalTitle.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		totalTitle.setForeground(new Color(70, 70, 70));

		JLabel totalPrecio = new JLabel("0.0");
		totalPrecio.setForeground(new Color(230,230,230));
		totalPrecio.setAlignmentX(JComponent.CENTER_ALIGNMENT);
		totalPrecio.setForeground(new Color(70, 70, 70));
		
		toolPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		
		JButton añadirPaseBtn = createToolButton("resources/icons/operaciones/añadir-pase.png", new Color(63, 164, 31), "Añade un pase a la factura");
		añadirPaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Pair<Integer, Integer> pases = paseOptionPane("Añadir");
					if (pases != null) {
						carritoAux.setIdPaseAuxiliar(pases.getFirst());
						carritoAux.setCantidadAuxiliar(pases.getSecond());
						ApplicationController.getInstance().handleRequest(new Context(Evento.AÑADIR_PASE, carritoAux));
					}
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipos de datos no válidos o inexistentes.", false);
				}
			}
		});
		toolPanel.add(añadirPaseBtn);
		toolPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton quitarPaseBtn = createToolButton("resources/icons/operaciones/quitar-pase.png", new Color(220, 34, 34), "Quita un pase de la factura");
		quitarPaseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Pair<Integer, Integer> pases = paseOptionPane("Quitar");
					if (pases != null) {
						carritoAux.setIdPaseAuxiliar(pases.getFirst());
						carritoAux.setCantidadAuxiliar(pases.getSecond());
						ApplicationController.getInstance().handleRequest(new Context(Evento.QUITAR_PASE, carritoAux));
					}
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipos de datos no válidos o inexistentes.", false);
				}
			}
		});
		toolPanel.add(quitarPaseBtn);
		toolPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		
		JButton cerrarBtn = createToolButton("resources/icons/operaciones/cerrar-factura.png", new Color(38, 180, 237), "Confirma y cierra la factura");
		cerrarBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				final JComponent[] input = new JComponent[] {
				        new JLabel("¿Desea confirmar y cerrar la factura?"),
				};
				Object[] options = {"Si", "No"};
				int result = JOptionPane.showOptionDialog(null, input, "Confirmar Factura", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				if (result == JOptionPane.OK_OPTION) {
					try {
						Integer idEmpleado = empleadoOptionPane();
						if (idEmpleado != null){
							carritoAux.getFactura().setIdEmpleado(idEmpleado);
							ApplicationController.getInstance().handleRequest(new Context(Evento.CERRAR_FACTURA, carritoAux));
						}
					} catch (NumberFormatException ex) {
						errorPanel.showOutputMessage("Tipo de dato no válido o inexistente.", false);
					}
				}
			}
		});
		toolPanel.add(cerrarBtn);
		toolPanel.add(Box.createRigidArea(new Dimension(0, 80)));
		toolPanel.add(totalTitle);
		toolPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		toolPanel.add(totalPrecio);
		
		//--
		
		facturaPanel.add(Box.createRigidArea(new Dimension(170, 0)));
		facturaPanel.add(paseTable);
		facturaPanel.add(toolPanel);

		panel.add(facturaPanel);
		
		carritoTable = paseTable;
		carritoPrecio = totalPrecio;
		
		updatePanel(panel, 40);
	}
	
	private void devolverPasePanel() {
		final FormPanel panel = new FormPanel(Arrays.asList("ID FACTURA", "ID PASE", "CANTIDAD"));
		
		panel.addEnterActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer idFactura = Integer.valueOf(panel.getFieldText("ID FACTURA"));
					Integer idPase = Integer.valueOf(panel.getFieldText("ID PASE"));
					Integer cantidad = Integer.valueOf(panel.getFieldText("CANTIDAD"));
					ApplicationController.getInstance().handleRequest(new Context(Evento.DEVOLVER_PASE, new TLineaFactura(idFactura, new TPase(idPase, 1), cantidad)));
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipos de datos no válidos o inexistentes.", false);
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
					ApplicationController.getInstance().handleRequest(new Context(Evento.BUSCAR_FACTURA, id));
				} catch (NumberFormatException ex) {
					errorPanel.showOutputMessage("Tipo de dato no válido o inexistente.", false);
				}
			}
		});
		
		updatePanel(panel, null);
	}
	
	private void mostrarPanel(TCarrito carrito) {
		FacturaTable fTable = new FacturaTable(new Dimension(600, 175));
		fTable.MostrarFacturaPorCarrito(carrito);
		updatePanel(fTable, null);
	}
	
	private void listarPanel(LinkedList<TCarrito> carritos) {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setOpaque(false);
		panel.setMaximumSize(new Dimension(1024, 460));
		
		JPanel listarPanel = new JPanel();
		listarPanel.setLayout(new BoxLayout(listarPanel, BoxLayout.Y_AXIS));
		listarPanel.setOpaque(false);
		listarPanel.setMaximumSize(new Dimension(1024, 400));
		
		for (TCarrito c : carritos) {
			FacturaTable fTable = new FacturaTable(new Dimension(600, 150));
			fTable.MostrarFacturaPorCarrito(c);
			listarPanel.add(fTable);
			listarPanel.add(Box.createRigidArea(new Dimension(0, 40)));
		}
		
		JScrollPane scrollPane = new JScrollPane(listarPanel);
		scrollPane.getVerticalScrollBar().setUnitIncrement(16);
		scrollPane.setPreferredSize(new Dimension(700, 300));
		scrollPane.setMaximumSize(new Dimension(700, 300));
		scrollPane.setOpaque(false);
		panel.add(scrollPane);
		
		updatePanel(panel, 50);
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
			case ABRIR_FACTURA:
				carritoAux = (TCarrito) responseContext.getDataObject();
				break;
				
			case AÑADIR_PASE_OK:
			case QUITAR_PASE_OK:
				carritoAux = (TCarrito) responseContext.getDataObject();
				if (carritoTable != null && carritoPrecio != null) {
					carritoTable.clearTable();
					for (TLineaFactura l : carritoAux.getLineasFactura()) {
						carritoTable.addRow(new Object[]{l.getPase().getID(), l.getCantidad()}, false);
					}
					errorPanel.clear();
				}
				break;
				
			case CERRAR_FACTURA_OK:
				//Volver a Inicio
				remove(panelActual);
				carritoAux = null;
				carritoTable = null;
				carritoPrecio = null;
				inicioPanel.setVisible(true);
				panelActual = inicioPanel;
				errorPanel.showOutputMessage((String) responseContext.getDataObject(), true);
				break;
				
			case DEVOLVER_PASE_OK:
				errorPanel.showOutputMessage((String) responseContext.getDataObject(), true);
				break;
				
			case BUSCAR_FACTURA_OK:
				mostrarPanel((TCarrito) responseContext.getDataObject());
				break;
			case MOSTRAR_LISTA_FACTURA_OK:
				listarPanel((LinkedList<TCarrito>) responseContext.getDataObject());
				break;
				
			//ERROR
			case AÑADIR_PASE_KO:
			case QUITAR_PASE_KO:
			case CERRAR_FACTURA_KO:
			case DEVOLVER_PASE_KO:
			case BUSCAR_FACTURA_KO:
			case MOSTRAR_LISTA_FACTURA_KO:
				errorPanel.showOutputMessage((String) responseContext.getDataObject(), false);
				break;
			default:
				errorPanel.showOutputMessage("Evento desconocido: " + responseContext.getEvent().toString(), false);
				break;
		}		
	}

}
