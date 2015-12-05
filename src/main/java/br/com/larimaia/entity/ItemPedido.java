package br.com.larimaia.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Davi on 23/09/2015.
 */
@Entity
@Table(name = "item_pedido")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "ItemPedido.findAll", query = "SELECT i FROM ItemPedido i"),
        @NamedQuery(name = "ItemPedido.findByIdItemPedido", query = "SELECT i FROM ItemPedido i WHERE i.idItemPedido = :idItemPedido"),
        @NamedQuery(name = "ItemPedido.findByQuantidade", query = "SELECT i FROM ItemPedido i WHERE i.quantidade = :quantidade"),
        @NamedQuery(name = "ItemPedido.findByValorItem", query = "SELECT i FROM ItemPedido i WHERE i.valorItem = :valorItem")})
public class ItemPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_item_pedido")
    private Integer idItemPedido;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Basic(optional = false)
    @Column(name = "valor_item")
    private double valorItem;
    @JoinColumn(name = "id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pedido id;
    @JoinColumn(name = "id_produto", referencedColumnName = "id_produto")
    @ManyToOne(optional = false)
    private Produto idProduto;

    public ItemPedido() {
    }

    public ItemPedido(Integer idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public ItemPedido(Integer idItemPedido, int quantidade, double valorItem) {
        this.idItemPedido = idItemPedido;
        this.quantidade = quantidade;
        this.valorItem = valorItem;
    }

    public Integer getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(Integer idItemPedido) {
        this.idItemPedido = idItemPedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValorItem() {
        return valorItem;
    }

    public void setValorItem(double valorItem) {
        this.valorItem = valorItem;
    }

    public Pedido getId() {
        return id;
    }

    public void setId(Pedido id) {
        this.id = id;
    }

    public Produto getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Produto idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idItemPedido != null ? idItemPedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ItemPedido)) {
            return false;
        }
        ItemPedido other = (ItemPedido) object;
        return !((this.idItemPedido == null && other.idItemPedido != null) || (this.idItemPedido != null && !this.idItemPedido.equals(other.idItemPedido)));
    }

    @Override
    public String toString() {
        return String.valueOf(this.getIdItemPedido());
    }

}
