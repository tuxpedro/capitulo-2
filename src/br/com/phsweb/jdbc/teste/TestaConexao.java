package br.com.phsweb.jdbc.teste;

import java.sql.Connection;
import java.sql.SQLException;

import br.com.phsweb.jdbc.ConnectionFactory;

public class TestaConexao {
	public static void main(String[] args) {

		try {
			Connection connection = new ConnectionFactory().getConnection();
			System.out.println("Conexão Aberta!");
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

}
