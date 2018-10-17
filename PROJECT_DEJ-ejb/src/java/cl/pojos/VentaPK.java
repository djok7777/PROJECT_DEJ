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
public class VentaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nom_user")
    private String nomUser;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_producto")
    private int codigoProducto;

    public VentaPK() {
    }

    public VentaPK(String nomUser, int codigoProducto) {
        this.nomUser = nomUser;
        this.codigoProducto = codigoProducto;
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
        hash += (nomUser != null ? nomUser.hashCode() : 0);
        hash += (int) codigoProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaPK)) {
            return false;
        }
        VentaPK other = (VentaPK) object;
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
        return "cl.pojos.VentaPK[ nomUser=" + nomUser + ", codigoProducto=" + codigoProducto + " ]";
    }
    
}
