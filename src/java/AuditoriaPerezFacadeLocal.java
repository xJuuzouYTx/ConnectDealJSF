/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.connectdeal.entity.AuditoriaPerez;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Administrator
 */
@Local
public interface AuditoriaPerezFacadeLocal {

    void create(AuditoriaPerez auditoriaPerez);

    void edit(AuditoriaPerez auditoriaPerez);

    void remove(AuditoriaPerez auditoriaPerez);

    AuditoriaPerez find(Object id);

    List<AuditoriaPerez> findAll();

    List<AuditoriaPerez> findRange(int[] range);

    int count();
    
    public AuditoriaPerez lastTime(String usuario);
    
}
