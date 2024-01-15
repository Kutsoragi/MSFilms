package integracion.pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import integracion.transactions.TransactionManager;
import negocio.pelicula.TPelicula;

public class DAOPeliculaImpl implements DAOPelicula{
	
	Connection conexion;
	PreparedStatement pStatement;
	ResultSet rs;


	public int registrarPelicula(TPelicula tPelicula) {
		Integer idPeli = 0;
		
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("INSERT INTO peliculas (id_peliculas, nombre, duracion) VALUES (null,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			pStatement.setString(1, tPelicula.getNombre());
			pStatement.setInt(2, tPelicula.getDuracion());
			pStatement.executeUpdate();
			rs = pStatement.getGeneratedKeys();
			if (rs.next()){
				idPeli = rs.getInt(1);
			}
			closeStatement();
			closeResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return idPeli;
	}

	public int modificarPelicula(TPelicula tPelicula) {
		Integer peli = 0;
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("UPDATE peliculas SET nombre = ?, duracion = ?, activo = ?  WHERE id_peliculas = " + tPelicula.getID());
			pStatement.setString(1, tPelicula.getNombre());
			pStatement.setInt(2, tPelicula.getDuracion());
			pStatement.setBoolean(3, tPelicula.isActivo());
			pStatement.executeUpdate();
			peli = tPelicula.getID();
			closeStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peli;
	}

	public int borrarPelicula(int id) {
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("UPDATE peliculas SET activo = false WHERE id_peliculas = " + id);
			pStatement.executeUpdate();
			closeStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}

	public TPelicula buscarPeliculaPorID(int id) {
		TPelicula peli = null;
		
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("SELECT * FROM peliculas WHERE id_peliculas = " + id + " FOR UPDATE");
			rs = pStatement.executeQuery();
			if (rs.next()){
				peli = new TPelicula(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getBoolean(4));
			}
			closeStatement();
			closeResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peli;
	}
	
	public TPelicula buscarPeliculaPorNombre(String nombre) {
		TPelicula peli = null;
		
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("SELECT * FROM peliculas WHERE nombre = ? FOR UPDATE");
			pStatement.setString(1, nombre);
			rs = pStatement.executeQuery();
			if (rs.next()){
				peli = new TPelicula(rs.getInt(1), rs.getInt(3), rs.getString(2), rs.getBoolean(4));
			}
			closeStatement();
			closeResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return peli;
	}

	public LinkedList<TPelicula> mostrarListaPeliculas() {
		LinkedList<TPelicula> lista = new LinkedList<TPelicula>();
		try {
			conexion = (Connection)TransactionManager.getInstance().getTransaction().getResource();
			
			pStatement = conexion.prepareStatement("SELECT * FROM peliculas WHERE activo = true");
			rs = pStatement.executeQuery();
			while (rs.next()){
				lista.add(new TPelicula(rs.getInt(1), rs.getInt(3), rs.getString(2)));
			}
			closeStatement();
			closeResultSet();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	private void closeResultSet() throws SQLException {
		rs.close();
	}
	
	private void closeStatement() throws SQLException {
		pStatement.close();
	}

}
