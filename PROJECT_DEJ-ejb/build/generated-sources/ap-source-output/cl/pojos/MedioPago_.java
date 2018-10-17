package cl.pojos;

import cl.pojos.Compra;
import cl.pojos.Venta;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-11-24T06:49:15")
@StaticMetamodel(MedioPago.class)
public class MedioPago_ { 

    public static volatile SingularAttribute<MedioPago, String> descripcion;
    public static volatile ListAttribute<MedioPago, Venta> ventaList;
    public static volatile SingularAttribute<MedioPago, Integer> idPago;
    public static volatile ListAttribute<MedioPago, Compra> compraList;

}