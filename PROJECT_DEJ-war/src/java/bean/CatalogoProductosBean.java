package bean;

import cl.pojos.Producto;
import cl.services.ProductoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author MiguelAngel
 */
@Named(value = "catalogoProductosBean")
@RequestScoped
public class CatalogoProductosBean {

    @EJB
    private ProductoFacadeLocal productoFacade;

    private Producto producto;
    private int codigoProducto;
    private int catalogoRecibido;
    
    /**
     * Creates a new instance of CatalogoProductosBean
     */
    public CatalogoProductosBean() {
        
    }
    
    public String llamaPagCompra(int codeProducto){
        StaticBean.setCodigo_productoComprar(codeProducto);
        return "ComprarProducto";
    }
    
    public List<Producto> listaProductos(){
        return productoFacade.findAll();
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCatalogoRecibido() {
        return catalogoRecibido;
    }

    public void setCatalogoRecibido(int catalogoRecibido) {
        this.catalogoRecibido = catalogoRecibido;
    }

    public ProductoFacadeLocal getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacadeLocal productoFacade) {
        this.productoFacade = productoFacade;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }
 
    
}
