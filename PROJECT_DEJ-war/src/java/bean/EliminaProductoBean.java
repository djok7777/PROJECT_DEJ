package bean;

import cl.pojos.Producto;
import cl.services.ProductoFacadeLocal;
import java.util.ArrayList;
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
@Named(value = "eliminaProductoBean")
@RequestScoped
public class EliminaProductoBean {

    @EJB
    private ProductoFacadeLocal productoFacade;
    
    private int productoSeleccionado;
    private Producto producto;

    /**
     * Creates a new instance of EliminaProductoBean
     */
    
    public EliminaProductoBean() {
    }
 
    public String eliminar(){
        try {
            productoFacade.remove(productoFacade.find(productoSeleccionado));
            addMessage("Producto eliminado!");
        } catch (Exception e) {
            addMessage("ERROR " + e.getMessage());
        }
        return "";
    }
    
    public List<Producto> productosVendiendose(){
        List<Producto> lista = new ArrayList<>();
        for(Producto p : productoFacade.findAll()){
            if (p.getNomUser().getNomUser().equals(LoginBean.getCli().getNomUser())) {
                lista.add(p);
            }
        }
        return lista;
    }

    public int getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(int productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
