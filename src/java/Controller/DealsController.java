/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Business.DealsImplementation;
import DTO.Deals;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JuuzouYT
 */
//@ManagedBean(name = "dealsController")
//@SessionScoped
@Named
@javax.enterprise.context.SessionScoped
public class DealsController implements Serializable {

    private int selectedItemIndex;

    private String messageName = "";
    private String messageDes = "";
    private String messageError = "";
    private boolean nameExsist = false;
    private Deals current;
    private String script;
    private boolean isThereDeals;

    //@ManagedProperty("#{dealsImplementation}")
    @Inject
    private DealsImplementation dealsImp;
    
    
    public void step() {
        if (this.current.getName().replace(" ", "").length() < 4) {
            this.messageName = "El nombre del negocio debe tener al menos 4 caracteres.";
            isInvalid();
        } else if (nameExsist == false) {
            System.out.println("Continuar");
        } else {
            System.out.println("Nombre existente");
        }

    }

    public boolean isIsThereDeals() {
        return isThereDeals;
    }

    public List<Deals> getMyDealsList(){
        List<Deals> deals =  dealsImp.getMyDealsList();
        if (deals.size()>0){
            isThereDeals = true;
        }else{
            isThereDeals = false;
        }
        return deals;
    }
    
    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public String isInvalid() {
        return messageName;
    }

    public Deals getSelected() {
        if (current == null) {
            current = new Deals();
            selectedItemIndex = -1;
        }
        return current;
    }

    public String getMessageName() {

        if (current.getName() != null) {
            if (dealsImp.findByName(current.getName())) {
                this.messageName = "Este nombre ya se encuentra registrado :(";
                nameExsist = true;
            } else if (this.current.getName().replace(" ", "").length() == 0) {
                this.messageName = "El nombre es obligatorio";
            } else if (this.current.getName().replace(" ", "").length() < 4) {
                this.messageName = "El nombre del negocio debe tener al menos 4 caracteres.";
            } else {
                this.messageName = "";
                nameExsist = false;
            }
        } else {
            this.messageName = "El nombre es obligatorio";
        }

        return messageName;
    }

    public String getMessageDes() {
        if (current.getDescription() != null) {
            if (this.current.getDescription().replace(" ", "").length() < 4) {
                this.messageDes = "Por favor describe tu negocio.";
            } else {
                this.messageDes = "";
                nameExsist = false;
            }
        } else {
            this.messageName = "La descripción es obligatoria";
        }

        return messageDes;
    }

    public void comprobeAddress() {
        FacesContext value = FacesContext.getCurrentInstance();
        String latString = value.getExternalContext().getRequestParameterMap().get("lat");
        String lngString = value.getExternalContext().getRequestParameterMap().get("lng");

        System.out.println(latString);
        System.out.println(lngString);
        this.current.setLat(latString);
        this.current.setLng(lngString);

    }

    public void registerDeal() {
        FacesContext value = FacesContext.getCurrentInstance();
        String latString = value.getExternalContext().getRequestParameterMap().get("lat");
        String lngString = value.getExternalContext().getRequestParameterMap().get("lng");
        this.current.setLat(latString);
        this.current.setLng(lngString);
        System.out.println(current.getLat());
        System.out.println(current.getLng());

        if (current.getName() == null) {
            System.out.println(current.getName());
            this.messageError = "Por favor asegurese de dar un nombre";
        } else if (current.getDescription() == null) {
            this.messageError = "Por favor asegurese de dar una descripcion";
        } else if (current.getLat() == null) {
            this.messageError = "Por favor asegurese de dar una ubicacion";
        } else if (current.getLng() == null) {
            this.messageError = "Por favor asegurese de dar una ubicacion";
        } else {
            System.out.println("Entra");
            if (dealsImp.registerDeal(current)){
                System.out.println("Registrado correctamente");
            }else{
                this.messageError = "Por favor asegurese de completar todos los campos";
            }
        }
    }
    
    /*public void validarTiempoAndRegister() throws IOException, ParseException {
        if (dealsImp.validateTimeAndRegister(current)){
            FacesContext.getCurrentInstance().getExternalContext().redirect("/ConnectDeal/");
        }else{
            System.out.println("No puede editar");
            FacesMessage facesMessage = new FacesMessage("Espere 15 minutos antes de volver a crear un usuario");
        }   
    }*/

    public void delete(){
        if (dealsImp.deleteDeal()){
            System.out.println("Borrado correctamente");
        }else{
            System.out.println("No se pudo borrar");
        }
    }

    public Deals getCurrent() {
        return current;
    }

    public void setCurrent(Deals current) {
        this.current = current;
    }

    public DealsImplementation getDealsImp() {
        return dealsImp;
    }

    public void setDealsImp(DealsImplementation dealsImp) {
        this.dealsImp = dealsImp;
    }

    
}
