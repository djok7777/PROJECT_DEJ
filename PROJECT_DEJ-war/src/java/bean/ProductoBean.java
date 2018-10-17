package bean;

import cl.pojos.Categoria;
import cl.pojos.Producto;
import cl.services.CategoriaFacadeLocal;
import cl.services.ProductoFacadeLocal;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.mail.MessagingException;
import javax.mail.Part;

/**
 *
 * @author MiguelAngel
 */
@Named(value = "productoBean")
@RequestScoped
public class ProductoBean {

    @EJB
    private CategoriaFacadeLocal categoriaFacade;

    @EJB
    private ProductoFacadeLocal productoFacade;
    
    private int codigo_producto, precio, stock, id_categoria;
    private String nom_user, descripcion, nom_imagen, ruta_imagen;
    private Part file;
    /**
     * Creates a new instance of ProductoBean
     */
    
    public ProductoBean() {
        this.nom_imagen = "imagen";
        this.ruta_imagen = "ruta";
    }
    
    public void doUpload() throws IOException, MessagingException{
        Scanner s = new Scanner(file.getInputStream());
        String fileContent = s.useDelimiter("\\A").next();
        s.close();
        
        System.out.println("fileContent");
        Files.write(Paths.get("C:\\"+file.getFileName()), fileContent.getBytes(), StandardOpenOption.CREATE);
        
    }
    
    public List<Producto> listaProductos(){
        return productoFacade.findAll();
    }
    
    public String crear(){
        Producto prod = new Producto();
        prod.setNomUser(LoginBean.getCli());
        prod.setCodigoProducto(codigo_producto);
        prod.setPrecio(precio);
        prod.setStock(stock);
        prod.setDescripcion(descripcion);
        prod.setIdCategoria(categoriaFacade.find(id_categoria));
        prod.setNomImagen(nom_imagen);
        prod.setRutaImagen(ruta_imagen);
        
        productoFacade.create(prod);
        addMessage("Producto ingresado para la venta");
        return "";
    }

    public String getNom_user() {
        return nom_user;
    }

    public void setNom_user(String nom_user) {
        this.nom_user = nom_user;
    }

    public int getCodigo_producto() {
        return codigo_producto;
    }

    public void setCodigo_producto(int codigo_producto) {
        this.codigo_producto = codigo_producto;
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

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }    
}
