package model.exceptions;

public class DomainException extends RuntimeException { // � uma subclasse da Classe nativa, que n�o obriga a lan�ar as exce��es nos m�todos em Reservation

	private static final long serialVersionUID = 1L;
	
	public DomainException(String msg) { // fez construtor que recebe string como argumento e armazena dentro da exce��o
		super(msg);
	}
}
