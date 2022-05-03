package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException { //não teria nessa segunda versão, mas deixou para fins didáticos

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
			 *  Abaixo a solução intermediária inserida no método updateDates. A lógica já está na classe de reserva
			 *  Porém o método updateDates da classe só retornará a exceção em uma String e pra isso passará de Void para String
			 *  Caso não tenha erro, retornará o aviso de nulo para informar 
			 *  Para mostrar os avisos, foi criada abaixo a variável error, que receberá o return e mostrará os avisos
			 */
			
			String error = reservation.updateDates(checkIn, checkOut); // chamou o método updateDates da classe Reservation para usar no objeto reservation
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


