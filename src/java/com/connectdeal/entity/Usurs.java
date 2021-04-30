/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.connectdeal.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import static javax.persistence.ParameterMode.IN;
import static javax.persistence.ParameterMode.INOUT;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "usurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usurs.findAll", query = "SELECT u FROM Usurs u")
    , @NamedQuery(name = "Usurs.findByEmail", query = "SELECT u FROM Usurs u WHERE u.email = :email")
    , @NamedQuery(name = "Usurs.findByPassword", query = "SELECT u FROM Usurs u WHERE u.password = :password")
    , @NamedQuery(name = "Usurs.findById", query = "SELECT u FROM Usurs u WHERE u.id = :id")
    , @NamedQuery(name = "Usurs.findBySalt", query = "SELECT u FROM Usurs u WHERE u.salt = :salt")
    , @NamedQuery(name = "Usurs.findByName", query = "SELECT u FROM Usurs u WHERE u.name = :name")
    , @NamedQuery(name = "Usurs.findByLastname", query = "SELECT u FROM Usurs u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "Usurs.findByEmailAndPassword", query = "SELECT u FROM Usurs u WHERE u.email = :email and u.password = :password")})
    
@NamedStoredProcedureQuery(
    name="login",
    procedureName = "login",
    parameters={
        @StoredProcedureParameter(name="email", mode=IN, type=String.class),
        @StoredProcedureParameter(name="password", mode=IN, type=String.class),
        @StoredProcedureParameter(name="isVerified", mode=INOUT, type=boolean.class)})


public class Usurs implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Size(max = 150)
    @Column(name = "password")
    private String password;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "salt")
    private String salt;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 60)
    @Column(name = "lastname")
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Deals> dealsList;
    
    
    @Size(max = 60)
    @Column(name = "cedula")
    private String cedula;
    
    
    

    public Usurs() {
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCedula() {
        return cedula;
    }
    
    

    public Usurs(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlTransient
    public List<Deals> getDealsList() {
        return dealsList;
    }

    public void setDealsList(List<Deals> dealsList) {
        this.dealsList = dealsList;
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
        if (!(object instanceof Usurs)) {
            return false;
        }
        Usurs other = (Usurs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.connectdeal.entity.Usurs[ id=" + id + " ]";
    }
    
}
