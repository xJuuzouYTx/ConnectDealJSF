/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DTO.AuditoriaHugogonzalez;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JuuzouYT
 */
@Local
public interface AuditoriaHugogonzalezService {

    void create(AuditoriaHugogonzalez auditoriaHugogonzalez);

    void edit(AuditoriaHugogonzalez auditoriaHugogonzalez);

    void remove(AuditoriaHugogonzalez auditoriaHugogonzalez);

    AuditoriaHugogonzalez find(Object id);

    List<AuditoriaHugogonzalez> findAll();

    List<AuditoriaHugogonzalez> findRange(int[] range);

    int count();
    
    public boolean UpdateAuditoria(String name,String fecha);
    
}
