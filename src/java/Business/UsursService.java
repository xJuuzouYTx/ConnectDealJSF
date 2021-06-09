/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DTO.Deals;
import DTO.Usurs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JuuzouYT
 */
@Local
public interface UsursService {

    void create(Usurs usurs);

    void edit(Usurs usurs);

    void remove(Usurs usurs);

    Usurs find(Object id);

    List<Usurs> findAll();

    List<Usurs> findRange(int[] range);

    int count();
    
    boolean isVerified(String email, String password);
    
    boolean isRegistered(String email);
    
    String[] encryptPass(String password);
    
    Usurs getUserId(String email);
    
    public List<Deals> getMyDeals(Usurs user);
    
    public boolean changePasword(String email, String password, String newPassword);
}
