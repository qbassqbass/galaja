/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.net.palac.galaja.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jakub
 */
@Entity
@Table(name = "ship")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ship.findAll", query = "SELECT s FROM Ship s"),
    @NamedQuery(name = "Ship.findById", query = "SELECT s FROM Ship s WHERE s.id = :id"),
    @NamedQuery(name = "Ship.findByName", query = "SELECT s FROM Ship s WHERE s.name = :name"),
    @NamedQuery(name = "Ship.findBySerialNumber", query = "SELECT s FROM Ship s WHERE s.serialNumber = :serialNumber"),
    @NamedQuery(name = "Ship.findByCapacity", query = "SELECT s FROM Ship s WHERE s.capacity = :capacity"),
    @NamedQuery(name = "Ship.findByType", query = "SELECT s FROM Ship s WHERE s.type = :type")})
public class Ship implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 25)
    @Column(name = "name")
    private String name;
    @Size(max = 10)
    @Column(name = "serialNumber")
    private String serialNumber;
    @Column(name = "capacity")
    private Integer capacity;
    @Column(name = "type")
    private Integer type;

    public Ship() {
    }

    public Ship(Integer id) {
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
        if (!(object instanceof Ship)) {
            return false;
        }
        Ship other = (Ship) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.net.palac.galaja.entity.Ship[ id=" + id + " ]";
    }
    
}
