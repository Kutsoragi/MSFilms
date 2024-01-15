package integracion.pelicula;

import java.util.LinkedList;

import negocio.pelicula.TPelicula;

public interface DAOPelicula {
	
	public int registrarPelicula(TPelicula tPelicula);
	public int modificarPelicula(TPelicula tPelicula);
	public int borrarPelicula(int id);
	 public TPelicula buscarPeliculaPorID(int id);
	public LinkedList<TPelicula> mostrarListaPeliculas();
	//public LinkedList<TPelicula> mostrarPeliculasPorFecha(String fecha);
	public TPelicula buscarPeliculaPorNombre(String nombre);
	//public LinkedList<Pair<String, Integer>> mostrarTopPeliculas();
}
