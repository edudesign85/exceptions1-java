package model.exceptions;

public class DomainException extends RuntimeException { // é uma subclasse da Classe nativa, que não obriga a lançar as exceções nos métodos em Reservation

	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) { // fez construtor que recebe string como argumento e armazena dentro da exceção
		super(msg);
	}
}
