/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import DTO.Auditoriahugogonzalez;
import DTO.Deals;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import Business.DealsService;

/**
 *
 * @author JuuzouYT
 */
@Stateless
public class DealsFacade extends AbstractFacade<Deals> implements DealsService {

    @PersistenceContext(unitName = "testPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DealsFacade() {
        super(Deals.class);
    }

    public boolean findByName(String name) {
        Query query = em.createNamedQuery("Deals.findByName");
        query.setParameter("name", name);
        try {
            Deals deal = (Deals) query.getSingleResult();
            if (deal != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Auditoriahugogonzalez lastTime(String usuario) {
        Query query = em.createQuery("SELECT a FROM AuditoriaHugogonzalez a WHERE a.usuario = :usuario");
        query.setParameter("usuario", usuario);
        Auditoriahugogonzalez au = new Auditoriahugogonzalez();
        try {
            au = (Auditoriahugogonzalez) query.getSingleResult();
            return au;
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public void deteleById (int id){
        Query query = em.createQuery("DELETE FROM AuditoriaHugogonzalez a WHERE a.id = :id");
        query.setParameter("id", id);
    }
}
