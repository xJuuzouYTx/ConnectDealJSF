/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import DTO.Products;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Business.ProductsService;

/**
 *
 * @author JuuzouYT
 */
@Stateless
public class ProductsFacade extends AbstractFacade<Products> implements ProductsService {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductsFacade() {
        super(Products.class);
    }
    public List<Products> findProductsByDealId(int id){
        Query query = em.createNamedQuery("Products.findByDealId");
        query.setParameter("dealId", id);
        return query.getResultList();
    }
    public List<Products> findProductsByName(String name){
        Query query = em.createQuery("SELECT p FROM Products p WHERE p.name LIKE '%"+name+"%'");
        return  query.getResultList();
    }
}
