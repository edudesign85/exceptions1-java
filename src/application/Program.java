package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		/*
		 *  usar� tratamento de exce��es com Try e catch. Em try coloca c�digo normal supondo que n�o haver� erros 
		 *  Quando ocorre exce��es em try interrompe o programa e cai em catch, que tratar� exce��es
		 */
		
		try {
			
			// Abaixo a parte de implementa��o da reserva
			
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut); // aqui o construtor onde instanciou um objeto do tipo Reservation com nome reservation
			System.out.println("Reservation: " + reservation);
			
		
			// Abaixo a parte de atualiza��o da reserva
		
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); // como essas vari�veis j� foram declaradas acima, n�o pode repetir o tipo delas, como Date
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut); // chamou o m�todo updateDates da classe Reservation para usar no objeto reservation
			System.out.println("Reservation: " + reservation);
		}

		catch (ParseException e) { //criou uma vari�vel para a exce��o relacionada �s datas recebidas
			System.out.println("Invalid date format");
		}
		catch (DomainException e) { //criou uma vari�vel para a exce��o relacionada �s datas recebidas
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		catch (RuntimeException e) { //para evitar que qualquer exce��o inesperada possa acontecer e quebrar programa, colocar� mensagem 			
			System.out.println("Unexpected error");
		}
			
		sc.close();
	}	
}


