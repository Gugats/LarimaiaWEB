package br.com.larimaia.bo;

import br.com.larimaia.dao.ClienteDAO;
import br.com.larimaia.entity.Cliente;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */
@Dependent
public class ClienteBO {

    private ClienteDAO cliDao = new ClienteDAO();


    public ClienteBO() {
    }

    public void salvar(Cliente cliente) {
        try {
            cliDao.salvar(cliente);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Cliente> listar() {
        return cliDao.buscarTodos();
    }

    public void remover(int id) {
        cliDao.excluir(cliDao.buscarPorId(id));
    }

    public Cliente editar(int id) {
        return cliDao.buscarPorId(id);
    }

}

