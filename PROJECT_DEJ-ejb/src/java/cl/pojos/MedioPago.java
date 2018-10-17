/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MiguelAngel
 */
@Entity
@Table(name = "medio_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioPago.findAll", query = "SELECT m FROM MedioPago m"),
    @NamedQuery(name = "MedioPago.findByIdPago", query = "SELECT m FROM MedioPago m WHERE m.idPago = :idPago"),
    @NamedQuery(name = "MedioPago.findByDescripcion", query = "SELECT m FROM MedioPago m WHERE m.descripcion = :descripcion")})
public class MedioPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pago")
    private Integer idPago;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idPago")
    private List<Compra> compraList;
    @OneToMany(mappedBy = "idPago")
    private List<Venta> ventaList;

    public MedioPago() {
    }

    public MedioPago(Integer idPago) {
        this.idPago = idPago;
    }

    public Integer getIdPago() {
        return idPago;
    }

    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Compra> getCompraList() {
        return compraList;
    }

    public void setCompraList(List<Compra> compraList) {
        this.compraList = compraList;
    }

    @XmlTransient
    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPago != null ? idPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioPago)) {
            return false;
        }
        MedioPago other = (MedioPago) object;
        if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.MedioPago[ idPago=" + idPago + " ]";
    }
    
}
