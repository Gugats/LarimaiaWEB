package br.com.larimaia.bo;

import br.com.larimaia.dao.TipoEventoDAO;
import br.com.larimaia.entity.Cliente;
import br.com.larimaia.entity.TipoEvento;

import javax.enterprise.context.Dependent;
import java.util.List;

/**
 * Created by Davi on 23/09/2015.
 */
@Dependent
public class TipoEventoBO {

    private TipoEventoDAO eventoDAO = new TipoEventoDAO();


    public TipoEventoBO(){
    }

    public void salvar(TipoEvento evento){
        try {
            eventoDAO.salvar(evento);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<TipoEvento> listar(){
        return eventoDAO.buscarTodos();
    }

    public void remover(int  id){
        eventoDAO.excluir(eventoDAO.buscarPorId(id));
    }
    public TipoEvento editar(int id){
        return eventoDAO.buscarPorId(id);
    }


}
