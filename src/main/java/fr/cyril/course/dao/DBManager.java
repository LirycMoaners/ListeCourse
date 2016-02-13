package fr.cyril.course.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private static Connection connect;

	private DBManager() {
	}

	private static void initConnexion(String driver, String url, String login,
			String password) throws SQLException {
		try {
			Class.forName(driver);
			connect = DriverManager.getConnection(url, login, password);
			connect.setAutoCommit(false);
			System.out.println("Connexion reussie");
		} catch (ClassNotFoundException e) {
			System.out.println("erreur chargement pilote JDBC \n");
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("erreur connexion base de données \n"
					+ e.getMessage());
			System.exit(0);
		}
	}

	public static Connection getConnect() throws SQLException {
		if (!(connect instanceof Connection)) {
			initConnexion("com.mysql.jdbc.Driver",
					"jdbc:mysql://localhost:3306/listeCourse", "root", "");
		}
		return connect;
	}
}
