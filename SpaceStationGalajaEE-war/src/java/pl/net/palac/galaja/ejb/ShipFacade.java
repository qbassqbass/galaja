/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.net.palac.galaja.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.net.palac.galaja.entity.Ship;

/**
 *
 * @author Jakub
 */
@Stateless
public class ShipFacade extends AbstractFacade<Ship> {
    @PersistenceContext(unitName = "SpaceStationGalajaEE-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShipFacade() {
        super(Ship.class);
    }
    
}
