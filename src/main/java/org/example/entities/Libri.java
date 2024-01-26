package org.example.entities;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
@Entity
@Table(name = "libri")
@NamedQuery(name = "findAutore", query = "select a from Libri a where a.autore = :autore")
public class Libri extends DatiCartacei {

    private String autore;
    @Enumerated(EnumType.STRING)
    private Genere genere;

    public Libri(){}

    public Libri(long codiceISBN, String titolo, int annoPubblicazione, int numPagine, String autore, Genere genere) {
        super(codiceISBN, titolo, annoPubblicazione, numPagine);
        this.autore = autore;
        this.genere = genere;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

//    public static Libri creaLibro(String titolo, int annoPubblicazione, int numPagine, String autore, Genere ...genere){
//
//        Random random = new Random();
//        Long codiceISBN = random.nextLong();
//
//        Libri nuovoLibro = new Libri(codiceISBN, titolo, annoPubblicazione, numPagine, autore, genere);
//        System.out.println("Libro " + "'"+ titolo + "'" + " creato.");
//
//        return nuovoLibro;
//    }

    @Override
    public String toString() {
        return super.toString() +
                "autore='" + autore + '\'' +
                ", genere=" + genere;
    }
}
