/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DTO.Auditoriahugogonzalez;
import DTO.Deals;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JuuzouYT
 */
@Local
public interface DealsService {

    void create(Deals deals);

    void edit(Deals deals);

    void remove(Deals deals);

    Deals find(Object id);

    List<Deals> findAll();

    List<Deals> findRange(int[] range);

    int count();

//    public List<Deals> getMyDeals(Usurs user);    
    
    public boolean findByName(String name);
    
    /*public Auditoriahugogonzalez lastTime(String usuario);*/
    
    public void deteleById (int id);
}
