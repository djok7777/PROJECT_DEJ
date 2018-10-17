package bean;

import cl.pojos.Cliente;
import cl.pojos.Compra;
import cl.pojos.CompraPK;
import cl.pojos.MedioPago;
import cl.pojos.Producto;
import cl.pojos.TipoEnvio;
import cl.pojos.Venta;
import cl.pojos.VentaPK;
import cl.services.ClienteFacadeLocal;
import cl.services.CompraFacadeLocal;
import cl.services.MedioPagoFacadeLocal;
import cl.services.ProductoFacadeLocal;
import cl.services.TipoEnvioFacadeLocal;
import cl.services.VentaFacadeLocal;
import java.time.LocalDate;
import java.util.Date;
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
@Named(value = "comprarProductoBean")
@RequestScoped
public class ComprarProductoBean {

    @EJB
    private VentaFacadeLocal ventaFacade;

    @EJB
    private CompraFacadeLocal compraFacade;

    @EJB
    private MedioPagoFacadeLocal medioPagoFacade;

    @EJB
    private TipoEnvioFacadeLocal tipoEnvioFacade;

    @EJB
    private ClienteFacadeLocal clienteFacade;

    @EJB
    private ProductoFacadeLocal productoFacade;
    
    
    
    private String nombreVendedor;
    private int id_categoria, id_pago, id_envio;
    private Producto producto;
    private Cliente cliente;
    private int code_producto;
    
    public ComprarProductoBean() {
        
    }
    
    public List<TipoEnvio> listaEnvios(){
        return tipoEnvioFacade.findAll();
    }
    
    public List<MedioPago> listaMedioPago(){
        return medioPagoFacade.findAll();
    }
    
    public String cargarDatos(int codigo_producto){
        producto = productoFacade.find(codigo_producto);
        cliente = clienteFacade.find(productoFacade.find(codigo_producto).getNomUser().getNomUser());
        setNombreVendedor(cliente.getNombres() + " " + cliente.getApelPaterno() + " " + cliente.getApelMaterno());
        return "";
    }
    
    public String realizarCompra(){
        cargarDatos(StaticBean.getCodigo_productoComprar());
        try {
            if (producto.getStock() > 0) {
                
                Date date = java.sql.Date.valueOf(LocalDate.now());
                Compra com = new Compra();
                CompraPK pk = new CompraPK();
                pk.setNroFactura(compraFacade.count() + 1);
                //pk.setCodigoProducto(StaticBean.getCodigo_productoComprar());
                pk.setCodigoProducto(producto.getCodigoProducto());
                pk.setNomUser(LoginBean.getCli().getNomUser());
                com.setCompraPK(pk);
                com.setFecha(date);
                com.setIdPago(medioPagoFacade.find(id_pago));
                com.setIdEnvio(tipoEnvioFacade.find(id_envio));
                com.setProducto(producto);
                compraFacade.create(com);
                producto.setStock(producto.getStock() - 1);
                addMessage("Compra realizada con éxito");
                
                registrandoVenta();
            }
            else{
                addMessage("Sin stock del producto");
            }
            
        } catch (Exception e) {
            addMessage("ERROR " + e.getMessage());
        }

        return "ComprarProducto";
    }
    
    public void registrandoVenta(){
        Venta ven = new Venta();
        VentaPK vpk = new VentaPK();
        Date date = java.sql.Date.valueOf(LocalDate.now());
        
        vpk.setNomUser(cliente.getNomUser());
        vpk.setCodigoProducto(producto.getCodigoProducto());
        ven.setVentaPK(vpk);
        ven.setCliente(cliente);
        ven.setProducto(producto);
        ven.setIdEnvio(tipoEnvioFacade.find(id_envio));
        ven.setIdPago(medioPagoFacade.find(id_pago));
        ven.setFecha(date);
        ven.setNroFactura(ventaFacade.count() + 1);
        
        ventaFacade.create(ven);
    }
    
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_pago() {
        return id_pago;
    }

    public void setId_pago(int id_pago) {
        this.id_pago = id_pago;
    }

    public int getId_envio() {
        return id_envio;
    }

    public void setId_envio(int id_envio) {
        this.id_envio = id_envio;
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public int getCode_producto() {
        return code_producto;
    }

    public void setCode_producto(int code_producto) {
        this.code_producto = code_producto;
    }

}
