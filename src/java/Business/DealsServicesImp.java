/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.connectdeal.entity.Deals;
import javax.ejb.EJB;

/**
 *
 * @author Administrator
 */
public class DealsServicesImp {
    @EJB
    private DealsServices ds;
    
    public void create(Deals deals){
        ds.create(deals);
    }

    public void edit(Deals deals){
        ds.edit(deals);
    }

    public void remove(Deals deals){
        ds.remove(deals);
    }
}
