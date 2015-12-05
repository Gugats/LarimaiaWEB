package br.com.larimaia.dao;

import br.com.larimaia.entity.Produto;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */
public class ProdutoDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public ProdutoDAO() {
        //Ler o persistence.xml
        emf = Persistence.createEntityManagerFactory("lm_bemcasadoPU");
        //Criano EntityManager
        em = emf.createEntityManager();
    }

    public void salvar(Produto produto) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(produto);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
    }

    public Produto buscarPorId(Integer id) {

        return em.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        //JPQL
        Query consulta = em.createQuery("select c from Produto c ORDER BY c.idProduto");
        return consulta.getResultList();
    }

    public void excluir(Produto produto) {
        //

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(produto);
            tx.commit();
        } catch (Exception e) {

            tx.rollback();
            e.printStackTrace();
        }
    }
}
