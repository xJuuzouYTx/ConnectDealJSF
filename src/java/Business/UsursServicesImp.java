/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import com.connectdeal.entity.Usurs;
import javax.ejb.EJB;

/**
 *
 * @author Administrator
 */
public class UsursServicesImp {
    
    @EJB
    private UsursServices us;
    
    public void create(Usurs usurs){
        us.create(usurs);
    }
    public  void edit(Usurs usurs){
        us.edit(usurs);
    }
    public void remove(Usurs usurs){
       us.remove(usurs);
    }
    public boolean modificar(String correo,String name,String lastname, String   Cedula){
       return us.modificar(correo, name, lastname, Cedula);
        }
    
    public int count(){
       return us.count();
        
    }
    
    public long isVerified(String email, String password){
        return us.isVerified(email, password);
    }
    
    public boolean isRegistered(String email){
        return us.isRegistered(email);
        
    }
    public String []encryptPass(String password){
        return us.encryptPass(password);
        
    }
    public int getUserId(String email){
        return us.getUserId(email);
        
    }
    
}
