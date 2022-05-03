package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationIntermediaria {
	
	/*
	 * pra n�o ficar instanciando toda vez o SimpleDateFormat j� declara uma constante sdf
	 * o static � para que n�o precise de uma c�pia do objeto sdf para cada post da aplica��o
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public ReservationIntermediaria() {
		super();
	}
			
	public ReservationIntermediaria(Integer roomNumber, Date checkIn, Date checkOut) {
		super();
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
	 *  Abaixo a solu��o intermedi�ria inserida no m�todo updateDates. A l�gica j� est� na classe de reserva
	 *  Por�m o m�todo s� retornar� a exce��o em uma String e pra isso passar� de Void para String
	 *  Caso n�o tenha erro, retornar� o aviso de nulo para informar 
	 *  Para mostrar os avisos, criou uma vari�vel de String que receber� o return e mostrar� os avisos
	 */
	
	public String updateDates(Date checkIn, Date checkOut) { //Atualizar� checkIn e checkOut
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) { // se a data digitada de check-in ou check-out for antes de hoje 
			return "Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) { // se a data de check-out n�o for depois do check-in mostrar� erro
			return "Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
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
