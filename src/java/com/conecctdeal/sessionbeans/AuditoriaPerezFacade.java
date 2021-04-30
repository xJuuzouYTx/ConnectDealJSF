/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conecctdeal.sessionbeans;

import com.connectdeal.entity.AuditoriaPerez;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Administrator
 */
@Stateless
public class AuditoriaPerezFacade extends AbstractFacade<AuditoriaPerez> implements AuditoriaPerezFacadeLocal {

    @PersistenceContext(unitName = "ConnectDealv2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuditoriaPerezFacade() {
        super(AuditoriaPerez.class);
    }
    
    public AuditoriaPerez lastTime(String usuario){
        Query query = em.createQuery("select b from Auditoria_Perez WHERE b.usuario = :usuario");
        query.setParameter("usuario", usuario);
        return(AuditoriaPerez) query.getSingleResult();
    }
    
}
