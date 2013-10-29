/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
@Table(name = "directory", catalog = "delhiwomancell", schema = "")
@NamedQueries({
    @NamedQuery(name = "Directory.findAll", query = "SELECT d FROM Directory d"),
    @NamedQuery(name = "Directory.findByIdDirectory", query = "SELECT d FROM Directory d WHERE d.idDirectory = :idDirectory"),
    @NamedQuery(name = "Directory.findByDistrict", query = "SELECT d FROM Directory d WHERE d.district = :district"),
    @NamedQuery(name = "Directory.findByArea", query = "SELECT d FROM Directory d WHERE d.area = :area"),
    @NamedQuery(name = "Directory.findByService", query = "SELECT d FROM Directory d WHERE d.service = :service"),
    @NamedQuery(name = "Directory.findByInfo", query = "SELECT d FROM Directory d WHERE d.info = :info")})
public class Directory implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idDirectory")
    private Integer idDirectory;
    @Column(name = "District")
    private String district;
    @Column(name = "Area")
    private String area;
    @Column(name = "Service")
    private String service;
    @Column(name = "Info")
    private String info;

    public Directory() {
    }

    public Directory(Integer idDirectory) {
        this.idDirectory = idDirectory;
    }

    public Integer getIdDirectory() {
        return idDirectory;
    }

    public void setIdDirectory(Integer idDirectory) {
        Integer oldIdDirectory = this.idDirectory;
        this.idDirectory = idDirectory;
        changeSupport.firePropertyChange("idDirectory", oldIdDirectory, idDirectory);
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        String oldDistrict = this.district;
        this.district = district;
        changeSupport.firePropertyChange("district", oldDistrict, district);
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        String oldArea = this.area;
        this.area = area;
        changeSupport.firePropertyChange("area", oldArea, area);
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        String oldService = this.service;
        this.service = service;
        changeSupport.firePropertyChange("service", oldService, service);
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        String oldInfo = this.info;
        this.info = info;
        changeSupport.firePropertyChange("info", oldInfo, info);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDirectory != null ? idDirectory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Directory)) {
            return false;
        }
        Directory other = (Directory) object;
        if ((this.idDirectory == null && other.idDirectory != null) || (this.idDirectory != null && !this.idDirectory.equals(other.idDirectory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "View.Directory[ idDirectory=" + idDirectory + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
