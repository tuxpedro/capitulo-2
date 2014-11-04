package br.com.phsweb.jdbc.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.phsweb.jdbc.ConnectionFactory;
import br.com.phsweb.jdbc.modelo.Contato;

public class ContatoDao {

	private Connection connection;

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionaContato(Contato contato) {
		String sql = "INSERT INTO contatos"
				+ "(nome, email, endereco, datanascimento) WHERE LIKE 'P%' AND LIKE 'R%' values(?,?,?,?)";

		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, contato.getName());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento()
					.getTimeInMillis()));

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<Contato>();
			java.sql.PreparedStatement stmt = this.connection
					.prepareStatement("SELECT * FROM contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setName(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("datanascimento"));
				contato.setDataNascimento(data);
				contatos.add(contato);

			}

			rs.close();
			stmt.close();
			return contatos;

		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}

	}
}
