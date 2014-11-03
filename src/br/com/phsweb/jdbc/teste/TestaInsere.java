package br.com.phsweb.jdbc.teste;

import java.util.Calendar;

import br.com.phsweb.jdbc.dao.ContatoDao;
import br.com.phsweb.jdbc.modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Contato contato = new Contato();

		contato.setName("JoseLitro");
		contato.setEmail("jose@test.com");
		contato.setEndereco("Rua Ladeira n 1000 bairro São Jose, Pedra Azul/MG");
		contato.setDataNascimento(Calendar.getInstance());

		ContatoDao dao = new ContatoDao();
		dao.adicionaContato(contato);

		System.out.println("gravado!");

	}

}
