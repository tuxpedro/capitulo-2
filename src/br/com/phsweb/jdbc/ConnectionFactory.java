package br.com.phsweb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		try {
			return DriverManager.getConnection(
					"jdbc:mysql://localhost/curso_ci", "root", "Senha123");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
