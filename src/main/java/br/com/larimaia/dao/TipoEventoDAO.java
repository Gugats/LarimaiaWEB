package br.com.larimaia.dao;

import br.com.larimaia.entity.TipoEvento;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */

public class TipoEventoDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public TipoEventoDAO() {
        //Ler o persistence.xml
        emf = Persistence.createEntityManagerFactory("lm_bemcasadoPU");
        //Criano EntityManager
        em = emf.createEntityManager();
    }

    public void salvar(TipoEvento tp) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(tp);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public TipoEvento buscarPorId(Integer id) {

        return em.find(TipoEvento.class, id);
    }

    public List<TipoEvento> buscarTodos() {
        //JPQL
        Query consulta = em.createQuery("select c from TipoEvento c ORDER BY c.idTipoEvento");
        return consulta.getResultList();
    }

    public void excluir(TipoEvento tp) {
        //

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(tp);
            tx.commit();
        } catch (Exception e) {

            tx.rollback();
            e.printStackTrace();
        }
    }
}
