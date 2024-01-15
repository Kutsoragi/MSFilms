package presentacion.vistas.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import presentacion.controller.Context;
import presentacion.utility.PanelButton;
import presentacion.utility.PanelGridBagConstraints;
import presentacion.vistas.Gui;
import presentacion.vistas.empleado.EmpleadoGui;
import presentacion.vistas.factura.FacturaGui;
import presentacion.vistas.factura_tienda.FacturaTiendaGui;
import presentacion.vistas.marca.MarcaGui;
import presentacion.vistas.pase.PaseGui;
import presentacion.vistas.pelicula.PeliculaGui;
import presentacion.vistas.producto.ProductoGui;
import presentacion.vistas.proveedor.ProveedorGui;

public class MainFrame extends JFrame implements Gui {

	private static final long serialVersionUID = 1L;

	private String nombre = "INICIO";
	
	private Gui currentGui;
	
	private JPanel inicioPanel;
	private JLabel menuTitle;

	public MainFrame() {
		init();
	}

	public void init() {
		setBackground(new Color(255, 255, 255));
		setUndecorated(true);
		setBounds(100, 100, 1024, 620);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel topBar = new JPanel();
		topBar.setLayout(new BoxLayout(topBar, BoxLayout.X_AXIS));
		topBar.setBackground(new Color(7, 55, 99));
		topBar.setMaximumSize(new Dimension(1024, 50));
		
		topBar.add(Box.createRigidArea(new Dimension(20,0)));
		
		JLabel groupLogo = new JLabel();
		groupLogo.setIcon(new ImageIcon("resources/icons/inicio/ISFilms-logo-small.png"));
		topBar.add(groupLogo);
		
		topBar.add(Box.createRigidArea(new Dimension(8,0)));
		
		JLabel appName = new JLabel("CINEMA MANAGER");
		appName.setFont(new Font("Arial", Font.BOLD, 14));
		appName.setForeground(new Color(215,215,215));
		topBar.add(appName);
		
		topBar.add(Box.createRigidArea(new Dimension(830-23,0))); //logo width = 23px
		
		JButton exitBtn = new JButton("X");
		exitBtn.setFocusPainted(false);
		exitBtn.setBorder(null);
		exitBtn.setContentAreaFilled(false);
		exitBtn.setBorderPainted(false);
		exitBtn.setPreferredSize(new Dimension(30, 30));
		exitBtn.setFont(new Font("Corbel", Font.BOLD, 19));
		exitBtn.setForeground(new Color(215,215,215));
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JComponent[] input = new JComponent[] { new JLabel("¿Desea cerrar el programa?") };
				Object[] options = {"Si", "No"};
				int result = JOptionPane.showOptionDialog(null, input, "Salir", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (result == JOptionPane.OK_OPTION)
					System.exit(0);
			}
		});
		topBar.add(exitBtn);

		//-------
		
		menuTitle = new JLabel(nombre);
		menuTitle.setFont(new Font("Arial", Font.BOLD, 30));
		menuTitle.setForeground(new Color(7, 55, 99));
		menuTitle.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel decorationLine = new JPanel();
		decorationLine.setBackground(new Color(7, 55, 99));
		decorationLine.setMaximumSize(new Dimension(800, 5));
		
		//-------

		inicioPanel = new JPanel(new GridBagLayout());
		inicioPanel.setBackground(new Color(243, 243, 243));
		inicioPanel.setMaximumSize(new Dimension(1024, 460));
		
		// botones DAO
		GridBagConstraints c = new PanelGridBagConstraints();
		JButton peliculaBtn = new PanelButton("resources/icons/inicio/pelicula.png");
		peliculaBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Mostrar PeliculaGui");
				//SingletonApplicationController.getInstance().handleRequest(new Context(EventosGui.MOSTRAR_PELICULA, null));
				updateFrame(PeliculaGui.getInstance());
			}
		});
		inicioPanel.add(peliculaBtn, c);
		
		c.gridx++;
		JButton paseBtn = new PanelButton("resources/icons/inicio/pase.png");
		paseBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Mostrar PaseGui");
				updateFrame(PaseGui.getInstance());
			}
		});
		inicioPanel.add(paseBtn, c);

		c.gridx++;
		JButton empleadoBtn = new PanelButton("resources/icons/inicio/empleado.png");
		empleadoBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Mostrar EmpleadoGui");
				updateFrame(EmpleadoGui.getInstance());
			}
		});
		inicioPanel.add(empleadoBtn, c);
		
		c.gridx++;
		JButton facturaBtn = new PanelButton("resources/icons/inicio/factura.png");
		facturaBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Mostrar FacturaGui");
				updateFrame(FacturaGui.getInstance());
			}
		});
		inicioPanel.add(facturaBtn, c);
		
		// botones JPA
		c.gridx = 0;
		c.gridy++;
		JButton proveedorBtn = new PanelButton("resources/icons/inicio/proveedor.png");
		proveedorBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Mostrar ProveedorGui");
				//SingletonApplicationController.getInstance().handleRequest(new Context(EventosGui.MOSTRAR_PROVEEDOR, null));
				updateFrame(ProveedorGui.getInstance());
			}
		});
		inicioPanel.add(proveedorBtn, c);
		
		c.gridx++;
		JButton marcaBtn = new PanelButton("resources/icons/inicio/marca.png");
		marcaBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Mostrar MarcaGui");
				updateFrame(MarcaGui.getInstance());
			}
		});
		inicioPanel.add(marcaBtn, c);

		c.gridx++;
		JButton productoBtn = new PanelButton("resources/icons/inicio/producto.png");
		productoBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Mostrar ProductoGui");
				updateFrame(ProductoGui.getInstance());
			}
		});
		inicioPanel.add(productoBtn, c);
		
		c.gridx++;
		JButton facturaTiendaBtn = new PanelButton("resources/icons/inicio/factura-tienda.png");
		facturaTiendaBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.out.println("Mostrar FacturaTiendaGui");
				updateFrame(FacturaTiendaGui.getInstance());
			}
		});
		inicioPanel.add(facturaTiendaBtn, c);
		
		add(topBar);
		add(Box.createRigidArea(new Dimension(0,25)));
		add(menuTitle);
		add(Box.createRigidArea(new Dimension(0,20)));
		add(decorationLine);
		add(inicioPanel);
		
		setLocationRelativeTo(null);
		
		setVisible(true);
	}

	private void updateFrame(Gui newGui) {
		if (currentGui == null || currentGui.getNombre().equals(this.nombre)) {
			inicioPanel.setVisible(false);
			add(newGui.getPanel());
		} else {
			remove(currentGui.getPanel());
			inicioPanel.setVisible(true);
		}
		
		currentGui = newGui;
		menuTitle.setText(newGui.getNombre());
		
		repaint();
		revalidate();   
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public JPanel getPanel() {
		return inicioPanel;
	}
	
	public void abrir() {
		inicioPanel.setVisible(true);
	}
	
	public void cerrar() {
		inicioPanel.setVisible(false);
	}
	
	public void actualizar(Context responseContext) {
		switch(responseContext.getEvent()) {
			case MOSTRAR_INICIO:
				updateFrame(MainGui.getInstance());
				System.out.println("Retornando a MainGui");
				break;
			//case EventosGui.MOSTRAR_PELICULA:
			//	updateFrame(PeliculaGui.getInstance());
			//	System.out.println("Mostrando PeliculaGui");
			//	break;
			default:
				System.out.println("Evento desconocido: " + responseContext.getEvent().toString());
				break;
		}
	}
}
