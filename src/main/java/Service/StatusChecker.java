/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Logic.SystemCheckTimerTask;
import java.util.Timer;
import javax.inject.Inject;

/**
 *
 * @author Sander
 */
public class StatusChecker {

    SystemCheckTimerTask tt = new SystemCheckTimerTask();
    Timer timer;

    public void checkSystems() {
        timer = new Timer(true);
        timer.scheduleAtFixedRate(tt, 0, 300 * 1000);
        System.out.println("TimerTask started");
    }
}
