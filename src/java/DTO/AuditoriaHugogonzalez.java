/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JuuzouYT
 */
@Entity
@Table(name = "auditoria_hugogonzalez")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditoriaHugogonzalez.findAll", query = "SELECT a FROM AuditoriaHugogonzalez a")
    , @NamedQuery(name = "AuditoriaHugogonzalez.findById", query = "SELECT a FROM AuditoriaHugogonzalez a WHERE a.id = :id")
    , @NamedQuery(name = "AuditoriaHugogonzalez.findByUsuario", query = "SELECT a FROM AuditoriaHugogonzalez a WHERE a.usuario = :usuario")
    , @NamedQuery(name = "AuditoriaHugogonzalez.findByFecha", query = "SELECT a FROM AuditoriaHugogonzalez a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "AuditoriaHugogonzalez.findByAccion", query = "SELECT a FROM AuditoriaHugogonzalez a WHERE a.accion = :accion")})
public class AuditoriaHugogonzalez implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "usuario")
    private String usuario;
    @Size(max = 20)
    @Column(name = "fecha")
    private String fecha;
    @Size(max = 20)
    @Column(name = "accion")
    private String accion;

    public AuditoriaHugogonzalez() {
    }

    public AuditoriaHugogonzalez(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuditoriaHugogonzalez)) {
            return false;
        }
        AuditoriaHugogonzalez other = (AuditoriaHugogonzalez) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.AuditoriaHugogonzalez[ id=" + id + " ]";
    }
    
}
