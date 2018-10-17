/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.Reclamo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author MiguelAngel
 */
@Local
public interface ReclamoFacadeLocal {

    void create(Reclamo reclamo);

    void edit(Reclamo reclamo);

    void remove(Reclamo reclamo);

    Reclamo find(Object id);

    List<Reclamo> findAll();

    List<Reclamo> findRange(int[] range);

    int count();
    
}
