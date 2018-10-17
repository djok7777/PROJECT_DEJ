/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author MiguelAngel
 */
@Entity
@Table(name = "reclamo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reclamo.findAll", query = "SELECT r FROM Reclamo r"),
    @NamedQuery(name = "Reclamo.findByDescripcion", query = "SELECT r FROM Reclamo r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Reclamo.findByIdReclamo", query = "SELECT r FROM Reclamo r WHERE r.idReclamo = :idReclamo")})
public class Reclamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 140)
    @Column(name = "descripcion")
    private String descripcion;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_reclamo")
    private Integer idReclamo;

    public Reclamo() {
    }

    public Reclamo(Integer idReclamo) {
        this.idReclamo = idReclamo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdReclamo() {
        return idReclamo;
    }

    public void setIdReclamo(Integer idReclamo) {
        this.idReclamo = idReclamo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReclamo != null ? idReclamo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reclamo)) {
            return false;
        }
        Reclamo other = (Reclamo) object;
        if ((this.idReclamo == null && other.idReclamo != null) || (this.idReclamo != null && !this.idReclamo.equals(other.idReclamo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Reclamo[ idReclamo=" + idReclamo + " ]";
    }
    
}
