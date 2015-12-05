package br.com.larimaia.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

/**
 * Created by Davi on 23/09/2015.
 */
@Entity
@Table(name = "tipo_evento")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "TipoEvento.findAll", query = "SELECT t FROM TipoEvento t"),
        @NamedQuery(name = "TipoEvento.findByIdTipoEvento", query = "SELECT t FROM TipoEvento t WHERE t.idTipoEvento = :idTipoEvento"),
        @NamedQuery(name = "TipoEvento.findByDescricao", query = "SELECT t FROM TipoEvento t WHERE t.descricao = :descricao")})
public class TipoEvento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_evento")
    private Integer idTipoEvento;
    @Basic(optional = false)
    @Column(name = "descricao")
    private String descricao;
    /*@OneToMany(mappedBy = "idTipoEvento")
    private Collection<Pedido> pedidoCollection;*/

    public TipoEvento() {
    }

    public TipoEvento(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public TipoEvento(Integer idTipoEvento, String descricao) {
        this.idTipoEvento = idTipoEvento;
        this.descricao = descricao;
    }

    public Integer getIdTipoEvento() {
        return idTipoEvento;
    }

    public void setIdTipoEvento(Integer idTipoEvento) {
        this.idTipoEvento = idTipoEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /*public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoEvento != null ? idTipoEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEvento)) {
            return false;
        }
        TipoEvento other = (TipoEvento) object;
        return !((this.idTipoEvento == null && other.idTipoEvento != null) || (this.idTipoEvento != null && !this.idTipoEvento.equals(other.idTipoEvento)));
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }

}
