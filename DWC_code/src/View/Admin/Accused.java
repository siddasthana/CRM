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
 * This class Contains the Equals(), Hashcode() and equals() for the Database.Tables.Accused class
 * @author Shikhar Singhal
 */
@Entity
@Table(name = "accused", catalog = "delhiwomancell", schema = "")
@NamedQueries({
    @NamedQuery(name = "Accused.findAll",
                    query = "SELECT a FROM Accused a"),
    @NamedQuery(name = "Accused.findByIdAccused",
                    query = "SELECT a FROM Accused a WHERE a.idAccused = :idAccused"),
    @NamedQuery(name = "Accused.findByCaseid",
                    query = "SELECT a FROM Accused a WHERE a.caseid = :caseid"),
    @NamedQuery(name = "Accused.findByName",
                    query = "SELECT a FROM Accused a WHERE a.name = :name"),
    @NamedQuery(name = "Accused.findByPhone",
                    query = "SELECT a FROM Accused a WHERE a.phone = :phone"),
    @NamedQuery(name = "Accused.findByAddress",
                    query = "SELECT a FROM Accused a WHERE a.address = :address"),
    @NamedQuery(name = "Accused.findByFir",
                    query = "SELECT a FROM Accused a WHERE a.fir = :fir")})
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

    /**
     * Constructor
     */
    public Accused() {
    }

    /**
     * Paraeterized constructor
     * @param idAccused An Integer Accused ID value
     */
    public Accused(Integer idAccused) {
        this.idAccused = idAccused;
    }

    /**
     * @return An Integer idAccused value
     */
    public Integer getIdAccused() {
        return idAccused;
    }

    /**
     * Sets the idAccused value
     * @param idAccused An Integer value
     */
    public void setIdAccused(Integer idAccused) {
        Integer oldIdAccused = this.idAccused;
        
        this.idAccused = idAccused;
        changeSupport.firePropertyChange("idAccused", oldIdAccused, idAccused);
    }

    /**
     * @return An Integer caseid value
     */
    public Integer getCaseid() {
        return caseid;
    }

    /**
     * Sets the caseid value
     * @param caseid An Integer value
     */
    public void setCaseid(Integer caseid) {
        Integer oldCaseid = this.caseid;
        
        this.caseid = caseid;
        changeSupport.firePropertyChange("caseid", oldCaseid, caseid);
    }

    /**
     * @return A String nae value
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name value
     * @param name A String value
     * 
     */
    public void setName(String name) {
        String oldName = this.name;
        
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    /**
     * @return An Integer phone value
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * Sets the phone number
     * @param phone An Integer value
     */
    public void setPhone(Integer phone) {
        Integer oldPhone = this.phone;
        
        this.phone = phone;
        changeSupport.firePropertyChange("phone", oldPhone, phone);
    }

    /**
     * @return A String address value
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the address value
     * @param address A String value
     */
    public void setAddress(String address) {
        String oldAddress = this.address;
        
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    /**
     * @return A String Fir value
     */
    public String getFir() {
        return fir;
    }

    /**
     * Sets the fir value
     * @param fir A String value
     */
    public void setFir(String fir) {
        String oldFir = this.fir;
        
        this.fir = fir;
        changeSupport.firePropertyChange("fir", oldFir, fir);
    }

    /**
     * Gives the HashCode of the Accused object
     * @return An int value
     */
    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (idAccused != null ? idAccused.hashCode() : 0);
        return hash;
    }

    /**
     * Checks if 2 Accused objects are equal
     * @param object Object of type Accused
     * @return <pre>
     *          true    if the 2 objects are equal
     *          False   if the 2 objects are not equal
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accused)) {
            return false;
        }
        Accused other = (Accused) object;
        
        if (((this.idAccused == null) && (other.idAccused != null)) 
                || ((this.idAccused != null) && !(this.idAccused.equals(other.idAccused)))) {
            return false;
        }
        return true;
    }

    /**
     * Converts the object to the String format
     * @return A String value
     */
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
