package cl.pojos;

import cl.pojos.Cliente;
import cl.pojos.Producto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-24T06:49:15")
@StaticMetamodel(Carrito.class)
public class Carrito_ { 

    public static volatile SingularAttribute<Carrito, Integer> idCarrito;
    public static volatile SingularAttribute<Carrito, Cliente> nomUser;
    public static volatile SingularAttribute<Carrito, Integer> cantidadProd;
    public static volatile SingularAttribute<Carrito, Producto> codigoProducto;
    public static volatile SingularAttribute<Carrito, Integer> montoTotal;

}