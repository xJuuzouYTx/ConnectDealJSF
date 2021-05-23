package Controller;

import Business.Auth;
import DTO.Usurs;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputSecret;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JuuzouYT
 */
//
@ManagedBean(name = "authController")
@SessionScoped
public class AuthController implements Serializable{
    
    String message = "";
    private Usurs current;
    private int selectedItemIndex;
    private static HttpSession httpSession;
    private String email;
    private String password;
    private String newPassword;
    private String code;
    
    @ManagedProperty("#{authImplementation}")
    private Auth authImp;

    public AuthController() {
    }
    
    public void login(){
        if (authImp.verificateLogin(current.getEmail(),current.getPassword())){
            System.out.println("Funciona");
        }else{
            System.out.println("No funciona");
        }
    }
    public void googleOAuth() throws IOException{
        FacesContext value = FacesContext.getCurrentInstance();
        String Gname = value.getExternalContext().getRequestParameterMap().get("Gname");
        String Gemail = value.getExternalContext().getRequestParameterMap().get("Gemail");
        String Gphoto = value.getExternalContext().getRequestParameterMap().get("Gphoto");
        System.out.println(Gname+" "+Gemail+" "+Gphoto);
        if (authImp.loginGoogle(Gemail,Gname,Gphoto)){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDeal/products.xhtml");
        }else{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDeal/");
        }
        
    }
    public void register() throws IOException{
        if (authImp.register(current.getEmail(),current.getPassword(),current.getName(), current.getLastname())){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDeal");
        }else{
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDeal/verify.xhtml");
        }
    }
    public void verifyCode() throws IOException{
        if (authImp.verificateCode(current, code)==1){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDeal/");
        }else if (authImp.verificateCode(current, code)==2){
            FacesMessage facesMessage = new FacesMessage("El codigo no coincide");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }else{
            FacesMessage facesMessage = new FacesMessage("La sesion se ha cerrado");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
    public void changePassword(){
        if (authImp.changePassword(email, password, newPassword)) {
            System.out.println("Contraseña cambiada");   
            FacesMessage facesMessage = new FacesMessage("Contraseña cambiada");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }else{
            System.out.println("No se cambio la contraseña");   
            FacesMessage facesMessage = new FacesMessage("No se cambio la contraseña");
            FacesContext.getCurrentInstance().addMessage(null, facesMessage);
        }
    }
    public void logout() throws IOException{
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDeal/");
    }
    
    public Usurs getSelected() {
        if (current == null) {
            current = new Usurs();
            
            selectedItemIndex = -1;
        }
        return current;
    }
    
    @PostConstruct
    public void init(){
        FacesContext context = FacesContext.getCurrentInstance();
        UIViewRoot uiViewRoot = context.getViewRoot();
        try{    
            HtmlInputText inputTextEmail = (HtmlInputText) uiViewRoot.findComponent("loginForm:Lemail");
            inputTextEmail.setValue(null);
            HtmlInputSecret inputText = (HtmlInputSecret) uiViewRoot.findComponent("loginForm:Lpassword");
            inputText.setValue(null);
        }catch(Exception e){
            
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Auth getAuthImp() {
        return authImp;
    }

    public void setAuthImp(Auth authImp) {
        this.authImp = authImp;
    }
    
    
}
