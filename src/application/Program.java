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
		 *  usará tratamento de exceções com Try e catch. Em try coloca código normal supondo que não haverá erros 
		 *  Quando ocorre exceções em try interrompe o programa e cai em catch, que tratará exceções
		 */
		
		try {
			
			// Abaixo a parte de implementação da reserva
			
			System.out.print("Room number: ");
			int number = sc.nextInt();
			System.out.print("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut); // aqui o construtor onde instanciou um objeto do tipo Reservation com nome reservation
			System.out.println("Reservation: " + reservation);
			
		
			// Abaixo a parte de atualização da reserva
		
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next()); // como essas variáveis já foram declaradas acima, não pode repetir o tipo delas, como Date
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
	
			reservation.updateDates(checkIn, checkOut); // chamou o método updateDates da classe Reservation para usar no objeto reservation
			System.out.println("Reservation: " + reservation);
		}

		catch (ParseException e) { //criou uma variável para a exceção relacionada às datas recebidas
			System.out.println("Invalid date format");
		}
		catch (DomainException e) { //criou uma variável para a exceção relacionada às datas recebidas
			System.out.println("Error in reservation: " + e.getMessage());
		}
		
		catch (RuntimeException e) { //para evitar que qualquer exceção inesperada possa acontecer e quebrar programa, colocará mensagem 			
			System.out.println("Unexpected error");
		}
			
		sc.close();
	}	
}


