package negocio.empleado;

import java.util.List;

public interface SAEmpleado {

	int registrarEmpleado(TEmpleado empleado) throws Exception;
	int borrarEmpleado(int id) throws Exception;
	int modificarEmpleado(TEmpleado empleado) throws Exception;
	TEmpleado buscarEmpleadoPorID(int id) throws Exception;
	List<TEmpleado> mostrarListaEmpleados() throws Exception;
	List<TEmpleado> mostrarEmpleadosPorJornada(boolean esCompleta) throws Exception;
	
}
