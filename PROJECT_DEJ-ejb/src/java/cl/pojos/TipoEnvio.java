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
@Table(name = "tipo_envio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoEnvio.findAll", query = "SELECT t FROM TipoEnvio t"),
    @NamedQuery(name = "TipoEnvio.findByIdEnvio", query = "SELECT t FROM TipoEnvio t WHERE t.idEnvio = :idEnvio"),
    @NamedQuery(name = "TipoEnvio.findByDireccion", query = "SELECT t FROM TipoEnvio t WHERE t.direccion = :direccion"),
    @NamedQuery(name = "TipoEnvio.findByCosto", query = "SELECT t FROM TipoEnvio t WHERE t.costo = :costo"),
    @NamedQuery(name = "TipoEnvio.findByDescripcion", query = "SELECT t FROM TipoEnvio t WHERE t.descripcion = :descripcion")})
public class TipoEnvio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_envio")
    private Integer idEnvio;
    @Size(max = 50)
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "costo")
    private Integer costo;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @OneToMany(mappedBy = "idEnvio")
    private List<Compra> compraList;
    @OneToMany(mappedBy = "idEnvio")
    private List<Venta> ventaList;

    public TipoEnvio() {
    }

    public TipoEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public Integer getIdEnvio() {
        return idEnvio;
    }

    public void setIdEnvio(Integer idEnvio) {
        this.idEnvio = idEnvio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
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
        hash += (idEnvio != null ? idEnvio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoEnvio)) {
            return false;
        }
        TipoEnvio other = (TipoEnvio) object;
        if ((this.idEnvio == null && other.idEnvio != null) || (this.idEnvio != null && !this.idEnvio.equals(other.idEnvio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.TipoEnvio[ idEnvio=" + idEnvio + " ]";
    }
    
}
