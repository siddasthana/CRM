/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
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
import javax.persistence.Transient;

/**
 * The Outbound class stores objects required to make outbound connections such as phone calls
 * It Contains the Equals(), Hashcode() and equals()
 * @author admin
 */
@Entity
@Table( name = "Outbound",
        catalog = "womencell",
        schema = "")
@NamedQueries({
    @NamedQuery(name = "Outbound.findAll",
                    query = "SELECT o FROM Outbound o"),
    @NamedQuery(name = "Outbound.findById",
                    query = "SELECT o FROM Outbound o WHERE o.id = :id"),
    @NamedQuery(name = "Outbound.findByOutType",
                    query = "SELECT o FROM Outbound o WHERE o.outType = :outType"),
    @NamedQuery(name = "Outbound.findByOutName",
                    query = "SELECT o FROM Outbound o WHERE o.outName = :outName"),
    @NamedQuery(name = "Outbound.findByNumber",
                    query = "SELECT o FROM Outbound o WHERE o.number = :number"),
    @NamedQuery(name = "Outbound.findByNumberType",
                    query = "SELECT o FROM Outbound o WHERE o.numberType = :numberType"),
    @NamedQuery(name = "Outbound.findByStatus",
                    query = "SELECT o FROM Outbound o WHERE o.status = :status"),
    @NamedQuery(name = "Outbound.findBySchedule",
                    query = "SELECT o FROM Outbound o WHERE o.schedule = :schedule")
})


public class Outbound implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "OutType")
    private String outType;
    @Column(name = "OutName")
    private String outName;
    @Column(name = "Number")
    private String number;
    @Column(name = "NumberType")
    private String numberType;
    @Column(name = "Status")
    private String status;
    @Column(name = "Schedule")
    @Temporal(TemporalType.TIMESTAMP)
    private Date schedule;

    /**
     * Default Constructor
     */
    public Outbound() {
    }

    /**
     * Paraeterized constructor
     * Sets the Outbound id value
     * @param id A Long value
     */
    public Outbound(Long id) {
        this.id = id;
    }

    /**
     * @return A Long Outbound id value
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the Outbound id value
     * @param id A Long value 
     */
    public void setId(Long id) {
        Long oldId = this.id;
        
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    /**
     * @return A String Outbound outType value
     */
    public String getOutType() {
        return outType;
    }

    /**
     * Sets the Outbound outType value
     * @param outType 
     */
    public void setOutType(String outType) {
        String oldOutType = this.outType;
        
        this.outType = outType;
        changeSupport.firePropertyChange("outType", oldOutType, outType);
    }

    /**
     * @return A String Outbound outName value
     */
    public String getOutName() {
        return outName;
    }

    /**
     * Sets the Outbound outName value
     * @param outName A String value
     */
    public void setOutName(String outName) {
        String oldOutName = this.outName;
        
        this.outName = outName;
        changeSupport.firePropertyChange("outName", oldOutName, outName);
    }

    /**
     * @return A Strig Outbounnd number value
     */
    public String getNumber() {
        return number;
    }

    /**
     * Sets the Outbound number value
     * @param number A String value
     */
    public void setNumber(String number) {
        String oldNumber = this.number;
        
        this.number = number;
        changeSupport.firePropertyChange("number", oldNumber, number);
    }

    /**
     * @return A String Outbound numberType value
     */
    public String getNumberType() {
        return numberType;
    }

    /**
     * Sets the Outbound numberType value
     * @param numberType A Strinng value
     */
    public void setNumberType(String numberType) {
        String oldNumberType = this.numberType;
        
        this.numberType = numberType;
        changeSupport.firePropertyChange("numberType", oldNumberType, numberType);
    }

    /**
     * @return A String Outbound status value
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the Outbound status value
     * @param status A String value
     */
    public void setStatus(String status) {
        String oldStatus = this.status;
        
        this.status = status;
        changeSupport.firePropertyChange("status", oldStatus, status);
    }

    /**
     * @return A Date Outbound schedule value
     */
    public Date getSchedule() {
        return schedule;
    }

    /**
     * Sets the Outbound schedule value
     * @param schedule A Date value
     */
    public void setSchedule(Date schedule) {
        Date oldSchedule = this.schedule;
        
        this.schedule = schedule;
        changeSupport.firePropertyChange("schedule", oldSchedule, schedule);
    }
    /**
     * Gives the HashCode of the Outbound object
     * @return An int value
     */
    @Override
    public int hashCode() {
        int hash = 0;
        
        hash += (id != null 
                ? id.hashCode()
                : 0);
        return hash;
    }

    /**
     * Checks if 2 Outbound objects are equal
     * @param object Object of type Outbound
     * @return <pre>
     *          true    if the 2 objects are equal
     *          False   if the 2 objects are not equal
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Outbound)) {
            return false;
        }
        
        Outbound other = (Outbound) object;
                
        if (((this.id == null) && (other.id != null)) 
                || ((this.id != null) && !(this.id.equals(other.id)))) {
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
        return "View.Outbound[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
