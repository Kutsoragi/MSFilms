package negocio.pelicula;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import integracion.factoria_dao.DAOFactoria;
import integracion.factoria_query.QueryFactory;
import integracion.pase.DAOPase;
import integracion.pelicula.DAOPelicula;
import integracion.transactions.Transaction;
import integracion.transactions.TransactionManager;
import negocio.factura.Pair;
import negocio.pase.TPase;

public class SAPeliculaImpl implements SAPelicula {
	
	public int registrarPelicula(TPelicula pelicula) throws Exception {
		int respuesta = 0;
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();
		
		DAOPelicula daoPelicula = DAOFactoria.getInstancia().generarDAOPelicula();
		TPelicula peliculaLeida = daoPelicula.buscarPeliculaPorNombre(pelicula.nombre);
			
		if (peliculaLeida == null){
			respuesta = daoPelicula.registrarPelicula(pelicula);
			transaction.commit();
		}
		else if (peliculaLeida != null && !peliculaLeida.isActivo()){
			peliculaLeida.setActivo(true);
			daoPelicula.modificarPelicula(peliculaLeida);
			respuesta = peliculaLeida.getID();
			transaction.commit();
		}
		else{
			transaction.rollback();
		}

		return respuesta;	
	}

	public int modificarPelicula(TPelicula pelicula) throws Exception {
		
		int respuesta = 0;
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();
		
		DAOPelicula daoPelicula = DAOFactoria.getInstancia().generarDAOPelicula();
		TPelicula peliculaLeida = daoPelicula.buscarPeliculaPorID(pelicula.getID());
		
		if (peliculaLeida != null && peliculaLeida.isActivo()){
			pelicula.setActivo(true);
			respuesta = daoPelicula.modificarPelicula(pelicula);
			transaction.commit();
		}else{
			transaction.rollback();
		}

		return respuesta;	
	}

	public int borrarPelicula(int id) throws Exception {
		if (id < 1) throw new IllegalArgumentException("ID incorrecto.");
		
		int respuesta = 0;
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();

		DAOPelicula daoPelicula = DAOFactoria.getInstancia().generarDAOPelicula();
		TPelicula peliculaLeida = daoPelicula.buscarPeliculaPorID(id);
		DAOPase daoPase = DAOFactoria.getInstancia().generarDAOPase();
		
		if (peliculaLeida != null  && peliculaLeida.isActivo()){
			List<TPase> listaPases = daoPase.mostrarPasesPorPeliculas(peliculaLeida.getID());
			if (listaPases.isEmpty()){
				respuesta = daoPelicula.borrarPelicula(id);
				transaction.commit();
			}
			else{
				transaction.rollback();
				throw new IllegalArgumentException("La pelicula no se ha podido borrar por tener pases asociados");
			}
		}
		else{
			transaction.rollback();
		}
		
		return respuesta;	
	}

	public TPelicula buscarPeliculaPorID(int id) throws Exception {
		if (id < 1) throw new IllegalArgumentException("ID incorrecto.");
		
		TPelicula respuesta = null;
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();
		
		DAOPelicula daoPelicula = DAOFactoria.getInstancia().generarDAOPelicula();
		
		
		respuesta = daoPelicula.buscarPeliculaPorID(id);
		
	
		if(respuesta != null  && respuesta.isActivo()){
			transaction.commit();
		}else{
			respuesta = null;
			transaction.rollback();
		}
		
		return respuesta;	
	}

	public List<TPelicula> mostrarListaPeliculas() throws Exception {
		
		List<TPelicula> respuesta = null;
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();
		
		DAOPelicula daoPelicula = DAOFactoria.getInstancia().generarDAOPelicula();
		
		
		respuesta = daoPelicula.mostrarListaPeliculas();
		
		if(respuesta != null){
			transaction.commit();
		}
		else{
			transaction.rollback();
		}
		
		return respuesta;	
	}

	@SuppressWarnings("unchecked")
	public List<TPelicula> mostrarPeliculasPorFecha(String fecha) throws Exception {  	
		List<TPelicula> respuesta = null;
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();
		
		
		try{
			verificarFecha(fecha);
		}
		catch (IllegalArgumentException e){
			transaction.rollback();
			throw e;
		}
		
		respuesta = (List<TPelicula>) QueryFactory.getInstance().mostrarPeliculasPorFecha().execute(fecha);
		
		if(respuesta != null){
			transaction.commit();
		}else{
			transaction.rollback();
		}
	
		return respuesta;	
	}
	
	@SuppressWarnings("unchecked")
	public LinkedList<Pair<String, Integer>> peliculasMasVendidas(int numTop) throws Exception {  			
		
		LinkedList<Pair<String, Integer>> lista = null;
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();
		
		lista = (LinkedList<Pair<String, Integer>>) QueryFactory.getInstance().mostrarTopPeliculas().execute(numTop);
		
		transaction.commit();
		
		return lista;
	}
	
	private void verificarFecha(String fecha) {
		try {
			new SimpleDateFormat("YYYY-MM-DD").parse(fecha);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Fecha incorrecta. Formato fecha: " + "YYYY-MM-DD" + ".");
		}
	}
}
