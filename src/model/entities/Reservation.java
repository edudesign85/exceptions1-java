package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	/*
	 * pra não ficar instanciando toda vez o SimpleDateFormat já declara uma constante sdf
	 * o static é para que não precise de uma cópia do objeto sdf para cada post da aplicação
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	
	/*
	 * No exercício já no início onde digita os dados iniciais, com argumentos passados pelos pelo construtor, tem exceção
	 * Construtor é o método para receber as informações iniciais dos objetos
	 * Por isso colocará a lógica de verificação com o if e propagará (lançará) a exceção criada também no construtor
	 * Como boa prática, colocará as exceções no início do método, antes de passar os argumentos
	 * Essa convenção chama de programação defensiva 
	 * A exceção será tratada no programa
	 */
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainException {
		if (!checkOut.after(checkIn)) { // se a data de check-out não for depois do check-in mostrará erro (tratamento do programa)
			throw new DomainException("Check-out date must be after check-in date"); //lançou a exceção criada e passou mensagem
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

	public long duration() { //long é tipo de inteiro com muitos algarismos, pois a duração será em milisegundos
		long diff = checkOut.getTime() - checkIn.getTime(); //diferença de tempo da hospedagem em milisegundos
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); // converteu de milisegundos para dias
	}

	/*
	 *  Na questão diz que não poderá atualizar a reserva se as datas forem do passado. 
	 *  Criou método que poderá propagar a exceção na assinatura do método e tratará com o catch no programa, se acontecer exceção
	 */
	
	public void updateDates(Date checkIn, Date checkOut) throws DomainException { //Propagou a exceção
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) { // se a data digitada de check-in ou check-out for antes de hoje 
			throw new DomainException("Reservation dates for update must be future dates"); //lançou a exceção criada e passou mensagem
		}
		if (!checkOut.after(checkIn)) { // se a data de check-out não for depois do check-in mostrará erro
			throw new DomainException("Check-out date must be after check-in date"); //lançou a exceção criada e passou mensagem
		}
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
