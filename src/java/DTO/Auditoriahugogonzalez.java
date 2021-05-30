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
@Table(name = "auditoriahugogonzalez")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Auditoriahugogonzalez.findAll", query = "SELECT a FROM Auditoriahugogonzalez a")
    , @NamedQuery(name = "Auditoriahugogonzalez.findById", query = "SELECT a FROM Auditoriahugogonzalez a WHERE a.id = :id")
    , @NamedQuery(name = "Auditoriahugogonzalez.findByUsuario", query = "SELECT a FROM Auditoriahugogonzalez a WHERE a.usuario = :usuario")
    , @NamedQuery(name = "Auditoriahugogonzalez.findByFecha", query = "SELECT a FROM Auditoriahugogonzalez a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Auditoriahugogonzalez.findByAccion", query = "SELECT a FROM Auditoriahugogonzalez a WHERE a.accion = :accion")})
public class Auditoriahugogonzalez implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "fecha")
    @Size(max = 30)
    private String fecha;
    @Size(max = 20)
    @Column(name = "accion")
    private String accion;

    public Auditoriahugogonzalez() {
    }

    public Auditoriahugogonzalez(Integer id) {
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
        if (!(object instanceof Auditoriahugogonzalez)) {
            return false;
        }
        Auditoriahugogonzalez other = (Auditoriahugogonzalez) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Auditoriahugogonzalez[ id=" + id + " ]";
    }
    
}
