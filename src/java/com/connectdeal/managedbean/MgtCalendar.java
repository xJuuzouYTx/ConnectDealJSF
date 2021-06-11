/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connectdeal.managedbean;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Administrator
 */
@Named(value = "mgtCalendar")
@Dependent
public class MgtCalendar {

        /**
     * Creates a new instance of MgtCalendar
     */
    private Date date;
    private String fechaS = "";

    public String getFechaS() {
        return fechaS;
    }

    public void setFechaS(String fechaS) {
        this.fechaS = fechaS;
    }
    
    
    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
    public void ActFecha(SelectEvent event){
        SimpleDateFormat fecha = new SimpleDateFormat("EEEEE dd MMMMM yyyy");
        StringBuilder CFecha = new StringBuilder(fecha.format(event.getObject()));
        fechaS = CFecha.toString();
    } 
    
    
}
