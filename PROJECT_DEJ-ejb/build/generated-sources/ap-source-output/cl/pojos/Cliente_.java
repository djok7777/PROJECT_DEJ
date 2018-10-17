package cl.pojos;

import cl.pojos.Carrito;
import cl.pojos.Compra;
import cl.pojos.Producto;
import cl.pojos.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-24T06:49:15")
@StaticMetamodel(Cliente.class)
public class Cliente_ { 

    public static volatile ListAttribute<Cliente, Carrito> carritoList;
    public static volatile ListAttribute<Cliente, Venta> ventaList;
    public static volatile ListAttribute<Cliente, Producto> productoList;
    public static volatile SingularAttribute<Cliente, String> nomUser;
    public static volatile SingularAttribute<Cliente, String> direccion;
    public static volatile SingularAttribute<Cliente, String> apelMaterno;
    public static volatile SingularAttribute<Cliente, String> apelPaterno;
    public static volatile SingularAttribute<Cliente, Integer> fono;
    public static volatile ListAttribute<Cliente, Compra> compraList;
    public static volatile SingularAttribute<Cliente, String> passw;
    public static volatile SingularAttribute<Cliente, String> email;
    public static volatile SingularAttribute<Cliente, String> nombres;

}