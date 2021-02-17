package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number: ");
		int number = scan.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(scan.next());
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(scan.next());

		// Condicional que testa se uma data vem depois de outra, no caso testa se a
		// data de checkout não veio depois da data de checkin checkOut<checkIn

		if (!checkOut.after(checkIn)) {
			System.out.println("Erros in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			System.out.println("Enter data do update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(scan.next());
			System.out.println("Check-out date (dd/MM/yyyy) : ");
			checkOut = sdf.parse(scan.next());

			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			} else {
				System.out.println(reservation);
			}
 
		}

		scan.close();

	}

}
