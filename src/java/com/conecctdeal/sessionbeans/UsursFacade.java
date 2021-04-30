/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conecctdeal.sessionbeans;

import com.connectdeal.entity.Usurs;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;

/**
 *
 * @author Administrator
 *
 */
@Stateless
public class UsursFacade extends AbstractFacade<Usurs> implements UsursFacadeLocal {

    @PersistenceContext(unitName = "ConnectDealv2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsursFacade() {
        super(Usurs.class);
    }

    public long isVerified(String email, String password) {
        StoredProcedureQuery query = em.createNamedStoredProcedureQuery("login");
        query.setParameter("email", email);
        query.setParameter("password", password);
        query.setParameter("isVerified", false);
        query.execute();
        System.out.println(email);
        System.out.println(password);
        return (long) query.getOutputParameterValue("isVerified");
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

    public boolean modificar(String correo,String name, String lastname, String cedula) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("actualizar");
        
        query.registerStoredProcedureParameter("correos", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("names", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("lastnames", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("cedulas", String.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("existe", boolean.class , ParameterMode.INOUT);
        
        query.setParameter("correos", correo);
        query.setParameter("names", name);
        query.setParameter("lastnames", lastname);
        query.setParameter("cedulas", cedula);
        query.setParameter("existe", false);
        query.execute();
        return (boolean) query.getOutputParameterValue("existe");
    }

    @Override
    public int getUserId(String email) {
        Query query = em.createNamedQuery("Usurs.findByEmail");
        query.setParameter("email", email);
        Usurs us = (Usurs) query.getSingleResult();
        return us.getId();
    }

}
