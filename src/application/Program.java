package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		
		// Abaixo a parte de implementação da reserva
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if (!checkOut.after(checkIn)) { // se a data de check-out não for depois do check-in mostrará erro
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut); //instanciou um objeto do tipo Reservation com nome reservation
			System.out.println("Reservation: " + reservation);
		
			// Abaixo a parte de atualização da reserva
		
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); // como essas variáveis já foram declaradas acima, não pode repetir o tipo delas, como Date
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());


			/*
			 *  Na questão diz que não poderá atualizar a reserva se as datas forem do passado. 
			 *  Abaixo a solução muito ruim, pois implementará a lógica no programa principal. Devia estar na própria classe Reservation
			 *  Essa é pior versão. Tem um problema grave de delegação. Quem deve saber sobre reserva é a classe dedicada à reserva
			 */
			
			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) { // se a data digitada de check-in ou check-out for antes de hoje 
				System.out.println("Error in reservation: Reservation dates for update must be future");
			}
			
			else if (!checkOut.after(checkIn)) { // se a data de check-out não for depois do check-in mostrará erro
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			
			else {
				reservation.updateDates(checkIn, checkOut); // chamou o método updateDates da classe Reservation para usar no objeto reservation
				System.out.println("Reservation: " + reservation);
			}
			
		}
		
		sc.close();
	}
}
