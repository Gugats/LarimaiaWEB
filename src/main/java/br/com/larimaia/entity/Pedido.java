package br.com.larimaia.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Davi on 23/09/2015.
 */
@Entity
@Table(name = "pedido")
@NamedQueries({
        @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p"),
        @NamedQuery(name = "Pedido.findById", query = "SELECT p FROM Pedido p WHERE p.id = :id"),
        @NamedQuery(name = "Pedido.findByOrigemPedido", query = "SELECT p FROM Pedido p WHERE p.origemPedido = :origemPedido"),
        @NamedQuery(name = "Pedido.findByCerimonial", query = "SELECT p FROM Pedido p WHERE p.cerimonial = :cerimonial"),
        @NamedQuery(name = "Pedido.findByLocalEvento", query = "SELECT p FROM Pedido p WHERE p.localEvento = :localEvento"),
        @NamedQuery(name = "Pedido.findByIndicacao", query = "SELECT p FROM Pedido p WHERE p.indicacao = :indicacao"),
        @NamedQuery(name = "Pedido.findByEndereco", query = "SELECT p FROM Pedido p WHERE p.endereco = :endereco"),
        @NamedQuery(name = "Pedido.findByObservacao", query = "SELECT p FROM Pedido p WHERE p.observacao = :observacao"),
        @NamedQuery(name = "Pedido.findByDataPedido", query = "SELECT p FROM Pedido p WHERE p.dataPedido = :dataPedido"),
        @NamedQuery(name = "Pedido.findByDataEvento", query = "SELECT p FROM Pedido p WHERE p.dataEvento = :dataEvento"),
        @NamedQuery(name = "Pedido.findByHoraEvento", query = "SELECT p FROM Pedido p WHERE p.horaEvento = :horaEvento")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "origem_pedido")
    private String origemPedido;
    @Basic(optional = false)
    @Column(name = "cerimonial")
    private String cerimonial;
    @Basic(optional = false)
    @Column(name = "local_evento")
    private String localEvento;
    @Column(name = "indicacao")
    private String indicacao;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "observacao")
    private String observacao;
    @Column(name = "data_pedido")
    private String dataPedido;
    @Column(name = "data_evento")
    private String dataEvento;
    @Column(name = "hora_evento")
    private String horaEvento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private Collection<ItemPedido> itemPedidoCollection;
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @ManyToOne
    private Cliente idCliente;
    @JoinColumn(name = "id_tipo_evento", referencedColumnName = "id_tipo_evento")
    @ManyToOne
    private TipoEvento idTipoEvento;

    public Pedido() {
    }

    public Pedido(Integer id) {
        this.id = id;
    }

    public Pedido(Integer id, String cerimonial, String localEvento) {
        this.id = id;
        this.cerimonial = cerimonial;
        this.localEvento = localEvento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrigemPedido() {
        return origemPedido;
    }

    public void setOrigemPedido(String origemPedido) {
        this.origemPedido = origemPedido;
    }

    public String getCerimonial() {
        return cerimonial;
    }

    public void setCerimonial(String cerimonial) {
        this.cerimonial = cerimonial;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(String horaEvento) {
        this.horaEvento = horaEvento;
    }

    public Collection<ItemPedido> getItemPedidoCollection() {
        return itemPedidoCollection;
    }

    public void setItemPedidoCollection(Collection<ItemPedido> itemPedidoCollection) {
        this.itemPedidoCollection = itemPedidoCollection;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public TipoEvento getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(TipoEvento idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "Model.Pedido[ id=" + id + " ]";
    }

}
