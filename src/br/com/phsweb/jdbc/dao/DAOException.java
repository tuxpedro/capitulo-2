package br.com.phsweb.jdbc.dao;

public class DAOException extends RuntimeException {
	public DAOException(String mensagem) {
		super("Error" + mensagem);
	}
}
