/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import Business.ProductsServices;
import com.connectdeal.entity.Products;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Administrator
 */
@Named(value = "sprod")
@Dependent
public class Sprod {

    /**
     * Creates a new instance of Sprod
     */
    public Sprod() {
    }
    private int selectedItemIndex;
    private ProductsServices ejbFacade;
    private Products current;
     public void modificar() {

        if (!ejbFacade.modificar(current.getName(), current.getPrice())) {
            System.out.print("NO Registra");
        } else {
            System.out.print("Registra");
        }
    }
     
     public Products getSelected(){
         if(current == null){
             current = new Products();
             selectedItemIndex = -1;
         }
        return current;
    }
     
}
