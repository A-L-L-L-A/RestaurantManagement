package management.connection;


import java.sql.Connection;

import org.apache.log4j.Logger;

import management.exception.DaoException;
import managment.servlet.Controller;


public class ConnectionPool {

	private static final Logger logger = Logger.getLogger(ConnectionPool.class);

	private ConnectionPool() {
	}
	
	public static synchronized Connection getConnection() {
		try {
			Connection con = Controller.dataSource.getConnection();
			logger.trace("connection retrived");
			return con;
		} catch (Exception e) {
			logger.error("Cannot obtain connection");
			throw new DaoException(e);
		}
	}
}
