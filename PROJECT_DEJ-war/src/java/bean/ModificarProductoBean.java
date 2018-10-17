/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import cl.pojos.Categoria;
import cl.pojos.Producto;
import cl.services.CategoriaFacadeLocal;
import cl.services.ProductoFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author MiguelAngel
 */
@Named(value = "modificarProductoBean")
@RequestScoped
public class ModificarProductoBean {

    @EJB
    private CategoriaFacadeLocal categoriaFacade;

    @EJB
    private ProductoFacadeLocal productoFacade;
    
    private int codigoProducto, precio, stock, id_categoria;
    private String nom_user, descripcion, nom_imagen, ruta_imagen;
    /**
     * Creates a new instance of ModificarProducto
     */

    public ModificarProductoBean() {
    }
    
    public String modifica(){
        try {
            Producto prod = productoFacade.find(codigoProducto);
            prod.setPrecio(precio);
            prod.setStock(stock);
            prod.setDescripcion(descripcion);
            prod.setIdCategoria(categoriaFacade.find(id_categoria));
            productoFacade.edit(prod);
            addMessage("Producto modificado!");
        } catch (Exception e) {
            addMessage("ERROR " + e.getMessage());
        }
        return "";
    }
    
    public List<Categoria> listaCategorias(){
        return categoriaFacade.findAll();
    }
    
    public List<Producto> listaProductosUsuario(){
        List<Producto> lista = new ArrayList<>();
        for(Producto p : productoFacade.findAll()){
            if (p.getNomUser().getNomUser().equals(LoginBean.getCli().getNomUser())) {
                lista.add(p);
            }
        }
        return lista;
    }
    
    public List<Producto> readAll(){
        return productoFacade.findAll();
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNom_imagen() {
        return nom_imagen;
    }

    public void setNom_imagen(String nom_imagen) {
        this.nom_imagen = nom_imagen;
    }

    public String getRuta_imagen() {
        return ruta_imagen;
    }

    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
