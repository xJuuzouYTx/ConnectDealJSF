/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conecctdeal.sessionbeans;

import com.connectdeal.entity.Deals;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Business.DealsServices;

/**
 *
 * @author Administrator
 */
@Stateless
public class DealsFacade extends AbstractFacade<Deals> implements DealsServices {

    @PersistenceContext(unitName = "ConnectDealv2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DealsFacade() {
        super(Deals.class);
    }
    
}
