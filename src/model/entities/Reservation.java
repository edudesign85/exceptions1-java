package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	/*
	 * pra n�o ficar instanciando toda vez o SimpleDateFormat j� declara uma constante sdf
	 * o static � para que n�o precise de uma c�pia do objeto sdf para cada post da aplica��o
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	
	/*
	 * No exerc�cio j� no in�cio onde digita os dados iniciais, com argumentos passados pelos pelo construtor, tem exce��o
	 * Construtor � o m�todo para receber as informa��es iniciais dos objetos
	 * Por isso colocar� a l�gica de verifica��o com o if e propagar� (lan�ar�) a exce��o criada tamb�m no construtor
	 * Como boa pr�tica, colocar� as exce��es no in�cio do m�todo, antes de passar os argumentos
	 * Essa conven��o chama de programa��o defensiva 
	 * A exce��o ser� tratada no programa
	 */
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) { // se a data de check-out n�o for depois do check-in mostrar� erro (tratamento do programa)
			throw new DomainException("Check-out date must be after check-in date"); //lan�ou a exce��o criada e passou mensagem
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() { //long � tipo de inteiro com muitos algarismos, pois a dura��o ser� em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime(); //diferen�a de tempo da hospedagem em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converteu de milisegundos para dias
	}

	/*
	 *  Na quest�o diz que n�o poder� atualizar a reserva se as datas forem do passado. 
	 *  Criou m�todo que poder� propagar a exce��o na assinatura do m�todo e tratar� com o catch no programa, se acontecer exce��o
	 */
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException { //Propagou a exce��o
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) { // se a data digitada de check-in ou check-out for antes de hoje 
			throw new DomainException("Reservation dates for update must be future dates"); //lan�ou a exce��o criada e passou mensagem
		}
		if (!checkOut.after(checkIn)) { // se a data de check-out n�o for depois do check-in mostrar� erro
			throw new DomainException("Check-out date must be after check-in date"); //lan�ou a exce��o criada e passou mensagem
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	/*
	 * Usar� o toString para mostrar os dados da reserva. 
	 * Como � uma sobreposi��o, usar� @Override
	 */
	
	@Override
	public String toString() {
		return "Room" 
			+ roomNumber
			+ ", check-in: " 
			+ sdf.format(checkIn)
			+ ", check-out: " 
			+ sdf.format(checkOut)
			+ ", " 
			+ duration()
			+ " nights"; 
	}
	
	

}
