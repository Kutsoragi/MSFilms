package integracion.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import integracion.transactions.TransactionManager;
import negocio.pelicula.TPelicula;

public class MostrarPeliculasPorFecha implements Query {

	public Object execute(Object param) throws Exception {
		LinkedList<TPelicula> lista = new LinkedList<TPelicula>();
		Connection conexion;
		PreparedStatement pStatement;
		ResultSet rs;
		
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("SELECT DISTINCT PE.id_peliculas, PE.nombre, PE.duracion FROM peliculas PE JOIN pase PA USING (id_peliculas) WHERE PE.activo = true AND PA.fecha = ?");
			pStatement.setString(1, (String) param);
			rs = pStatement.executeQuery();
			while (rs.next()){
				lista.add(new TPelicula(rs.getInt(1), rs.getInt(3), rs.getString(2)));
			}
			pStatement.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
