package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.println("Room number: ");
			int number = scan.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(scan.next());
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(scan.next());
	
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
	
			System.out.println("Enter data do update the reservation:");
			System.out.println("Check-in date (dd/MM/yyyy) : ");
			checkIn = sdf.parse(scan.next());
			System.out.println("Check-out date (dd/MM/yyyy) : ");
			checkOut = sdf.parse(scan.next());
	
			reservation.updateDates(checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		}
		catch(ParseException e) {
			System.out.println("Invalid date format");
		}
		catch(DomainException e) {
			System.out.println("Error in Reservation: "+e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error ");
		}
		finally {
			scan.close();
		}
		

	}

}
