package carSharing.validators;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Validator {

    public static void requireNotNull(Object myObject){
        if(myObject == null){
            throw new NullPointerException("L'input passato" + myObject + "è null");
        }
    }

    public static void requireNotBlank(String s){
        if(s.isBlank()){
            throw new IllegalArgumentException("La stringa non ouò essere blank");
        }
    }

    public static void requireDateAfter(LocalDate dateTime1, LocalDate dateTime2){
        if(dateTime1.isBefore(dateTime2)){
            throw new IllegalArgumentException("La data di prenotazione non può essere nel passato!");
        }
    }
    public static void requireDateAfter(LocalDateTime dateTime1, LocalDateTime dateTime2){
        if(dateTime1.isBefore(dateTime2)){
            throw new IllegalArgumentException("La data di prenotazione non può essere nel passato!");
        }
    }

    public static void requireDateBefore(LocalDate dateTime1, LocalDate dateTime2){
        if(dateTime1.isAfter(dateTime2)){
            throw new IllegalArgumentException("La data di nascita non può essere nel futuro");
        }
    }
    public static void requireDateBefore(LocalDateTime dateTime1, LocalDateTime dateTime2){
        if(dateTime1.isAfter(dateTime2)){
            throw new IllegalArgumentException("La data di nascita non può essere nel futuro");
        }
    }

}
