/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connectdeal.entity;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "auditoria_perez")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AuditoriaPerez.findAll", query = "SELECT a FROM AuditoriaPerez a")
    , @NamedQuery(name = "AuditoriaPerez.findById", query = "SELECT a FROM AuditoriaPerez a WHERE a.id = :id")
    , @NamedQuery(name = "AuditoriaPerez.findByUsuario", query = "SELECT a FROM AuditoriaPerez a WHERE a.usuario = :usuario")
    , @NamedQuery(name = "AuditoriaPerez.findByFecha", query = "SELECT a FROM AuditoriaPerez a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "AuditoriaPerez.findByAction", query = "SELECT a FROM AuditoriaPerez a WHERE a.action = :action")
    , @NamedQuery(name = "AuditoriaPerez.findByContenido", query = "SELECT a FROM AuditoriaPerez a WHERE a.contenido = :contenido")})
public class AuditoriaPerez implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "usuario")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Size(max = 100)
    @Column(name = "action")
    private String action;
    @Size(max = 100)
    @Column(name = "contenido")
    private String contenido;

    public AuditoriaPerez() {
    }

    public AuditoriaPerez(Integer id) {
        this.id = id;
    }

    public AuditoriaPerez(Integer id, Date fecha) {
        this.id = id;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
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
        if (!(object instanceof AuditoriaPerez)) {
            return false;
        }
        AuditoriaPerez other = (AuditoriaPerez) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.connectdeal.entity.AuditoriaPerez[ id=" + id + " ]";
    }
    
}
