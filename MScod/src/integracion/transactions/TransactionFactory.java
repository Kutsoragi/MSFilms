package integracion.transactions;

public abstract class TransactionFactory {

	private static TransactionFactory instance = null;
	
	public synchronized static TransactionFactory getInstancia() {
		if (instance == null)
			instance = new TransactionFactoryImpl();
		
		return instance;
	}
	
	public abstract Transaction getTransaction();
}
