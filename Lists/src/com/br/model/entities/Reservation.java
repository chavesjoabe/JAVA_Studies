package com.br.model.entities;

import com.br.model.exceptions.DomainExeception;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    //a classe SimpleDateFormat formata uma data para a máscara que eu escolher

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {
            throw  new DomainExeception("the dates must be futures") ;
        }

        if (!checkOut.after(checkIn)) {
            throw new DomainExeception("check-out date must be after check-in");
        } else {
            this.roomNumber = roomNumber;
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }
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

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime(); // o getTime() retorna a diferença em milissegundos
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //o TimeUnit.DAYS.convert converte o resultado do diff para milissegundos
    }

    public void updateDates(Date checkIn, Date checkOut) {

        Date now = new Date();

        if (checkIn.before(now) || checkOut.before(now)) {
            throw  new DomainExeception("the dates must be futures") ;
        }

        if (!checkOut.after(checkIn)) {
            throw new DomainExeception("check-out date must be after check-in");
        } else {
            this.checkIn = checkIn;
            this.checkOut = checkOut;
        }

    }

    @Override
    public String toString() {
        return "Room: "+ roomNumber +
                " || Check-in: "
                +sdf.format(checkIn)
                +" || Check-out: "
                +sdf.format(checkOut)
                +", "+ duration() +
                " nights";
    }
}
