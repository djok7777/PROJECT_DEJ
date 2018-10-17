/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.Reclamo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MiguelAngel
 */
@Stateless
public class ReclamoFacade extends AbstractFacade<Reclamo> implements ReclamoFacadeLocal {

    @PersistenceContext(unitName = "PROJECT_DEJ-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReclamoFacade() {
        super(Reclamo.class);
    }
    
}
