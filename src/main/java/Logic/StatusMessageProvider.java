/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Model.StatusMessage;
import java.util.List;

/**
 *
 * @author Sander
 */
public interface StatusMessageProvider {

    void createStatusMessage(StatusMessage sm);

    public List<StatusMessage> findAllStatusMessages() ;
}
