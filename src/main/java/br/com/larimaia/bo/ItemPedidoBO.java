package br.com.larimaia.bo;

import br.com.larimaia.dao.ItemPedidoDAO;
import br.com.larimaia.entity.ItemPedido;

import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */
public class ItemPedidoBO {

    private ItemPedidoDAO itempedidoDAO = new ItemPedidoDAO();


    public ItemPedidoBO(){
    }

    public void salvar(ItemPedido itempedido){
        try {
            itempedidoDAO.salvar(itempedido);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<ItemPedido> listar(){
        return itempedidoDAO.buscarTodos();
    }

    public void remover(int  id){
        itempedidoDAO.excluir(itempedidoDAO.buscarPorId(id));
    }
    public ItemPedido editar(int id){
        return itempedidoDAO.buscarPorId(id);
    }
}


