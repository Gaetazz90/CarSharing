import carSharing.admin.Admin;
import carSharing.dtoUtenteRegisterInput.UtenteRegisterRequest;
import carSharing.entities.noleggio.Noleggio;
import carSharing.entities.utente.TipoPatente;
import carSharing.entities.utente.Utente;
import carSharing.entities.veicolo.Automobile;
import carSharing.entities.veicolo.Veicolo;
import carSharing.exceptions.VeicoloNotAvailable;
import carSharing.exceptions.VeicoloNotFound;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws VeicoloNotFound, VeicoloNotAvailable, InterruptedException {

        Utente utente1 = Admin.registerUtente(new UtenteRegisterRequest(
                "Pippo",
                "Baudo",
                LocalDate.of(1984, 12,13),
                "ABCKJL80G14S105L"));
        System.out.println(utente1);

        Veicolo auto1 = Admin.insertVeicolo(new Automobile(
                3.0,
                TipoPatente.TIPO_B,
                "AB123FG"));
        System.out.println(auto1);

        Noleggio noleggio1 = utente1.attivaNoleggio(auto1.getId());
        System.out.println(noleggio1);

        Thread.sleep(4 * 60 * 1000);

        Double costoNoleggio1 = utente1.terminaNoleggio(noleggio1);
        System.out.println("Prezzo da pagare: " + costoNoleggio1);

    }


}