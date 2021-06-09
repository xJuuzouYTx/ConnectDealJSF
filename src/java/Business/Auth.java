/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DTO.Usurs;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JuuzouYT
 */

//@ManagedBean(name = "authImplementation")
//@SessionScoped
@Named
@SessionScoped
public class Auth  implements Serializable{

    @EJB
    private UsursService ejbFacade;
    
    /*@ManagedProperty("#{authController}")
    private AuthController auth;*/
    private List<Usurs> listUsurs;

    public boolean verificateLogin(String email, String password) {
        //String email = auth.getSelected().getEmail();
        //String password = auth.getSelected().getPassword();
        
        try {
            if (this.ejbFacade.isVerified(email, password)) {
                FacesContext context = FacesContext.getCurrentInstance();
                HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
                HttpSession httpSession = request.getSession(false);
                httpSession.setAttribute("userId", (this.ejbFacade.find(this.ejbFacade.getUserId(email).getId())));
                FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDeal/products.xhtml");
            } else {
                FacesMessage facesMessage = new FacesMessage("Error al inciiar");
                FacesContext.getCurrentInstance().addMessage(null, facesMessage);
            }
        } catch (Exception e) {
            System.out.println("ERROR**************");
            e.printStackTrace();
            FacesMessage facesMessage = new FacesMessage("Error al inciiar");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
        return true;
    }

    public boolean register(String email, String password, String name, String lastname) {
        try {
            if (this.ejbFacade.isRegistered(email)) {
                 return true;
            } else {
                EmailService sm = new EmailService();
                String code = sm.getRandom();
                
                UserSession user = new UserSession(name, lastname,
                        email, password,code);

                boolean enviado = sm.sendEmail(user);
                if (enviado) {
                    FacesContext context = FacesContext.getCurrentInstance();
                    HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("authcode", user);
                    return false;
                } else {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
    
    public boolean loginGoogle(String email,String name, String photo) throws IOException{
        if (this.ejbFacade.isRegistered(email)) {
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
            HttpSession httpSession = request.getSession(false);
            httpSession.setAttribute("userId", (this.ejbFacade.find(this.ejbFacade.getUserId(email).getId())));
            System.out.println("Verdadero");
            return true;
        }else{
            Usurs user = new Usurs();
            user.setEmail(email);
            user.setName(name);
            ejbFacade.create(user);
        }
        System.out.println("Falso");
        return false;
    }
    
    public int verificateCode(Usurs current, String code) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession httpSession = request.getSession();
        UserSession user = (UserSession) httpSession.getAttribute("authcode");
        
        if (user != null) {
            if (user.getCode().equals(code)) {
                try {
                    String[] encripted = this.ejbFacade.encryptPass(user.getPassword());
                    current.setSalt(encripted[0]);
                    current.setPassword(encripted[1]);
                    if (!this.ejbFacade.isRegistered(current.getEmail())) {
                        this.ejbFacade.create(current);
                        return 1;
                    }
                } catch (Exception e) {
                    e.getMessage();
                    e.printStackTrace();
                }
            } else {
                return 2;
            }
        } else {
            return 3;
        }
        return 4;
    }
    
    public boolean changePassword (String email, String password, String newPassword){
        if(ejbFacade.changePasword(email, password, newPassword)){
            return true;
        }else{
           return false;
        }
    }

    
    public List<Usurs> getListUsurs() {
        this.listUsurs = this.ejbFacade.findAll();
        return listUsurs;
    }

    public void setListUsurs(List<Usurs> listUsurs) {
        this.listUsurs = listUsurs;
    }
/*
    public AuthController getAuth() {
        return auth;
    }

    public void setAuth(AuthController auth) {
        this.auth = auth;
    }
  */  
}
