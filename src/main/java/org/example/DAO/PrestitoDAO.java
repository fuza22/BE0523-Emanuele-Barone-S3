package org.example.DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.entities.Prestito;
import org.example.entities.Riviste;

import java.util.List;

public class PrestitoDAO {


    private EntityManagerFactory emf;
    private EntityManager em;

    public PrestitoDAO() {

        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();

    }


    public void save(Prestito p){

        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(p);

        et.commit();

        em.refresh(p);

    }

    public Prestito getById(int id){

        return em.find(Prestito.class, id);

    }

    public void delete(int id){

        EntityTransaction et = em.getTransaction();

        et.begin();

        Prestito p = getById(id);

        em.remove(p);

        et.commit();


    }

    public List<Prestito> findPrestiti(int tessera){

        return em.createNamedQuery("findPrestito", Prestito.class)
                .setParameter("numeroDiTessera", tessera)
                .getResultList();

    }

    public List<Prestito> findOtherP(){

        return em.createNamedQuery("findOtherP", Prestito.class)
                .getResultList();

    }


}
