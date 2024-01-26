package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entities.Riviste;
import org.example.entities.Utente;

public class UtenteDAO {


    private EntityManagerFactory emf;
    private EntityManager em;

    public UtenteDAO() {

        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();

    }


    public void save(Utente u){

        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(u);

        et.commit();

        em.refresh(u);

    }

    public Utente getById(int id){

        return em.find(Utente.class, id);

    }

    public void delete(int id){

        EntityTransaction et = em.getTransaction();

        et.begin();

        Utente u = getById(id);

        em.remove(u);

        et.commit();


    }

}
