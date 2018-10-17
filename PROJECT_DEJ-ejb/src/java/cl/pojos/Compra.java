/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MiguelAngel
 */
@Entity
@Table(name = "compra")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c"),
    @NamedQuery(name = "Compra.findByNroFactura", query = "SELECT c FROM Compra c WHERE c.compraPK.nroFactura = :nroFactura"),
    @NamedQuery(name = "Compra.findByNomUser", query = "SELECT c FROM Compra c WHERE c.compraPK.nomUser = :nomUser"),
    @NamedQuery(name = "Compra.findByCodigoProducto", query = "SELECT c FROM Compra c WHERE c.compraPK.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "Compra.findByFecha", query = "SELECT c FROM Compra c WHERE c.fecha = :fecha")})
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CompraPK compraPK;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "nom_user", referencedColumnName = "nom_user", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Cliente cliente;
    @JoinColumn(name = "codigo_producto", referencedColumnName = "codigo_producto", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Producto producto;
    @JoinColumn(name = "id_envio", referencedColumnName = "id_envio")
    @ManyToOne
    private TipoEnvio idEnvio;
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago")
    @ManyToOne
    private MedioPago idPago;

    public Compra() {
    }

    public Compra(CompraPK compraPK) {
        this.compraPK = compraPK;
    }

    public Compra(int nroFactura, String nomUser, int codigoProducto) {
        this.compraPK = new CompraPK(nroFactura, nomUser, codigoProducto);
    }

    public CompraPK getCompraPK() {
        return compraPK;
    }

    public void setCompraPK(CompraPK compraPK) {
        this.compraPK = compraPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public TipoEnvio getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(TipoEnvio idEnvio) {
        this.idEnvio = idEnvio;
    }

    public MedioPago getIdPago() {
        return idPago;
    }

    public void setIdPago(MedioPago idPago) {
        this.idPago = idPago;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraPK != null ? compraPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.compraPK == null && other.compraPK != null) || (this.compraPK != null && !this.compraPK.equals(other.compraPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Compra[ compraPK=" + compraPK + " ]";
    }
    
}
