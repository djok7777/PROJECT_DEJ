/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author MiguelAngel
 */
@Named(value = "staticBeans")
@RequestScoped
public class StaticBean {

    private static int codigo_productoComprar;
    
    public StaticBean() {
    }

    public static int getCodigo_productoComprar() {
        return codigo_productoComprar;
    }

    public static void setCodigo_productoComprar(int codigo_productoComprar) {
        StaticBean.codigo_productoComprar = codigo_productoComprar;
    }
    
    
}
