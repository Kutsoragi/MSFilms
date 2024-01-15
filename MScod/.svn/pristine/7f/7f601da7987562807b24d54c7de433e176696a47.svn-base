package presentacion.utility;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import negocio.factura.TCarrito;
import negocio.factura.TFactura;
import negocio.factura.TLineaFactura;
import negocio.facturaTienda.TCarritoTienda;
import negocio.facturaTienda.TFacturaTienda;
import negocio.facturaTienda.TLineaFacturaTienda;

@SuppressWarnings("serial")
public class FacturaTable extends JPanel {

	JLabel facturaID, empleadoID, fecha, precioTotal;
	TablePanel lineaTable;
	
	public FacturaTable(Dimension tableDim) {
		init(tableDim, Arrays.asList("ID PASE", "ID PELICULA", "ID SALA"), true);
	}
	
	public FacturaTable(Dimension tableDim, List<String> columns, Boolean hasEmpleado) {
		init(tableDim, columns, hasEmpleado);
	}
	
	private void init(Dimension tableDim, List<String> columns, Boolean hasEmpleado) {
		setOpaque(false);
		setMaximumSize(new Dimension(1024, 460));
		
		JPanel facturaPanel = new JPanel();
		facturaPanel.setLayout(new BoxLayout(facturaPanel, BoxLayout.Y_AXIS));
		facturaPanel.setOpaque(false);
		facturaPanel.setMaximumSize(new Dimension(1024, 450));
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
		topPanel.setOpaque(false);
		topPanel.setMaximumSize(new Dimension(600, 30));
		
		facturaID = new JLabel("ID FACTURA: 1");
		fecha = new JLabel("DD/MM/YYYY");
		
		topPanel.add(facturaID);
		if (hasEmpleado) {
			topPanel.add(Box.createRigidArea(new Dimension(30, 0)));
			empleadoID = new JLabel("ID EMPLEADO: 1");
			topPanel.add(empleadoID);
		}
		topPanel.add(Box.createRigidArea(new Dimension(320, 0)));		
		topPanel.add(fecha);
		
		//--
		
		// incluir columnas fijas
		List<String> modifiedColumns = new ArrayList<String>(columns);
		modifiedColumns.add("CANTIDAD");
		modifiedColumns.add("PRECIO");
		
		lineaTable = new TablePanel(tableDim, modifiedColumns);
		facturaPanel.add(lineaTable);
		
		//--
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
		bottomPanel.setOpaque(false);
		bottomPanel.setMaximumSize(new Dimension(600, 30));
		
		precioTotal = new JLabel("PRECIO TOTAL: 1000.00");
		precioTotal.setAlignmentX(SwingConstants.RIGHT);
		bottomPanel.add(precioTotal);
		
		//--
		
		facturaPanel.add(topPanel);
		facturaPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		facturaPanel.add(lineaTable);
		facturaPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		facturaPanel.add(bottomPanel);
		
		add(facturaPanel);
	}
	
	// si fuera necesario se podria implementar un adaptador para reutilizar este codigo
	public void MostrarFacturaPorCarrito(TCarrito c) {
		TFactura f = c.getFactura();
		facturaID.setText("ID FACTURA: " + f.getID());
		empleadoID.setText("ID EMPLEADO: " + f.getIdEmpleado());
		fecha.setText(f.getFecha().toString());
		precioTotal.setText("PRECIO TOTAL: " + c.getPrecioTotal());

		for (TLineaFactura l : c.getLineasFactura()) {
			lineaTable.addRow(new Object[]{l.getPase().getID(), l.getPase().getPelicula(), l.getPase().getSala(), "x" + l.getCantidad(), l.getPrecio()}, false);
		}
	}
	
	public void MostrarFacturaPorCarritoTienda(TCarritoTienda c) {
		TFacturaTienda f = c.getFactura();
		facturaID.setText("ID FACTURA: " + f.getID());
		fecha.setText(f.getFecha().toString());
		precioTotal.setText("PRECIO TOTAL: " + c.getPrecioTotal());

		for (TLineaFacturaTienda l : c.getLineasFactura()) {
			lineaTable.addRow(new Object[]{l.getIdProducto(), "x" + l.getCantidad(), l.getPrecio()}, false);
		}
	}
}
