/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JuuzouYT
 */
@Entity
@Table(name = "usurs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usurs.findAll", query = "SELECT u FROM Usurs u")
    , @NamedQuery(name = "Usurs.findById", query = "SELECT u FROM Usurs u WHERE u.id = :id")
    , @NamedQuery(name = "Usurs.findByName", query = "SELECT u FROM Usurs u WHERE u.name = :name")
    , @NamedQuery(name = "Usurs.findByLastname", query = "SELECT u FROM Usurs u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "Usurs.findByEmail", query = "SELECT u FROM Usurs u WHERE u.email = :email")
    , @NamedQuery(name = "Usurs.findByPhone", query = "SELECT u FROM Usurs u WHERE u.phone = :phone")
    , @NamedQuery(name = "Usurs.findByPassword", query = "SELECT u FROM Usurs u WHERE u.password = :password")
    , @NamedQuery(name = "Usurs.findBySalt", query = "SELECT u FROM Usurs u WHERE u.salt = :salt")
    , @NamedQuery(name = "Usurs.findByDocument", query = "SELECT u FROM Usurs u WHERE u.document = :document")})
public class Usurs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    //@Size(max = 100)
    @Column(name = "name")
    private String name;
    //@Size(max = 100)
    @Column(name = "lastname")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    //@Size(max = 100)
    @Column(name = "email")
    private String email;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    //@Size(max = 10)
    @Column(name = "phone")
    private String phone;
    //@Size(max = 255)
    @Column(name = "password")
    private String password;
    //@Size(max = 255)
    @Column(name = "salt")
    private String salt;
    //@Size(max = 12)
    @Column(name = "document")
    private String document;
    @Lob
    //@Size(max = 65535)
    @Column(name = "image")
    private String image;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Deals> dealsList;

    public Usurs() {
    }

    public Usurs(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        return "DTO.Usurs[ id=" + id + " ]";
    }
    
}
