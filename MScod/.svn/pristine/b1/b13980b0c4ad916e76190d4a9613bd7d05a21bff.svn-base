
package integracion.transactions;

import java.util.concurrent.ConcurrentHashMap;

public class TransactionManagerImpl extends TransactionManager {
	private ConcurrentHashMap<Thread, Transaction> map;

	public TransactionManagerImpl() {
		this.map = new ConcurrentHashMap<Thread, Transaction>();
	}

	public Transaction newTransaction() throws Exception{
		Thread currentThread = Thread.currentThread();
		Transaction currentTransaction = map.get(currentThread);
		if (currentTransaction == null) {
			currentTransaction = TransactionFactory.getInstancia().getTransaction();
			map.put(currentThread, currentTransaction);
		}
		else
			throw new Exception("No se ha podido iniciar la transaccion");
		return currentTransaction;
	}

	public void removeTransaction() {
		map.remove(Thread.currentThread());
	}

	public Transaction getTransaction() {
		return map.get(Thread.currentThread());
	}
}