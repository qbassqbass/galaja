/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pl.net.palac.galaja.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.net.palac.galaja.entity.Transport;

/**
 *
 * @author Jakub
 */
@Stateless
public class TransportFacade extends AbstractFacade<Transport> {
    @PersistenceContext(unitName = "SpaceStationGalajaEE-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TransportFacade() {
        super(Transport.class);
    }
    
}
