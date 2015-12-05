package br.com.larimaia.dao;

import br.com.larimaia.entity.Pedido;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */

public class PedidoDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public PedidoDAO() {
        emf = Persistence.createEntityManagerFactory("lm_bemcasadoPU");
        em = emf.createEntityManager();
    }

    public void salvar(Pedido pedido) {
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(pedido);
        em.flush();
        tx.commit();

    }

    public Pedido buscarPorId(Integer id) {

        return em.find(Pedido.class, id);
    }

    public List<Pedido> buscarTodos() {
        //JPQL
        Query consulta = em.createQuery("select c from Pedido c");
        return consulta.getResultList();
    }

    public void excluir(Pedido pedido) {
        //

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(pedido);
            tx.commit();
        } catch (Exception e) {

            tx.rollback();
            e.printStackTrace();
        }
    }
}
