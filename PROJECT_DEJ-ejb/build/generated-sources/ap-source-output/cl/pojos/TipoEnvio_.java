package cl.pojos;

import cl.pojos.Compra;
import cl.pojos.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-24T06:49:15")
@StaticMetamodel(TipoEnvio.class)
public class TipoEnvio_ { 

    public static volatile SingularAttribute<TipoEnvio, String> descripcion;
    public static volatile SingularAttribute<TipoEnvio, Integer> costo;
    public static volatile ListAttribute<TipoEnvio, Venta> ventaList;
    public static volatile SingularAttribute<TipoEnvio, String> direccion;
    public static volatile SingularAttribute<TipoEnvio, Integer> idEnvio;
    public static volatile ListAttribute<TipoEnvio, Compra> compraList;

}