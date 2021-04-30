/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connectdeal.managedbean;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Administrator
 */
@Named(value = "resProduct")
@Dependent
public class ResProduct {

    /**
     * Creates a new instance of ResProduct
     */
    private String resultado;

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getResultado() {
        return resultado;
    }
    
    
    MgtBean pb = new MgtBean();
}
