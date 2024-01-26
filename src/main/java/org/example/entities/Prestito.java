package org.example.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestito")
@NamedQuery(name = "findPrestito", query = "select p.elementoPrestato from Prestito p where p.utente.numeroDiTessera = :numeroDiTessera and p.dataRestituzioneEffettiva is null")
@NamedQuery(name = "findOtherP", query = "select p from Prestito p where p.dataRestituzionePrevista < current_date and p.dataRestituzioneEffettiva is null")
public class Prestito {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricola_prestito")
    private int matricolaPrestito;


    @ManyToOne
    @JoinColumn(name = "utente_fk")
    private Utente utente;

    @OneToOne
    @JoinColumn(name = "elemento_prestato")
    private DatiCartacei elementoPrestato;

    @Column(name = "data_inizio_prestito")
    private LocalDate dataInizioPrestito;

    @Column(name = "data_restituzione_prevista")
    private LocalDate dataRestituzionePrevista;

    @Column(name = "data_restituzione_effettiva")
    private LocalDate dataRestituzioneEffettiva;

    public Prestito(){}


    public Prestito(int matricolaPrestito, Utente utente, DatiCartacei elementoPrestato, LocalDate dataInizioPrestito, LocalDate dataRestituzionePrevista, LocalDate dataRestituzioneEffettiva) {
        this.matricolaPrestito = matricolaPrestito;
        this.utente = utente;
        this.elementoPrestato = elementoPrestato;
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataRestituzionePrevista;
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public DatiCartacei getElementoPrestato() {
        return elementoPrestato;
    }

    public void setElementoPrestato(DatiCartacei elementoPrestato) {
        this.elementoPrestato = elementoPrestato;
    }

    public LocalDate getDataInizioPrestito() {
        return dataInizioPrestito;
    }

    public void setDataInizioPrestito(LocalDate dataInizioPrestito) {
        this.dataInizioPrestito = dataInizioPrestito;
        this.dataRestituzionePrevista = dataInizioPrestito.plusDays(30);
    }

    public void setDataRestituzionePrevista(LocalDate dataRestituzionePrevista) {
        this.dataRestituzionePrevista = dataRestituzionePrevista;
    }

    public LocalDate getDataRestituzionePrevista() {
        return dataRestituzionePrevista;
    }


    public LocalDate getDataRestituzioneEffettiva() {
        return dataRestituzioneEffettiva;
    }

    public void setDataRestituzioneEffettiva(LocalDate dataRestituzioneEffettiva) {
        this.dataRestituzioneEffettiva = dataRestituzioneEffettiva;
    }

    public int getMatricolaPrestito() {
        return matricolaPrestito;
    }

    public void setMatricolaPrestito(int matricolaPrestito) {
        this.matricolaPrestito = matricolaPrestito;
    }

    @Override
    public String toString() {
        return "Prestito{" +
                "matricolaPrestito=" + matricolaPrestito +
                ", utente=" + utente +
                ", elementoPrestato=" + elementoPrestato +
                ", dataInizioPrestito=" + dataInizioPrestito +
                ", dataRestituzionePrevista=" + dataRestituzionePrevista +
                ", dataRestituzioneEffettiva=" + dataRestituzioneEffettiva +
                '}';
    }
}
