package com.br.program;

import com.br.model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class application {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Room number: ");
        int number = scanner.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(scanner.next());
        System.out.print("Check-out date: ");
        Date checkOut = sdf.parse(scanner.next());

        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {
            System.out.println("Error in reservation: the dates must be futures");
        } else if (!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: check-out date must be after check-in");
        } else {
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);


            System.out.println();
            System.out.println("Enter data to update the reservation: ");

            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(scanner.next());
            System.out.print("Check-out date: ");
            checkOut = sdf.parse(scanner.next());

            String error = reservation.updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            } else {
                System.out.println(reservation);
            }
        }

    }
}
