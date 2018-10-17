package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cl.pojos.Categoria;
import cl.services.CategoriaFacadeLocal;
import static com.sun.javafx.logging.PulseLogger.addMessage;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author MiguelAngel
 */
@Named(value = "categoriaBean")
@RequestScoped
public class CategoriaBean {

    @EJB
    private CategoriaFacadeLocal categoriaFacade;

    private int id_categoria;
    private String descripcion;

    public CategoriaBean() {
    }
    
    public List<Categoria> listaCategorias(){
        return categoriaFacade.findAll();
    }
    
    public String crear(){
        Categoria cat = new Categoria();
        cat.setIdCategoria(id_categoria);
        cat.setDescripcion(descripcion);
        addMessage("Categoria ingresada!");
        categoriaFacade.create(cat);  
        return "";
    }
    
    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
