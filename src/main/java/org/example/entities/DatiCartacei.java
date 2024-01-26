package org.example.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "dati_cartacei")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQuery(name = "findAnno", query = "select y from DatiCartacei y where y.annoPubblicazione = :anno")
@NamedQuery(name = "findTitolo", query = "select t from DatiCartacei t where lower(t.titolo) like lower(concat('%', :titolo, '%'))")
public abstract class DatiCartacei {

    @Id
    @Column(name = "codice_isbn")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long codiceISBN;
    private String titolo;
    @Column(name = "anno_pubblicazione")
    private int annoPubblicazione;
    @Column(name = "num_pagine")
    private int numPagine;

    public DatiCartacei(long codiceISBN, String titolo, int annoPubblicazione, int numPagine) {
        this.codiceISBN = codiceISBN;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numPagine = numPagine;
    }

    public DatiCartacei(String titolo, int annoPubblicazione, int numPagine) {
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numPagine = numPagine;
    }

    public DatiCartacei(){}

    public long getCodiceISBN() {
        return codiceISBN;
    }

    public void setCodiceISBN(long codiceISBN) {
        this.codiceISBN = codiceISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public int getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(int annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumPagine() {
        return numPagine;
    }

    public void setNumPagine(int numPagine) {
        this.numPagine = numPagine;
    }

    @Override
    public String toString() {
        return "DatiCartacei{" +
                "codiceISBN=" + codiceISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numPagine=" + numPagine +
                '}';
    }
}
