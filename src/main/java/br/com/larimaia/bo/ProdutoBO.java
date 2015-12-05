package br.com.larimaia.bo;

import br.com.larimaia.dao.ProdutoDAO;
import br.com.larimaia.entity.Produto;

import javax.enterprise.context.Dependent;
import java.util.List;

@Dependent
public class ProdutoBO {

    private ProdutoDAO produtoDAO = new ProdutoDAO();

    public ProdutoBO() {
    }

    public void salvar(Produto produto){
        try {
            produtoDAO.salvar(produto);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<Produto> listar(){
        return produtoDAO.buscarTodos();
    }

    public void remover(int id){
      produtoDAO.excluir(produtoDAO.buscarPorId(id));
    }

    public Produto editar(int id){
        return produtoDAO.buscarPorId(id);
    }

}
