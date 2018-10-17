package bean;

import cl.pojos.Producto;
import cl.pojos.Venta;
import cl.services.MedioPagoFacadeLocal;
import cl.services.ProductoFacadeLocal;
import cl.services.TipoEnvioFacadeLocal;
import cl.services.VentaFacadeLocal;
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
@Named(value = "ventaUsuarioBean")
@RequestScoped
public class VentaUsuarioBean {

    @EJB
    private ProductoFacadeLocal productoFacade;

    @EJB
    private MedioPagoFacadeLocal medioPagoFacade;

    @EJB
    private TipoEnvioFacadeLocal tipoEnvioFacade;

    @EJB
    private VentaFacadeLocal ventaFacade;
    
    
    
    
    private int nom_usuario;
    private String descripcionProducto, tipoEnvio, tipoPago;

    /**
     * Creates a new instance of ventaUsuarioBean
     */
    public List<Venta> listaVentas(){
        List<Venta> lista = new ArrayList<>();
        for(Venta v : ventaFacade.findAll()){
            if (v.getCliente().getNomUser().equals(LoginBean.getCli().getNomUser())) {
                lista.add(v);
            }
        }
        return lista;
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
    
    public List<Venta> readAll(){
        return ventaFacade.findAll();
    }

    public int getNom_usuario() {
        return nom_usuario;
    }

    public void setNom_usuario(int nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public String getTipoEnvio() {
        return tipoEnvio;
    }

    public void setTipoEnvio(String tipoEnvio) {
        this.tipoEnvio = tipoEnvio;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }
   
    
}
