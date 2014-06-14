/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.net.palac.galaja.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jakub
 */
@Entity
@Table(name = "station")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Station.findAll", query = "SELECT s FROM Station s"),
    @NamedQuery(name = "Station.findById", query = "SELECT s FROM Station s WHERE s.id = :id"),
    @NamedQuery(name = "Station.findByName", query = "SELECT s FROM Station s WHERE s.name = :name"),
    @NamedQuery(name = "Station.findByCargoSize", query = "SELECT s FROM Station s WHERE s.cargoSize = :cargoSize")})
public class Station implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 15)
    @Column(name = "name")
    private String name;
    @Column(name = "cargoSize")
    private Integer cargoSize;
    @JoinColumn(name = "onPlanet", referencedColumnName = "id")
    @ManyToOne
    private Planet onPlanet;
    @OneToMany(mappedBy = "fromStation")
    private Collection<Transport> transportCollection;
    @OneToMany(mappedBy = "toStation")
    private Collection<Transport> transportCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "onStation")
    private Collection<Dock> dockCollection;

    public Station() {
    }

    public Station(Integer id) {
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

    public Integer getCargoSize() {
        return cargoSize;
    }

    public void setCargoSize(Integer cargoSize) {
        this.cargoSize = cargoSize;
    }

    public Planet getOnPlanet() {
        return onPlanet;
    }

    public void setOnPlanet(Planet onPlanet) {
        this.onPlanet = onPlanet;
    }

    @XmlTransient
    public Collection<Transport> getTransportCollection() {
        return transportCollection;
    }

    public void setTransportCollection(Collection<Transport> transportCollection) {
        this.transportCollection = transportCollection;
    }

    @XmlTransient
    public Collection<Transport> getTransportCollection1() {
        return transportCollection1;
    }

    public void setTransportCollection1(Collection<Transport> transportCollection1) {
        this.transportCollection1 = transportCollection1;
    }

    @XmlTransient
    public Collection<Dock> getDockCollection() {
        return dockCollection;
    }

    public void setDockCollection(Collection<Dock> dockCollection) {
        this.dockCollection = dockCollection;
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
        if (!(object instanceof Station)) {
            return false;
        }
        Station other = (Station) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.net.palac.galaja.entity.Station[ id=" + id + " ]";
    }
    
}
