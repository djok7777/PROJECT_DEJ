package cl.pojos;

import cl.pojos.Cliente;
import cl.pojos.CompraPK;
import cl.pojos.MedioPago;
import cl.pojos.Producto;
import cl.pojos.TipoEnvio;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-24T06:49:15")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Date> fecha;
    public static volatile SingularAttribute<Compra, Cliente> cliente;
    public static volatile SingularAttribute<Compra, MedioPago> idPago;
    public static volatile SingularAttribute<Compra, Producto> producto;
    public static volatile SingularAttribute<Compra, TipoEnvio> idEnvio;
    public static volatile SingularAttribute<Compra, CompraPK> compraPK;

}