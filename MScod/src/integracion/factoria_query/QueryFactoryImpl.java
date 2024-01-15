package integracion.factoria_query;

import integracion.query.*;

public class QueryFactoryImpl extends QueryFactory{

	@Override
	public Query mostrarPeliculasPorFecha() {
		return new MostrarPeliculasPorFecha();
	}

	@Override
	public Query mostrarTopPeliculas() {
		return new MostrarTopPeliculas();
	}

}
