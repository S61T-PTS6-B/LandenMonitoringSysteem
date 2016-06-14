/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.StatusMessage;
import Model.SystemStatus;
import Service.StatusMessageService;
import Service.SystemStatusService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sander
 */
@SessionScoped
@Named(value = "statusbean")
public class StatusBean implements Serializable {

    @Inject
    StatusMessageService sms;
    @Inject
    SystemStatusService sss;

    private List<StatusMessage> statusmessages;
    private SystemStatus verplaatsingsStatus;
    private SystemStatus politieStatus;
    private SystemStatus rekeningrijderStatus;
    private SystemStatus rekeningOverheidStatus;

    public String getVerplaatsingsStatus() {
//        verplaatsingsStatus = sss.getVerplaatsingsstatus();
        return sss.getVerplaatsingsstatus().getStatus();
    }

    public void setVerplaatsingsStatus(String verplaatsingsStatus) {
        this.verplaatsingsStatus.setStatus(verplaatsingsStatus);
    }

    public String getPolitieStatus() {
//        politieStatus = sss.getPolitiestatus();
        return sss.getPolitiestatus().getStatus();
    }

    public void setPolitieStatus(String politieStatus) {
        this.politieStatus.setStatus(politieStatus);
    }

    public String getRekeningrijderStatus() {
//        rekeningrijderStatus = sss.getRekeningrijderstatus();
        return sss.getRekeningrijderstatus().getStatus();
    }

    public void setRekeningrijderStatus(String rekeningrijderStatus) {
        this.rekeningrijderStatus.setStatus(rekeningrijderStatus);
    }

    public String getRekeningOverheidStatus() {
//        rekeningOverheidStatus = sss.getOverheidsstatus();
        return sss.getOverheidsstatus().getStatus();

    }

    public void setRekeningOverheidStatus(String rekeningOverheidStatus) {
        this.rekeningOverheidStatus.setStatus(rekeningOverheidStatus);
    }

    public List<StatusMessage> getStatusmessages() { 
        sss.StartChecks();
        this.statusmessages = new ArrayList<>();
        statusmessages = sms.FindAllStatusMessages();
        return this.statusmessages;
       
    }

    public void setStatusmessages(List<StatusMessage> statusmessages) {
        this.statusmessages = statusmessages;
    }
}
