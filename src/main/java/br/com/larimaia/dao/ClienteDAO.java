package br.com.larimaia.dao;

import br.com.larimaia.entity.Cliente;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */
public class ClienteDAO {
    EntityManagerFactory emf;
    EntityManager em;

    public ClienteDAO() {
        //Ler o persistence.xml
        emf = Persistence.createEntityManagerFactory("lm_bemcasadoPU");
        //Criano EntityManager
        em = emf.createEntityManager();
    }

    public void salvar(Cliente cliente) {
        EntityTransaction tx = em.getTransaction();
        System.out.println(cliente.getIdCliente());
        tx.begin();
        em.merge(cliente);
        tx.commit();

    }

    public Cliente buscarPorId(Integer id) {

        return em.find(Cliente.class, id);
    }

    public List<Cliente> buscarTodos() {
        //JPQL
        Query consulta = em.createQuery("select c from Cliente c ORDER BY c.idCliente");
        return consulta.getResultList();
    }

    public void excluir(Cliente cliente) {
        //

        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(cliente);
            tx.commit();
        } catch (Exception e) {

            tx.rollback();
            e.printStackTrace();
        }
    }

}

