package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	/*
	 * pra não ficar instanciando toda vez o SimpleDateFormat já declara uma constante sdf
	 * o static é para que não precise de uma cópia do objeto sdf para cada post da aplicação
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

	public long duration() { //long é tipo de inteiro com muitos algarismos, pois a duração será em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime(); //diferença de tempo da hospedagem em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converteu de milisegundos para dias
	}

	public void updateDates(Date checkIn, Date checkOut) { //Atualizará checkIn e checkOut
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	/*
	 * Usará o toString para mostrar os dados da reserva. 
	 * Como é uma sobreposição, usará @Override
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
