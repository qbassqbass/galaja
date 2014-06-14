/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.net.palac.galaja.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.net.palac.galaja.entity.Planet;

/**
 *
 * @author Jakub
 */
@Stateless
public class PlanetFacade extends AbstractFacade<Planet> {
    @PersistenceContext(unitName = "SpaceStationGalajaEE-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlanetFacade() {
        super(Planet.class);
    }
    
}
