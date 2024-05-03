package MyGame;

import java.sql.Connection;
import java.sql.DriverManager;


//JDBC connector
public class DatabaseConnection {
	private static Connection connetion;
	public Connection databaseLink;

	public static Connection getConnetion() {
		Connection connetion = null;
		return connetion;
	}

	public static void setConnetion(Connection connection) {
		DatabaseConnection.connetion = connection;
	}

	public static DatabaseConnection getInstance() {
		return null;
	}

	public Connection getConnection() {
		String databaseName = "gamedb";
		String databaseUser = "root";
		String databasePassword = "rivi";
		String url = "jdbc:mysql://localhost:3306/" + databaseName;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //jdbc Driver
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
		} catch (Exception e) {
			e.printStackTrace();
			e.getCause();
		}

		return databaseLink;
	}
}
