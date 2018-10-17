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
@Table(name = "venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByNomUser", query = "SELECT v FROM Venta v WHERE v.ventaPK.nomUser = :nomUser"),
    @NamedQuery(name = "Venta.findByCodigoProducto", query = "SELECT v FROM Venta v WHERE v.ventaPK.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "Venta.findByNroFactura", query = "SELECT v FROM Venta v WHERE v.nroFactura = :nroFactura"),
    @NamedQuery(name = "Venta.findByFecha", query = "SELECT v FROM Venta v WHERE v.fecha = :fecha")})
public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VentaPK ventaPK;
    @Column(name = "nro_factura")
    private Integer nroFactura;
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

    public Venta() {
    }

    public Venta(VentaPK ventaPK) {
        this.ventaPK = ventaPK;
    }

    public Venta(String nomUser, int codigoProducto) {
        this.ventaPK = new VentaPK(nomUser, codigoProducto);
    }

    public VentaPK getVentaPK() {
        return ventaPK;
    }

    public void setVentaPK(VentaPK ventaPK) {
        this.ventaPK = ventaPK;
    }

    public Integer getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(Integer nroFactura) {
        this.nroFactura = nroFactura;
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
        hash += (ventaPK != null ? ventaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.ventaPK == null && other.ventaPK != null) || (this.ventaPK != null && !this.ventaPK.equals(other.ventaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Venta[ ventaPK=" + ventaPK + " ]";
    }
    
}
