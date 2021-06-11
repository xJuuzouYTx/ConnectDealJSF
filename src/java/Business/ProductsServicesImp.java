/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.connectdeal.entity.Products;
import javax.ejb.EJB;

/**
 *
 * @author Administrator
 */
public class ProductsServicesImp {
    @EJB
    private ProductsServices ps;
    public void create(Products products){
        ps.create(products);
    }

    public void edit(Products products){
        ps.edit(products);
    }

    public void remove(Products products){
        ps.remove(products);
    }
}
