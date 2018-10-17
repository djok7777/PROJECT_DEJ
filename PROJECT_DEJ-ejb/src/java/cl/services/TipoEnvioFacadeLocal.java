/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.TipoEnvio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MiguelAngel
 */
@Local
public interface TipoEnvioFacadeLocal {

    void create(TipoEnvio tipoEnvio);

    void edit(TipoEnvio tipoEnvio);

    void remove(TipoEnvio tipoEnvio);

    TipoEnvio find(Object id);

    List<TipoEnvio> findAll();

    List<TipoEnvio> findRange(int[] range);

    int count();
    
}
