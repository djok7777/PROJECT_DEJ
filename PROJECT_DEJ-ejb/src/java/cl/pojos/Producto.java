/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.pojos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p"),
    @NamedQuery(name = "Producto.findByCodigoProducto", query = "SELECT p FROM Producto p WHERE p.codigoProducto = :codigoProducto"),
    @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio"),
    @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Producto.findByStock", query = "SELECT p FROM Producto p WHERE p.stock = :stock"),
    @NamedQuery(name = "Producto.findByNomImagen", query = "SELECT p FROM Producto p WHERE p.nomImagen = :nomImagen"),
    @NamedQuery(name = "Producto.findByRutaImagen", query = "SELECT p FROM Producto p WHERE p.rutaImagen = :rutaImagen")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo_producto")
    private Integer codigoProducto;
    @Column(name = "precio")
    private Integer precio;
    @Size(max = 50)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "stock")
    private Integer stock;
    @Size(max = 50)
    @Column(name = "nom_imagen")
    private String nomImagen;
    @Size(max = 100)
    @Column(name = "ruta_imagen")
    private String rutaImagen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Compra> compraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "producto")
    private List<Venta> ventaList;
    @JoinColumn(name = "id_categoria", referencedColumnName = "id_categoria")
    @ManyToOne
    private Categoria idCategoria;
    @JoinColumn(name = "nom_user", referencedColumnName = "nom_user")
    @ManyToOne
    private Cliente nomUser;
    @OneToMany(mappedBy = "codigoProducto")
    private List<Carrito> carritoList;

    public Producto() {
    }

    public Producto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(Integer codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getNomImagen() {
        return nomImagen;
    }

    public void setNomImagen(String nomImagen) {
        this.nomImagen = nomImagen;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
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

    public Categoria getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Categoria idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Cliente getNomUser() {
        return nomUser;
    }

    public void setNomUser(Cliente nomUser) {
        this.nomUser = nomUser;
    }

    @XmlTransient
    public List<Carrito> getCarritoList() {
        return carritoList;
    }

    public void setCarritoList(List<Carrito> carritoList) {
        this.carritoList = carritoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoProducto != null ? codigoProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigoProducto == null && other.codigoProducto != null) || (this.codigoProducto != null && !this.codigoProducto.equals(other.codigoProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.pojos.Producto[ codigoProducto=" + codigoProducto + " ]";
    }
    
}
