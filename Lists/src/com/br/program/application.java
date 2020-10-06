package com.br.program;

import com.br.model.entities.Reservation;
import com.br.model.exceptions.DomainExeception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.print("Room number: ");
            int number = scanner.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(scanner.next());
            System.out.print("Check-out date: ");
            Date checkOut = sdf.parse(scanner.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);


            System.out.println();
            System.out.println("Enter data to update the reservation: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(scanner.next());
            System.out.print("Check-out date: ");
            checkOut = sdf.parse(scanner.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);
        }
        catch (ParseException e){
            System.out.println("invalid date format");
        }
        catch (DomainExeception e){
            System.out.println("Error in reservation: "+ e.getMessage());
        }
        catch (RuntimeException e){
            System.out.println("Unexpected error");
        }
        scanner.close();
    }
}
