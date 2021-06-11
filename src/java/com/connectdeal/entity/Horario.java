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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByFecha", query = "SELECT h FROM Horario h WHERE h.fecha = :fecha")
    , @NamedQuery(name = "Horario.findByIdhoraario", query = "SELECT h FROM Horario h WHERE h.idhoraario = :idhoraario")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idhoraario")
    private Integer idhoraario;

    public Horario() {
    }

    public Horario(Integer idhoraario) {
        this.idhoraario = idhoraario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdhoraario() {
        return idhoraario;
    }

    public void setIdhoraario(Integer idhoraario) {
        this.idhoraario = idhoraario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idhoraario != null ? idhoraario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.idhoraario == null && other.idhoraario != null) || (this.idhoraario != null && !this.idhoraario.equals(other.idhoraario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.connectdeal.entity.Horario[ idhoraario=" + idhoraario + " ]";
    }
    
}
