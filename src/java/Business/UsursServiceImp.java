/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DTO.Deals;
import DTO.Usurs;
import EJB.UsursFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author JuuzouYT
 */
@Stateless
public class UsursServiceImp implements UsursService{
    
    @EJB
    private UsursFacade usursFacade;

    @Override
    public void create(Usurs usurs) {
        usursFacade.create(usurs);
    }

    @Override
    public void edit(Usurs usurs) {
        usursFacade.edit(usurs);
    }

    @Override
    public void remove(Usurs usurs) {
        usursFacade.remove(usurs);
    }

    @Override
    public Usurs find(Object id) {
        return usursFacade.find(id);
    }

    @Override
    public List<Usurs> findAll() {
        return usursFacade.findAll();
    }

    @Override
    public List<Usurs> findRange(int[] range) {
        return usursFacade.findRange(range);
    }

    @Override
    public int count() {
        return usursFacade.count();
    }

    @Override
    public boolean isVerified(String email, String password) {
        return usursFacade.isVerified(email, password);
    }

    @Override
    public boolean isRegistered(String email) {
        return usursFacade.isRegistered(email);
    }

    @Override
    public String[] encryptPass(String password) {
        return usursFacade.encryptPass(password);
    }

    @Override
    public Usurs getUserId(String email) {
        return usursFacade.getUserId(email);
    }

    @Override
    public List<Deals> getMyDeals(Usurs user) {
        return usursFacade.getMyDeals(user);
    }

    @Override
    public boolean changePasword(String email, String password, String newPassword) {
        return usursFacade.changePasword(email, password, newPassword);
    }
}
