/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author MiguelAngel
 */
@Embeddable
public class CompraPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "nro_factura")
    private int nroFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom_user")
    private String nomUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto")
    private int codigoProducto;

    public CompraPK() {
    }

    public CompraPK(int nroFactura, String nomUser, int codigoProducto) {
        this.nroFactura = nroFactura;
        this.nomUser = nomUser;
        this.codigoProducto = codigoProducto;
    }

    public int getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(int nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) nroFactura;
        hash += (nomUser != null ? nomUser.hashCode() : 0);
        hash += (int) codigoProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompraPK)) {
            return false;
        }
        CompraPK other = (CompraPK) object;
        if (this.nroFactura != other.nroFactura) {
            return false;
        }
        if ((this.nomUser == null && other.nomUser != null) || (this.nomUser != null && !this.nomUser.equals(other.nomUser))) {
            return false;
        }
        if (this.codigoProducto != other.codigoProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.CompraPK[ nroFactura=" + nroFactura + ", nomUser=" + nomUser + ", codigoProducto=" + codigoProducto + " ]";
    }
    
}
