package br.com.larimaia.dao;

import br.com.larimaia.entity.ItemPedido;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */
public class ItemPedidoDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public ItemPedidoDAO(){
        emf = Persistence.createEntityManagerFactory("lm_bemcasadoPU");
        em = emf.createEntityManager();
    }

    public ItemPedido salvar(ItemPedido itemPedido){
        EntityTransaction tx = em.getTransaction();
        try{
            tx.begin();
            em.merge(itemPedido);
            em.flush();
            tx.commit();
        } catch(Exception e){
            tx.rollback();
        }
        return itemPedido;
    }
    public ItemPedido buscarPorId(Integer id) {

        return em.find(ItemPedido.class, id);
    }

    public List<ItemPedido> buscarTodos() {
        //JPQL
        Query consulta = em.createQuery("select c from ItemPedido c");
        return consulta.getResultList();
    }

    public void excluir(ItemPedido pedido) {
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
