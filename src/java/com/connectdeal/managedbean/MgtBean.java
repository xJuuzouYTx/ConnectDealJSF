/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connectdeal.managedbean;

import com.connectdeal.controller.util.JsfUtil;
import com.connectdeal.entity.AuditoriaPerez;
import com.connectdeal.entity.Usurs;
import java.sql.Date;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.inject.Named;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.facelets.FaceletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import Business.UsursServices;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Administrator
 */
@Named(value = "mgtBean")
@Stateless
public class MgtBean {

    String message = "";
    private String code;
    private Usurs current;

    private int selectedItemIndex;
    private static HttpSession httpSession;
    @EJB
    private UsursServices ejbFacade;

    public void login() {
        try {
            String email = current.getEmail();
            String password = current.getPassword();
            System.out.println(email);
            System.err.println(password);

            if (this.ejbFacade.isVerified(email, password) == 1) {
                FacesContext context = FacesContext.getCurrentInstance();
                HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
                HttpSession httpSession = request.getSession(false);
                httpSession.setAttribute("userId", this.ejbFacade.getUserId(email));
                FacesMessage facesMessage = new FacesMessage("Logeado Correctamente");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);

                FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDealv2/Usuario.xhtml");
                //google
              
            } else {
                FacesMessage facesMessage = new FacesMessage("Error al inciiar");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
                FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDealv2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean logGoogle(String Gemail, String Goname) throws IOException{
        if(this.ejbFacade.isRegistered(Gemail)){
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpSession httpSession = request.getSession(false);
            httpSession.setAttribute("userId",(this.ejbFacade.find(this.ejbFacade.getUserId(Gemail))));
            
            System.out.println("correcto");
            return true;
                   
        }else{
            Usurs user = new Usurs();
            user.setEmail(Gemail);
            user.setName(Goname);
            ejbFacade.create(user);
            System.out.println("falso");
        }
        return true;
    }
    
    public void googleA() throws IOException{
         FacesContext context = FacesContext.getCurrentInstance();
         String Goname = context.getExternalContext().getRequestParameterMap().get("Goname");
         String Gemail = context.getExternalContext().getRequestParameterMap().get("Gemail");
         System.out.print(Goname+"  "+Gemail);
         current.setName(Goname);
         current.setEmail(Gemail);
        
         if(logGoogle(Gemail, Goname)){
             FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDealv2/Usuario.xhtml");
         }else{
             FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDealv2/");
         }

    } 
    
    


    public void modificar() {

        if (!ejbFacade.modificar(current.getEmail(), current.getName(), current.getLastname(), current.getCedula())) {
            System.out.print("NO Registra");
        } else {
            System.out.print("Registra");
        }
    }

    public Usurs getSelected() {
        if (current == null) {
            current = new Usurs();
            selectedItemIndex = -1;
        }
        return current;
    }

}
