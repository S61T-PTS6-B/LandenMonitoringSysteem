/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Logic.SystemStatusProvider;
import Model.StatusMessage;
import Model.SystemStatus;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Sander
 */
@Stateless
public class SystemStatusService {

    @Inject
    SystemStatusProvider ssp;

    private SystemStatus rekeningrijderstatus;
    private SystemStatus verplaatsingsstatus;
    private SystemStatus overheidsstatus;
    private SystemStatus politiestatus;

    //setters
    public void setRekeningrijderstatus(SystemStatus rekeningrijderstatus) {
        this.rekeningrijderstatus = rekeningrijderstatus;
    }

    public void setVerplaatsingsstatus(SystemStatus verplaatsingsstatus) {
        verplaatsingsstatus.setOnline(false);
        this.verplaatsingsstatus = verplaatsingsstatus;
    }

    public void setOverheidsstatus(SystemStatus overheidsstatus) {
        overheidsstatus.setOnline(false);
        this.overheidsstatus = overheidsstatus;
    }

    public void setPolitiestatus(SystemStatus politiestatus) {
        politiestatus.setOnline(true);
        this.politiestatus = politiestatus;
    }
    //Getters

    public SystemStatus getOverheidsstatus() {
        this.overheidsstatus = ssp.findOverheidsStatus();
        System.out.println("overheid: " + this.overheidsstatus.getStatus());
        return overheidsstatus;
    }

    public SystemStatus getVerplaatsingsstatus() {
        this.verplaatsingsstatus = ssp.findVerplaatsingsStatus();
        System.out.println("Verplaatsing: " + this.verplaatsingsstatus.getStatus());
        return verplaatsingsstatus;
    }

    public SystemStatus getRekeningrijderstatus() {
        this.rekeningrijderstatus = ssp.findRekeningrijderStatus();
        System.out.println("Rekeningrijder: " + this.rekeningrijderstatus.getStatus());
        return rekeningrijderstatus;
    }

    public SystemStatus getPolitiestatus() {
        this.politiestatus = ssp.findPolitieStatus();
        System.out.println("politie: " + this.politiestatus.getStatus());
        return politiestatus;
    }

    public void incomingSystemStatus(StatusMessage s) {
        if (s.getSysteemNaam().toLowerCase().contains("rekeningrijder")) {
            this.rekeningrijderstatus.ChangeStatus();
            this.ssp.createSystemStatus(rekeningrijderstatus);
            
        } else if (s.getSysteemNaam().toLowerCase().contains("overheid")) {
            this.overheidsstatus.ChangeStatus();
            this.ssp.createSystemStatus(overheidsstatus);
        }
        else if (s.getSysteemNaam().toLowerCase().contains("politie")) {
            this.politiestatus.ChangeStatus();
            this.ssp.createSystemStatus(politiestatus);
        }
        else if (s.getSysteemNaam().toLowerCase().contains("verplaatsing")) {
            this.verplaatsingsstatus.ChangeStatus();
            this.ssp.createSystemStatus(verplaatsingsstatus);
        }
    }
}
