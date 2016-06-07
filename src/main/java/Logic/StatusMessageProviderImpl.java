/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Model.StatusMessage;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sander
 */
@Stateless
public class StatusMessageProviderImpl implements StatusMessageProvider {

    @PersistenceContext
    EntityManager em;

    @Override
    public void createStatusMessage(StatusMessage sm) {
        em.persist(sm);
    }
    
    @Override
    public List<StatusMessage> findAllStatusMessages() {
        Query query = em.createNamedQuery("findAllStatusMessages");
        return (List<StatusMessage>) query.getResultList();

    }
}
