/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Admin;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "accused", catalog = "delhiwomancell", schema = "")
@NamedQueries({
    @NamedQuery(name = "Accused.findAll", query = "SELECT a FROM Accused a"),
    @NamedQuery(name = "Accused.findByIdAccused", query = "SELECT a FROM Accused a WHERE a.idAccused = :idAccused"),
    @NamedQuery(name = "Accused.findByCaseid", query = "SELECT a FROM Accused a WHERE a.caseid = :caseid"),
    @NamedQuery(name = "Accused.findByName", query = "SELECT a FROM Accused a WHERE a.name = :name"),
    @NamedQuery(name = "Accused.findByPhone", query = "SELECT a FROM Accused a WHERE a.phone = :phone"),
    @NamedQuery(name = "Accused.findByAddress", query = "SELECT a FROM Accused a WHERE a.address = :address"),
    @NamedQuery(name = "Accused.findByFir", query = "SELECT a FROM Accused a WHERE a.fir = :fir")})
public class Accused implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idAccused")
    private Integer idAccused;
    @Column(name = "Caseid")
    private Integer caseid;
    @Column(name = "Name")
    private String name;
    @Column(name = "Phone")
    private Integer phone;
    @Column(name = "Address")
    private String address;
    @Column(name = "Fir")
    private String fir;

    public Accused() {
    }

    public Accused(Integer idAccused) {
        this.idAccused = idAccused;
    }

    public Integer getIdAccused() {
        return idAccused;
    }

    public void setIdAccused(Integer idAccused) {
        Integer oldIdAccused = this.idAccused;
        this.idAccused = idAccused;
        changeSupport.firePropertyChange("idAccused", oldIdAccused, idAccused);
    }

    public Integer getCaseid() {
        return caseid;
    }

    public void setCaseid(Integer caseid) {
        Integer oldCaseid = this.caseid;
        this.caseid = caseid;
        changeSupport.firePropertyChange("caseid", oldCaseid, caseid);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        Integer oldPhone = this.phone;
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getFir() {
        return fir;
    }

    public void setFir(String fir) {
        String oldFir = this.fir;
        this.fir = fir;
        changeSupport.firePropertyChange("fir", oldFir, fir);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAccused != null ? idAccused.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accused)) {
            return false;
        }
        Accused other = (Accused) object;
        if ((this.idAccused == null && other.idAccused != null) || (this.idAccused != null && !this.idAccused.equals(other.idAccused))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Admin.Accused[ idAccused=" + idAccused + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
