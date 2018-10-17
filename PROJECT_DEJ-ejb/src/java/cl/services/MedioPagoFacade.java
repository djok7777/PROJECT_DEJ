/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.services;

import cl.pojos.MedioPago;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author MiguelAngel
 */
@Stateless
public class MedioPagoFacade extends AbstractFacade<MedioPago> implements MedioPagoFacadeLocal {

    @PersistenceContext(unitName = "PROJECT_DEJ-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MedioPagoFacade() {
        super(MedioPago.class);
    }
    
}
