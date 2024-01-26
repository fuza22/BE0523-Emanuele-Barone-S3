package org.example.DAO;

import jakarta.persistence.*;
import org.example.entities.DatiCartacei;
import org.example.entities.DatiCartacei;

import java.time.LocalDate;
import java.util.List;

public class DatiCartaceiDAO {


    private EntityManagerFactory emf;
    private EntityManager em;

    public DatiCartaceiDAO() {

        emf = Persistence.createEntityManagerFactory("biblioteca");
        em = emf.createEntityManager();

    }


    public void save(DatiCartacei e){

        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(e);

        et.commit();

        em.refresh(e);

    }

    public DatiCartacei getById(int id){

        return em.find(DatiCartacei.class, id);

    }

    public void delete(int id){

        EntityTransaction et = em.getTransaction();

        et.begin();

        DatiCartacei e = getById(id);

        em.remove(e);

        et.commit();


    }

    public List<DatiCartacei> findYear(int anno){

        return em.createNamedQuery("findAnno", DatiCartacei.class)
                .setParameter("anno", anno)
                .getResultList();

    }

    public List<DatiCartacei> findTitolo(String titolo){

        return em.createNamedQuery("findTitolo", DatiCartacei.class)
                .setParameter("titolo", titolo)
                .getResultList();

    }

}
