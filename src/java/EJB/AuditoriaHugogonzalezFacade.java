/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import DTO.AuditoriaHugogonzalez;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import Business.AuditoriaHugogonzalezService;

/**
 *
 * @author JuuzouYT
 */
@Stateless
public class AuditoriaHugogonzalezFacade extends AbstractFacade<AuditoriaHugogonzalez> implements AuditoriaHugogonzalezService {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AuditoriaHugogonzalezFacade() {
        super(AuditoriaHugogonzalez.class);
    }
    
    @Override
    public boolean UpdateAuditoria(String name, String fecha) {
        try {
            StoredProcedureQuery query = em.createStoredProcedureQuery("updateDate");
            query.registerStoredProcedureParameter("name", String.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("fecha", String.class, ParameterMode.IN);
            query.setParameter("name", name);
            query.setParameter("fecha", fecha);
            query.execute();
            em.flush();
            return true;
        } catch (Exception e) {return false;}
    }
}
