package bean;

import cl.pojos.Cliente;
import cl.services.ClienteFacadeLocal;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    @EJB
    private ClienteFacadeLocal clienteFacade;
    private static Cliente cli;
    private String nomUser, password;
    
    public LoginBean() {
    
    }
    
    public boolean validarUsuario(){
        try {
            Cliente cliente = clienteFacade.find(nomUser);
            if (cliente != null && cliente.getNomUser().equals(nomUser) && cliente.getPassw().equals(password)) {
                cli = cliente;
                addMessage("Usuario logeado...");
                return true;
            }
            else{
            addMessage("Usuario o password incorrectos...");
                return false;
            }
        } catch (Exception e) {
            addMessage("Usuario no existe...");
            return false;
        }
    }
    
    public String retornarNombreUsuario(){
        String nombreCompleto;
        if (cli != null) {
            nombreCompleto = "Usuario :" + cli.getNombres() + " " + cli.getApelPaterno() + " " + cli.getApelMaterno();
            return nombreCompleto;
        }
        else{
            return "Logearse antes de continuar";
        }
    }
    
    public boolean cerrarSesion(){
        this.cli = null;
        addMessage("Sesion terminada...");
        return true;
    }

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Cliente getCli() {
        return cli;
    }

    public static void setCli(Cliente cli) {
        LoginBean.cli = cli;
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
