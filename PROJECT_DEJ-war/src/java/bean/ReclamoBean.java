/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bean;


import cl.pojos.Reclamo;
import cl.services.ReclamoFacadeLocal;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Named(value = "reclamoBean")
@RequestScoped
public class ReclamoBean {

    @EJB
    private ReclamoFacadeLocal reclamoFacade;

    
    private int id;
    private String descripcion;

    Reclamo reclamo;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

     public List<Reclamo> getReclamos() {
        return reclamoFacade.findAll();
    }
  
    public ReclamoBean() {
    }
     public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public String create(){ 
       Reclamo rec = new Reclamo();
        rec.setDescripcion(descripcion);
        reclamoFacade.create(rec);
        addMessage("Reclamo Ingresado ,Gracias por su opinion!");
        return "index";
        
    }
    
}
