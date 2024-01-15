package integracion.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionImpl implements Transaction {
	private Connection conn;
	
	private final String username = "msfilms";
	private final String password = "msfilms";
	private final String url = "jdbc:mysql://79.148.41.241:3306/isfilms";

	public void start() {
		try {
			conn = DriverManager.getConnection(url,username, password);
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void commit(){
		try {
			conn.commit();
			conn.close();
			TransactionManager.getInstance().removeTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void rollback(){
		try {
			conn.rollback();
			conn.close();
			TransactionManager.getInstance().removeTransaction();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getResource() {
		return conn;
	}
}