package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	/*
	 * pra n�o ficar instanciando toda vez o SimpleDateFormat j� declara uma constante sdf
	 * o static � para que n�o precise de uma c�pia do objeto sdf para cada post da aplica��o
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	public Reservation() {
		super();
	}
			
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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

	public void updateDates(Date checkIn, Date checkOut) { //Atualizar� checkIn e checkOut
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
