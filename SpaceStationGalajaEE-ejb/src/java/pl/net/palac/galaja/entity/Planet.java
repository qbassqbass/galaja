/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.net.palac.galaja.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "planet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planet.findAll", query = "SELECT p FROM Planet p"),
    @NamedQuery(name = "Planet.findById", query = "SELECT p FROM Planet p WHERE p.id = :id"),
    @NamedQuery(name = "Planet.findByName", query = "SELECT p FROM Planet p WHERE p.name = :name"),
    @NamedQuery(name = "Planet.findByStationCount", query = "SELECT p FROM Planet p WHERE p.stationCount = :stationCount")})
public class Planet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 15)
    @Column(name = "name")
    private String name;
    @Column(name = "stationCount")
    private Integer stationCount;
    @OneToMany(mappedBy = "onPlanet")
    private Collection<Station> stationCollection;
    @OneToMany(mappedBy = "toPlanet")
    private Collection<Transport> transportCollection;
    @OneToMany(mappedBy = "fromPlanet")
    private Collection<Transport> transportCollection1;

    public Planet() {
    }

    public Planet(Integer id) {
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

    public Integer getStationCount() {
        return stationCount;
    }

    public void setStationCount(Integer stationCount) {
        this.stationCount = stationCount;
    }

    @XmlTransient
    public Collection<Station> getStationCollection() {
        return stationCollection;
    }

    public void setStationCollection(Collection<Station> stationCollection) {
        this.stationCollection = stationCollection;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planet)) {
            return false;
        }
        Planet other = (Planet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.net.palac.galaja.entity.Planet[ id=" + id + " ]";
    }
    
}
