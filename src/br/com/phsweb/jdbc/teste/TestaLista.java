package br.com.phsweb.jdbc.teste;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import br.com.phsweb.jdbc.dao.ContatoDao;
import br.com.phsweb.jdbc.modelo.Contato;

public class TestaLista {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ContatoDao dao = new ContatoDao();

		List<Contato> contatos = dao.getLista();

		for (Contato contato : contatos) {
			System.out.println("Nome: " + contato.getName());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Endereço: " + contato.getEndereco());

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			System.out.println("Data Nascimento DD/MM/AAAA: "
					+ sdf.format(contato.getDataNascimento().getTime()));

			Locale brasil = new Locale("pt", "BR");
			DateFormat f2 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
			System.out.println("Data nascimento - POR EXTENSO: "
					+ f2.format(contato.getDataNascimento().getTime()));

			System.out.println("<==========================>>>");

		}

	}
}
