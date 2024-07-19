package JavaDatabaseConnectivity.src.java.main.br.com.arthurferreira.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author arthur.ferreira
 */

public class ConnectionFactory {

	private static final String URL = "jdbc:postgresql://localhost:5432/loja_online";
	private static final String USER = "postgres";
	private static final String PASSWORD = "Preto2210";

	private static Connection connection;

	private ConnectionFactory(Connection connection) {

	}

	public static Connection getConnection() throws SQLException {
		if (connection == null) {
			connection = initConnection();
			return connection;
		} else if (connection.isClosed()) {
			connection = initConnection();
			return connection;
		} else {
			return connection;
		}
	}

	private static Connection initConnection() {
		try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
}
