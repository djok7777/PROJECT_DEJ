package cl.pojos;

import cl.pojos.Cliente;
import cl.pojos.MedioPago;
import cl.pojos.Producto;
import cl.pojos.TipoEnvio;
import cl.pojos.VentaPK;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-24T06:49:15")
@StaticMetamodel(Venta.class)
public class Venta_ { 

    public static volatile SingularAttribute<Venta, Date> fecha;
    public static volatile SingularAttribute<Venta, Cliente> cliente;
    public static volatile SingularAttribute<Venta, Integer> nroFactura;
    public static volatile SingularAttribute<Venta, MedioPago> idPago;
    public static volatile SingularAttribute<Venta, VentaPK> ventaPK;
    public static volatile SingularAttribute<Venta, Producto> producto;
    public static volatile SingularAttribute<Venta, TipoEnvio> idEnvio;

}