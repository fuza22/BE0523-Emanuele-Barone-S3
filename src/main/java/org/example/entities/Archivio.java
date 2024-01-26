package org.example.entities;

import org.example.DAO.*;

import java.time.LocalDate;

public class Archivio {

    public static void main(String[] args) {

        DatiCartaceiDAO datiCartaceiDAO = new DatiCartaceiDAO();
        LibriDAO libriDAO = new LibriDAO();
        PrestitoDAO prestitoDAO = new PrestitoDAO();
        RivisteDAO rivisteDAO = new RivisteDAO();
        UtenteDAO utenteDAO = new UtenteDAO();


        Libri l1 = new Libri();

        l1.setTitolo("Le colline hanno gli occhi");
        l1.setAutore("Pippo Franco");
        l1.setGenere(Genere.HORROR);
        l1.setAnnoPubblicazione(2022);
        l1.setNumPagine(1250);

        libriDAO.save(l1);


        Riviste r1 = new Riviste();

        r1.setTitolo("Chi");
        r1.setPeriodicita(Periodicita.SETTIMANALE);
        r1.setAnnoPubblicazione(2024);
        r1.setNumPagine(300);

        rivisteDAO.save(r1);

        Utente u1 = new Utente();

        u1.setNome("Emanuele");
        u1.setCognome("Barone");
        u1.setDataDiNascita(LocalDate.of(1996,05, 22));

        utenteDAO.save(u1);

        Prestito p1 = new Prestito();

        p1.setUtente(u1);
        p1.setElementoPrestato(r1);
        p1.setDataInizioPrestito(LocalDate.of(2024, 01, 26));
        // p1.setDataRestituzioneEffettiva(LocalDate.of(2024, 02, 15));
        p1.setDataRestituzionePrevista(LocalDate.of(2024,01,25));


        prestitoDAO.save(p1);

        System.out.println(datiCartaceiDAO.findYear(2024));
        System.out.println(libriDAO.findAutore("Pippo Franco"));
        System.out.println(datiCartaceiDAO.findTitolo("le"));

        System.out.println(prestitoDAO.findPrestiti(1802));
        System.out.println(prestitoDAO.findOtherP());
    }


}


