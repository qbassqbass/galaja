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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "dock")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dock.findAll", query = "SELECT d FROM Dock d"),
    @NamedQuery(name = "Dock.findById", query = "SELECT d FROM Dock d WHERE d.id = :id"),
    @NamedQuery(name = "Dock.findByName", query = "SELECT d FROM Dock d WHERE d.name = :name"),
    @NamedQuery(name = "Dock.findByType", query = "SELECT d FROM Dock d WHERE d.type = :type"),
    @NamedQuery(name = "Dock.findByEfficiency", query = "SELECT d FROM Dock d WHERE d.efficiency = :efficiency")})
public class Dock implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 20)
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private Integer type;
    @Column(name = "efficiency")
    private Integer efficiency;
    @JoinColumn(name = "onStation", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Station onStation;

    public Dock() {
    }

    public Dock(Integer id) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(Integer efficiency) {
        this.efficiency = efficiency;
    }

    public Station getOnStation() {
        return onStation;
    }

    public void setOnStation(Station onStation) {
        this.onStation = onStation;
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
        if (!(object instanceof Dock)) {
            return false;
        }
        Dock other = (Dock) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "pl.net.palac.galaja.entity.Dock[ id=" + id + " ]";
    }
    
}
