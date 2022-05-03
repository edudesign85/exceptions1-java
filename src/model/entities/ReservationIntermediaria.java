package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class ReservationIntermediaria {
	
	/*
	 * pra não ficar instanciando toda vez o SimpleDateFormat já declara uma constante sdf
	 * o static é para que não precise de uma cópia do objeto sdf para cada post da aplicação
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

	public long duration() { //long é tipo de inteiro com muitos algarismos, pois a duração será em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime(); //diferença de tempo da hospedagem em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converteu de milisegundos para dias
	}

	/*
	 *  Na questão diz que não poderá atualizar a reserva se as datas forem do passado. 
	 *  Abaixo a solução intermediária inserida no método updateDates. A lógica já está na classe de reserva
	 *  Porém o método só retornará a exceção em uma String e pra isso passará de Void para String
	 *  Caso não tenha erro, retornará o aviso de nulo para informar 
	 *  Para mostrar os avisos, criou uma variável de String que receberá o return e mostrará os avisos
	 */
	
	public String updateDates(Date checkIn, Date checkOut) { //Atualizará checkIn e checkOut
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) { // se a data digitada de check-in ou check-out for antes de hoje 
			return "Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) { // se a data de check-out não for depois do check-in mostrará erro
			return "Check-out date must be after check-in date";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
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
