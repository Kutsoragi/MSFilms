package integracion.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import integracion.transactions.TransactionManager;
import negocio.factura.Pair;

public class MostrarTopPeliculas implements Query{

	public Object execute(Object param) throws Exception{
		LinkedList<Pair<String, Integer>> lista = new LinkedList<Pair<String, Integer>>();
		int numTop = (Integer) param, numPelis = 0;
		Connection conexion;
		PreparedStatement pStatement;
		ResultSet rs;
		
		
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("SELECT peliculas.nombre, SUM(cantidad) AS ventas_totales FROM pase JOIN peliculas USING (id_peliculas) JOIN linea_factura USING (id_pase) WHERE peliculas.activo = true AND pase.activo = true GROUP BY id_peliculas ORDER BY ventas_totales DESC;");
			rs = pStatement.executeQuery();
			while (rs.next() && numPelis < numTop){
				lista.add(new Pair<String, Integer>(rs.getString(1), rs.getInt(2)));
				numPelis++;
			}
			pStatement.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
