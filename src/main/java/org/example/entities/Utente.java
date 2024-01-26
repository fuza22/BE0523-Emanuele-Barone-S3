package org.example.entities;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utente")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Utente {

    private String nome;
    private String Cognome;
    @Column(name = "data_di_nascita")
    private LocalDate dataDiNascita;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "numero_di_tessera")
    private int numeroDiTessera;

    @OneToMany(mappedBy = "utente", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Prestito> prestiti;

    public Utente(){}



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public int getNumeroDiTessera() {
        return numeroDiTessera;
    }

    public void setNumeroDiTessera(int numeroDiTessera) {
        this.numeroDiTessera = numeroDiTessera;
    }

    public List<Prestito> getPrestiti() {
        return prestiti;
    }

    public void setPrestiti(List<Prestito> prestiti) {
        this.prestiti = prestiti;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "nome='" + nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", dataDiNascita=" + dataDiNascita +
                ", numeroDiTessera=" + numeroDiTessera;
    }
}
