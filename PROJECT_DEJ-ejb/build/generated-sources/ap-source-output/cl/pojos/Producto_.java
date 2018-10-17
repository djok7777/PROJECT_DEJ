package cl.pojos;

import cl.pojos.Carrito;
import cl.pojos.Categoria;
import cl.pojos.Cliente;
import cl.pojos.Compra;
import cl.pojos.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-24T06:49:15")
@StaticMetamodel(Producto.class)
public class Producto_ { 

    public static volatile SingularAttribute<Producto, String> descripcion;
    public static volatile ListAttribute<Producto, Carrito> carritoList;
    public static volatile SingularAttribute<Producto, Integer> precio;
    public static volatile ListAttribute<Producto, Venta> ventaList;
    public static volatile SingularAttribute<Producto, Cliente> nomUser;
    public static volatile SingularAttribute<Producto, Integer> codigoProducto;
    public static volatile SingularAttribute<Producto, Integer> stock;
    public static volatile SingularAttribute<Producto, String> rutaImagen;
    public static volatile ListAttribute<Producto, Compra> compraList;
    public static volatile SingularAttribute<Producto, Categoria> idCategoria;
    public static volatile SingularAttribute<Producto, String> nomImagen;

}