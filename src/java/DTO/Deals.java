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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JuuzouYT
 */
@Entity
@Table(name = "deals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Deals.findAll", query = "SELECT d FROM Deals d")
    , @NamedQuery(name = "Deals.findById", query = "SELECT d FROM Deals d WHERE d.id = :id")
    , @NamedQuery(name = "Deals.findByName", query = "SELECT d FROM Deals d WHERE d.name = :name")
    , @NamedQuery(name = "Deals.findByDescription", query = "SELECT d FROM Deals d WHERE d.description = :description")
    , @NamedQuery(name = "Deals.findByLat", query = "SELECT d FROM Deals d WHERE d.lat = :lat")
    , @NamedQuery(name = "Deals.findByLng", query = "SELECT d FROM Deals d WHERE d.lng = :lng")
    , @NamedQuery(name = "Deals.findByQualification", query = "SELECT d FROM Deals d WHERE d.qualification = :qualification")
    , @NamedQuery(name = "Deals.findByNQualifications", query = "SELECT d FROM Deals d WHERE d.nQualifications = :nQualifications")
    , @NamedQuery(name = "Deals.findByPhone", query = "SELECT d FROM Deals d WHERE d.phone = :phone")
    , @NamedQuery(name = "Deals.findByFacebook", query = "SELECT d FROM Deals d WHERE d.facebook = :facebook")
    , @NamedQuery(name = "Deals.findByInstagram", query = "SELECT d FROM Deals d WHERE d.instagram = :instagram")
    , @NamedQuery(name = "Deals.findByTwitter", query = "SELECT d FROM Deals d WHERE d.twitter = :twitter")
    , @NamedQuery(name = "Deals.findByWebSite", query = "SELECT d FROM Deals d WHERE d.webSite = :webSite")
    , @NamedQuery(name = "Deals.findByWhatsapp", query = "SELECT d FROM Deals d WHERE d.whatsapp = :whatsapp")})
public class Deals implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "name")
    private String name;
    @Size(max = 255)
    @Column(name = "description")
    private String description;
    @Size(max = 30)
    @Column(name = "lat")
    private String lat;
    @Size(max = 30)
    @Column(name = "lng")
    private String lng;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qualification")
    private int qualification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "n_qualifications")
    private int nQualifications;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 20)
    @Column(name = "phone")
    private String phone;
    @Size(max = 100)
    @Column(name = "facebook")
    private String facebook;
    @Size(max = 100)
    @Column(name = "instagram")
    private String instagram;
    @Size(max = 100)
    @Column(name = "twitter")
    private String twitter;
    @Size(max = 100)
    @Column(name = "webSite")
    private String webSite;
    @Size(max = 20)
    @Column(name = "whatsapp")
    private String whatsapp;
    @Lob
    @Size(max = 65535)
    @Column(name = "image")
    private String image;
    @JoinTable(name = "deals_products", joinColumns = {
        @JoinColumn(name = "Deals_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "productsList_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Products> productsList;
    @JoinColumn(name = "userId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usurs userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dealId")
    private List<Products> productsList1;

    public Deals() {
    }

    public Deals(Integer id) {
        this.id = id;
    }

    public Deals(Integer id, int qualification, int nQualifications) {
        this.id = id;
        this.qualification = qualification;
        this.nQualifications = nQualifications;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public int getQualification() {
        return qualification;
    }

    public void setQualification(int qualification) {
        this.qualification = qualification;
    }

    public int getNQualifications() {
        return nQualifications;
    }

    public void setNQualifications(int nQualifications) {
        this.nQualifications = nQualifications;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }

    public Usurs getUserId() {
        return userId;
    }

    public void setUserId(Usurs userId) {
        this.userId = userId;
    }

    @XmlTransient
    public List<Products> getProductsList1() {
        return productsList1;
    }

    public void setProductsList1(List<Products> productsList1) {
        this.productsList1 = productsList1;
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
        if (!(object instanceof Deals)) {
            return false;
        }
        Deals other = (Deals) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DTO.Deals[ id=" + id + " ]";
    }
    
}
