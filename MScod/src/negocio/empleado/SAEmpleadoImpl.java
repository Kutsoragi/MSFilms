package negocio.empleado;

import java.util.LinkedList;
import java.util.List;

import integracion.empleado.DAOEmpleado;
import integracion.factoria_dao.DAOFactoria;
import integracion.transactions.Transaction;
import integracion.transactions.TransactionManager;

public class SAEmpleadoImpl implements SAEmpleado {

	public int registrarEmpleado(TEmpleado empleado) throws Exception {

		int id = 0;
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();
		
		DAOEmpleado daoEmpleado = DAOFactoria.getInstancia().generarDAOEmpleado();
		TEmpleado empleadoLeido = daoEmpleado.buscarEmpleadoPorDNI(empleado.getDNI());
		
		if (empleadoLeido == null){
			id = daoEmpleado.registrarEmpleado(empleado);
			transaction.commit();
		}
		else if (empleadoLeido != null && !empleadoLeido.isActivo()){
			empleadoLeido.setActivo(true);
			daoEmpleado.modificarEmpleado(empleadoLeido);
			id = empleadoLeido.getID();
			transaction.commit();
		}
		else{
			transaction.rollback();
		}
		
		return id;
	}

	public int borrarEmpleado(int id) throws Exception {
		int resp = 0;
		
		if (id < 1) throw new IllegalArgumentException("ID incorrecto.");
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();

		DAOEmpleado daoEmpleado = DAOFactoria.getInstancia().generarDAOEmpleado();
		TEmpleado empleadoLeido = daoEmpleado.buscarEmpleadoPorID(id);

		if (empleadoLeido != null && empleadoLeido.isActivo()) {
			resp = daoEmpleado.borrarEmpleado(id);
			transaction.commit();
		} else {
			transaction.rollback();
		}
		
		return resp;
	}

	public int modificarEmpleado(TEmpleado empleado) throws Exception {

		int id = 0;
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();
		
		DAOEmpleado daoEmpleado = DAOFactoria.getInstancia().generarDAOEmpleado();
		TEmpleado empleadoLeido = daoEmpleado.buscarEmpleadoPorDNI(empleado.getDNI());
		
		if (empleadoLeido != null && empleadoLeido.isActivo()) {
			empleado.setActivo(true);
			daoEmpleado.modificarEmpleado(empleado);
			transaction.commit();
			id = 1;
		} else {
			transaction.rollback();
		}

		return id;
	}

	public TEmpleado buscarEmpleadoPorID(int id) throws Exception {
		if (id < 1) throw new IllegalArgumentException("ID incorrecto.");

		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();
		
		DAOEmpleado daoEmpleado = DAOFactoria.getInstancia().generarDAOEmpleado();
		TEmpleado respuesta = daoEmpleado.buscarEmpleadoPorID(id);

		if (respuesta != null && respuesta.isActivo()) {
			transaction.commit();
		} else {
			respuesta = null;
			transaction.rollback();
		}

		return respuesta;
	}

	public LinkedList<TEmpleado> mostrarListaEmpleados() throws Exception {
		
		LinkedList<TEmpleado> lista = null;
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();
		
		DAOEmpleado daoEmpleado = DAOFactoria.getInstancia().generarDAOEmpleado();
		lista = daoEmpleado.mostrarListaEmpleados();
		 
		 if(lista != null){
			transaction.commit();
		}
		 else{
			transaction.rollback();
		}

		return lista;
	}

	public List<TEmpleado> mostrarEmpleadosPorJornada(boolean esCompleta) throws Exception {
		
		List<TEmpleado> lista = null;
		
		Transaction transaction = TransactionManager.getInstance().newTransaction();
		transaction.start();
		
		DAOEmpleado daoEmpleado = DAOFactoria.getInstancia().generarDAOEmpleado();
		lista = daoEmpleado.mostrarEmpleadosPorJornada(esCompleta);
		
		if(lista != null){
			transaction.commit();
		}
		 else{
			transaction.rollback();
		}
		
		return lista;
		
	}
}