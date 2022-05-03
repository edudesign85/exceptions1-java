package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException { //n�o teria nessa segunda vers�o, mas deixou para fins did�ticos

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		
		// Abaixo a parte de implementa��o da reserva
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) { // se a data de check-out n�o for depois do check-in mostrar� erro
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut); //instanciou um objeto do tipo Reservation com nome reservation
			System.out.println("Reservation: " + reservation);
		
			// Abaixo a parte de atualiza��o da reserva
		
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); // como essas vari�veis j� foram declaradas acima, n�o pode repetir o tipo delas, como Date
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());


			/*
			 *  Na quest�o diz que n�o poder� atualizar a reserva se as datas forem do passado. 
			 *  Abaixo a solu��o intermedi�ria inserida no m�todo updateDates. A l�gica j� est� na classe de reserva
			 *  Por�m o m�todo updateDates da classe s� retornar� a exce��o em uma String e pra isso passar� de Void para String
			 *  Caso n�o tenha erro, retornar� o aviso de nulo para informar 
			 *  Para mostrar os avisos, foi criada abaixo a vari�vel error, que receber� o return e mostrar� os avisos
			 */
			
			String error = reservation.updateDates(checkIn, checkOut); // chamou o m�todo updateDates da classe Reservation para usar no objeto reservation
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}	
			else {
				System.out.println("Reservation: " + reservation);
			}
		}
			
		sc.close();
	}	
}


