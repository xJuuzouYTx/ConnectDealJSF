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

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }
    
    public void click(Date date) {
        SimpleDateFormat DF = new SimpleDateFormat("dd/mm/yy");
        System.out.println(DF.format(date));
    }
    
}
