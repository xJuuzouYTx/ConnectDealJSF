/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serv;

import com.connectdeal.entity.Horario;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author Administrator
 */
@Named(value = "usurmodmax")
@Dependent
public class usurmodmax {

    private Horario hrr;

    /**
     * Creates a new instance of usurmodmax
     */
    public usurmodmax() {
        java.util.Date fecha = new Date();
        System.out.println (fecha);
        
    }

}
