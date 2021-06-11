/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conecctdeal.sessionbeans;

import com.connectdeal.entity.Products;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Business.ProductsServices;

/**
 *
 * @author Administrator
 */
@Stateless
public class ProductsFacade extends AbstractFacade<Products> implements ProductsServices {

    @PersistenceContext(unitName = "ConnectDealv2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsFacade() {
        super(Products.class);
    }

    @Override
    public boolean modificar(String name, int price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
