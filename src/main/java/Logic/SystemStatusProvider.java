/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Model.SystemStatus;

/**
 *
 * @author Sander
 */
public interface SystemStatusProvider {
     void createSystemStatus(SystemStatus ss);
     SystemStatus findPolitieStatus();
     SystemStatus findVerplaatsingsStatus();
     SystemStatus findOverheidsStatus();
     SystemStatus findRekeningrijderStatus();
}
