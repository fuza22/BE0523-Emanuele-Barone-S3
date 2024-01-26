package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entities.DatiCartacei;
import org.example.entities.Libri;

import java.util.List;

public class LibriDAO {


    private EntityManagerFactory emf;
    private EntityManager em;

    public LibriDAO() {

        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();

    }


    public void save(Libri l){

        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(l);

        et.commit();

        em.refresh(l);

    }

    public Libri getById(int id){

        return em.find(Libri.class, id);

    }

    public void delete(int id){

        EntityTransaction et = em.getTransaction();

        et.begin();

        Libri l = getById(id);

        em.remove(l);

        et.commit();


    }

    public List<Libri> findAutore(String autore){

        return em.createNamedQuery("findAutore", Libri.class)
                .setParameter("autore", autore)
                .getResultList();

    }

}
