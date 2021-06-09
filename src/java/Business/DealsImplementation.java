/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DTO.Auditoriahugogonzalez;
import DTO.Deals;
import DTO.Usurs;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JuuzouYT
 */
//@ManagedBean(name = "dealsImplementation")
//@SessionScoped
@Named
@javax.enterprise.context.SessionScoped
public class DealsImplementation implements Serializable{

    private List<Deals> myDealsList;
    @EJB
    private DealsService ejc;
    @EJB
    private AuditoriaHugogonzalezService au;
    @EJB
    private ProductsService pfl;
    @EJB
    private UsursService ufl;

    public List<Deals> getMyDealsList() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(true);
        Usurs user = (Usurs) httpSession.getAttribute("userId");
        List<Deals> deals = ufl.getMyDeals(user);
        if (deals.size() != 0) {
            deals.size();
            this.myDealsList = deals;
            return myDealsList;
        } else {
            Deals deal = new Deals();
            deal.setId(1);
            deal.setName("Añadir");
            deal.setImage("https://images.vexels.com/media/users/3/135544/isolated/preview/23724deafa9e7ec5830d49438d3e3f9f-bot-oacute-n-colorido-m-aacute-s-a-ntilde-adir-icono-by-vexels.png");
            deals.add(deal);
            this.myDealsList = deals;
            System.out.println("Entra");
            return myDealsList;
        }
    }
    public boolean registerDeal(Deals current){
        System.out.println("Entra");
        if (current.getDescription().length() > 0
                && current.getName().length() > 0
                && current.getPhone().length() == 10
                && current.getLat().length() > 0
                && current.getLng().length() > 0) {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpSession httpSession = request.getSession(true);
            FacesContext value = FacesContext.getCurrentInstance();
            current.setImage(value.getExternalContext().getRequestParameterMap().get("photo"));
            Usurs user = (Usurs) httpSession.getAttribute("userId");
            current.setUserId(user);
            try {
                this.ejc.create(current);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }
    
    /*public boolean validateTimeAndRegister(Deals current) {
        
        CompareTime compare = new CompareTime();
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession(true);
        Usurs user = (Usurs) httpSession.getAttribute("userId");
        Auditoriahugogonzalez auditoria = new Auditoriahugogonzalez();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String actualDateFormated = formatter.format(date);
        
        if (this.ejc.lastTime(user.getName())!= null){
            
            auditoria = this.ejc.lastTime(user.getName());

            String fechaAuditoria = auditoria.getFecha();
            System.out.println(fechaAuditoria + " " + actualDateFormated);

            System.out.println(compare.Difference(actualDateFormated, fechaAuditoria));
            System.out.println(auditoria.getAccion());
            
            if (compare.Difference(actualDateFormated, fechaAuditoria) || !auditoria.getAccion().equals("Create")) {
                au.UpdateAuditoria(user.getName(), actualDateFormated);
                System.out.println("Puede editar");
                registerDeal(current);
                return true;
            } else {
                return false;
            }
        }else{
            System.out.println("No existia");
            auditoria.setUsuario(user.getName());
            auditoria.setFecha(actualDateFormated);
            auditoria.setAccion("Create");
            au.create(auditoria);
            registerDeal(current);
            return true;
        }
    }*/
    
    
    public boolean deleteDeal(){
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try{
            if (request.getParameterValues("id") != null){
                for (String id : request.getParameterValues("id")){
                    System.out.println(id);
                    try{
                        ejc.remove(ejc.find(Integer.parseInt(id)));
                    }catch(Exception e){
                        return false;
                    }finally{
                        ejc.deteleById(Integer.parseInt(id));
                        return true;
                    }
                }
            }else{
                return false;
            }
        }catch(Exception e){
            return false;
        }
        return false;
    }
    
    public boolean findByName(String name){
        return ejc.findByName(name);
    }

    private DealsService getFacade() {
        return ejc;
    }

    
}
