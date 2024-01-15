package integracion.factura;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import integracion.transactions.TransactionManager;
import negocio.factura.TLineaFactura;
import negocio.pase.TPase;

public class DAOLineaFacturaImpl implements DAOLineaFactura {
	
	Connection conexion;
	PreparedStatement pStatement;
	ResultSet rs;
	
	
	public void insertarLineaFactura(TLineaFactura tLineaFactura){
		try{
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("INSERT INTO linea_factura (id_factura, id_pase, cantidad, precio_total_linea) VALUES (?,?,?,?)");
			pStatement.setInt(1, tLineaFactura.getIdFactura());
			pStatement.setInt(2, tLineaFactura.getPase().getID());
			pStatement.setInt(3, tLineaFactura.getCantidad());
			pStatement.setDouble(4, tLineaFactura.getPrecio());
			pStatement.executeUpdate();
			
			closeStatement();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public TLineaFactura buscarLinea(int idFactura, int idPase){
		TLineaFactura linea = null;
		
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			pStatement = conexion.prepareStatement("SELECT * FROM pase WHERE id_pase = " + idPase + " FOR UPDATE");
			rs = pStatement.executeQuery();
			
			if (rs.next()){
				TPase pase = new TPase(rs.getInt(1), rs.getString(3).substring(0, 5), rs.getString(5).substring(0, 5), rs.getString(2), rs.getDouble(4), rs.getInt(7), rs.getInt(8), rs.getBoolean(6), rs.getInt(9));
				pStatement = conexion.prepareStatement("SELECT id_factura, id_pase, cantidad, precio_total_linea FROM linea_factura  WHERE id_factura = " + idFactura + " AND id_pase = " + idPase + " FOR UPDATE");
				rs = pStatement.executeQuery();
				if (rs.next()){
					linea = new TLineaFactura(rs.getInt(1), pase, rs.getInt(3), rs.getDouble(4));
				}
			}
			closeStatement();
			closeResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return linea;
	}
	
	public LinkedList<TLineaFactura> mostrarLineas(int idFactura){
		LinkedList<TLineaFactura> lista = new LinkedList<TLineaFactura>();
		TPase pase = null;
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("SELECT id_factura, id_pase, cantidad, precio_total_linea FROM linea_factura  WHERE id_factura = " + idFactura);
			rs = pStatement.executeQuery();
			while (rs.next()){
				pStatement = conexion.prepareStatement("SELECT * FROM pase WHERE id_pase = " + rs.getInt(2) + " FOR UPDATE");
				ResultSet rsAux = pStatement.executeQuery();
				if (rsAux.next()) pase = new TPase(rsAux.getInt(1), rsAux.getString(3).substring(0, 5), rsAux.getString(5).substring(0, 5), rsAux.getString(2), rsAux.getDouble(4), rsAux.getInt(7), rsAux.getInt(8), rsAux.getBoolean(6), rsAux.getInt(9));
				lista.add(new TLineaFactura(rs.getInt(1), pase, rs.getInt(3), rs.getDouble(4)));
				rsAux.close();
			}
			closeStatement();
			closeResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public void modificarLinea(TLineaFactura tLineaFactura) {
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("UPDATE linea_factura SET cantidad = ?, precio_total_linea = ? WHERE id_factura = " + tLineaFactura.getIdFactura() + " AND id_pase = " + tLineaFactura.getPase().getID());
			pStatement.setInt(1, tLineaFactura.getCantidad());
			pStatement.setDouble(2, tLineaFactura.getPrecio());
			pStatement.executeUpdate();
			closeStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void eliminarLinea(TLineaFactura tLineaFactura){
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("DELETE FROM linea_factura WHERE id_factura = " + tLineaFactura.getIdFactura() + " AND id_pase = " + tLineaFactura.getPase().getID());
			pStatement.executeUpdate();
			closeStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private void closeResultSet() throws SQLException {
		rs.close();
	}
	
	private void closeStatement() throws SQLException {
		pStatement.close();
	}
}
