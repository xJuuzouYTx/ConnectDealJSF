/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.connectdeal.entity.Deals;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface DealsServices {

    void create(Deals deals);

    void edit(Deals deals);

    void remove(Deals deals);

    Deals find(Object id);

    List<Deals> findAll();

    List<Deals> findRange(int[] range);

    int count();
    
}
