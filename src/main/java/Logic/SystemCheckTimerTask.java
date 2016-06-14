/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import Service.SystemStatusService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Sander
 */
public class SystemCheckTimerTask extends TimerTask {

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    private Calendar creationDate;
    
    @Inject
    SystemStatusService sss;

    @Override
    public void run() {
        creationDate = Calendar.getInstance();
        System.out.println("{-----Start check------}" + dateFormat.format(creationDate.getTime()));
        CheckSystems();
        System.out.println("{-----End check------}" + dateFormat.format(creationDate.getTime()));
    }

    private void CheckSystems() {
        //Check politiesysteem
        System.out.println("politie");
        //Check verplaatsing systeem
        System.out.println("verplaatsing");
        try {
            //Check rekeningrijdersysteem
            this.CheckRekeningRijder();
        } catch (ProtocolException ex) {
            Logger.getLogger(SystemCheckTimerTask.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SystemCheckTimerTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("rekeningrijder");
        //Check overheidssysteem
        System.out.println("overheid");
    }

    public void CheckRekeningRijder() throws MalformedURLException, ProtocolException, IOException {
        URL url = new URL("http://145.93.44.247:8080/RekeningrijdersApplicatie/rest/status/general");

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));
        String output;
        System.out.println("Output from Server .... \n");
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();
    }
    
    public void CheckOverheid() throws MalformedURLException, ProtocolException, IOException {
        
    }
    
    public void CheckPolitie() throws  MalformedURLException, ProtocolException, IOException {
        
    }
    
    public void CheckVerplaatsing() throws MalformedURLException, ProtocolException, IOException {
        
    }
}
