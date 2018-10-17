package bean;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cl.pojos.Cliente;
import cl.services.ClienteFacadeLocal;
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
@Named(value = "registroUsuarioBean")
@RequestScoped
public class RegistroUsuarioBean {

    @EJB
    private ClienteFacadeLocal clienteFacade;
    private int fono;
    private String nom_user, passw, nombres, apel_paterno, apel_materno, direccion, email;

    public RegistroUsuarioBean() {

    }
    
    public List<Cliente> listaCategorias(){    
        return clienteFacade.findAll();
    }
    
    public String crear(){
        Cliente cli = new Cliente();
        cli.setNomUser(nom_user);
        cli.setNombres(nombres);
        cli.setApelPaterno(apel_paterno);
        cli.setApelMaterno(apel_materno);
        cli.setFono(fono);
        cli.setDireccion(direccion);
        cli.setEmail(email);
        cli.setPassw(passw);
        addMessage("Cliente ingresado!");
        clienteFacade.create(cli);  
        return "";
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public int getFono() {
        return fono;
    }

    public void setFono(int fono) {
        this.fono = fono;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApel_paterno() {
        return apel_paterno;
    }

    public void setApel_paterno(String apel_paterno) {
        this.apel_paterno = apel_paterno;
    }

    public String getApel_materno() {
        return apel_materno;
    }

    public void setApel_materno(String apel_materno) {
        this.apel_materno = apel_materno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }    
    
}
