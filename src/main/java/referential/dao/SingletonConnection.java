package referential.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {

	private static final String DIRNAME = "./src/main/resources/";

	private static final String DRIVER = "org.h2.Driver";
	private static final String URL = "jdbc:h2:file:" + DIRNAME + "test";
	private static final String USERNAME = "sa";
	private static final String PASSWORD = "";

	private static final String CREATE = "RUNSCRIPT FROM '" + DIRNAME + "create.sql'";
	private static final String POPULATE = "RUNSCRIPT FROM '" + DIRNAME + "populate.sql'";
	private static final String URL_NEW = URL + ";INIT=" + CREATE + "\\;" + POPULATE;

	private static SingletonConnection instance;
	private static Connection connection;

	private SingletonConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER);
		connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}

	public static SingletonConnection getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new SingletonConnection();
		}
		return instance;
	}

	public Connection getConnection() {
		return connection;
	}

}
