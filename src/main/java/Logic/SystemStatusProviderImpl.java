/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Model.SystemStatus;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sander
 */
@Stateless
public class SystemStatusProviderImpl implements SystemStatusProvider {

    @PersistenceContext
    EntityManager em;

    @Override
    public void createSystemStatus(SystemStatus ss) {
        em.merge(ss);
    }

    @Override
    public SystemStatus findPolitieStatus() {
     return (SystemStatus) em.createNamedQuery("findstatusmessagebyname").setParameter("systeemnaam", "PolitieSysteem")
                .getSingleResult();
    }

    @Override
    public SystemStatus findVerplaatsingsStatus() {
         return (SystemStatus) em.createNamedQuery("findstatusmessagebyname").setParameter("systeemnaam", "VerplaatsingsSysteem")
                .getSingleResult();
    }

    @Override
    public SystemStatus findOverheidsStatus() {
         return (SystemStatus) em.createNamedQuery("findstatusmessagebyname").setParameter("systeemnaam", "RekeningoverheidSysteem")
                .getSingleResult();
    }

    @Override
    public SystemStatus findRekeningrijderStatus() {
         return (SystemStatus) em.createNamedQuery("findstatusmessagebyname").setParameter("systeemnaam", "RekeningrijderSysteem")
                .getSingleResult();
    }

}
