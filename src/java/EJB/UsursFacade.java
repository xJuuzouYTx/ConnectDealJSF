/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import DTO.Deals;
import EJB.AbstractFacade;
import DTO.Usurs;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import Business.UsursService;

/**
 *
 * @author JuuzouYT
 */

@Stateless
public class UsursFacade extends AbstractFacade<Usurs>{

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsursFacade() {
        super(Usurs.class);
    }
    
    public boolean isVerified(String email, String password) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("login");
        query.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("password", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("isVerified", boolean.class, ParameterMode.INOUT);
        query.setParameter("email", email);
        query.setParameter("password", password);
        query.setParameter("isVerified", false);
        query.execute();
        return (boolean) query.getOutputParameterValue("isVerified");
    }

    public boolean isRegistered(String email) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("verifyEmail");
        query.registerStoredProcedureParameter("email", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("isRegistered", boolean.class, ParameterMode.INOUT);
        query.setParameter("email", email);
        query.setParameter("isRegistered", false);
        query.execute();
        return (boolean) query.getOutputParameterValue("isRegistered");
    }

    public String[] encryptPass(String password) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("encryptPassword");
        query.registerStoredProcedureParameter("password", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("salt", String.class, ParameterMode.INOUT);
        query.registerStoredProcedureParameter("encripted", String.class, ParameterMode.INOUT);
        query.setParameter("password", password);
        query.setParameter("salt", "O");
        query.setParameter("encripted", "O");
        query.execute();
        String salt = (String) query.getOutputParameterValue("salt");
        String encripted = (String) query.getOutputParameterValue("encripted");
        String pass[] = {salt, encripted};
        return pass;
    }

    public Usurs getUserId(String email){
        Query query = em.createNamedQuery("Usurs.findByEmail");
        query.setParameter("email", email);
        Usurs user = (Usurs) query.getSingleResult();
        return user;
    }
    

    public List<Deals> getMyDeals(Usurs user) {
        Query query = em.createQuery("SELECT u.dealsList FROM Usurs u WHERE u.id = :id");
        query.setParameter("id", user.getId());
        List<Deals> mydeals = query.getResultList();
        return (List<Deals>) mydeals;
    }
    
    public boolean changePasword(String email, String password, String newPassword){
        StoredProcedureQuery query = em.createStoredProcedureQuery("changePassword");
        query.registerStoredProcedureParameter("email_in", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("password_in", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("newPassword", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("exist", boolean.class, ParameterMode.INOUT);
        query.setParameter("email_in", email);
        query.setParameter("password_in", password);
        query.setParameter("newPassword", newPassword);
        query.setParameter("exist", false);
        query.execute();
        return (boolean) query.getOutputParameterValue("exist");
    }
}
