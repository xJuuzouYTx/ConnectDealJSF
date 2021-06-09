/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import DTO.Auditoriahugogonzalez;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author JuuzouYT
 */
@Local
public interface AuditoriaHugogonzalezService {

    void create(Auditoriahugogonzalez auditoriaHugogonzalez);

    void edit(Auditoriahugogonzalez auditoriaHugogonzalez);

    void remove(Auditoriahugogonzalez auditoriaHugogonzalez);

    Auditoriahugogonzalez find(Object id);

    List<Auditoriahugogonzalez> findAll();

    List<Auditoriahugogonzalez> findRange(int[] range);

    int count();
    
    public boolean UpdateAuditoria(String name,String fecha);
    
}
