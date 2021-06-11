/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.connectdeal.entity.Usurs;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface UsursServices {

    void create(Usurs usurs);

    void edit(Usurs usurs);

    void remove(Usurs usurs);
    
    boolean modificar(String correo,String name,String lastname, String   Cedula);

    Usurs find(Object id);

    List<Usurs> findAll();

    List<Usurs> findRange(int[] range);

    int count();
    long isVerified(String email, String password);
    boolean isRegistered(String email);
   
    String []encryptPass(String password);
    int getUserId(String email);
}
