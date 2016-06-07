/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Model.StatusMessage;
import Service.StatusMessageService;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sander
 */
@SessionScoped
@Named(value = "messagebean")
public class MessageBean implements Serializable {

    private StatusMessage message;
    private String messagesText;
    private String systeemnaam;

    public String getMessagesText() {
        return messagesText;
    }

    public void setMessagesText(String messagesText) {
        this.messagesText = messagesText;
    }

    public String getSysteemnaam() {
        return systeemnaam;
    }

    public void setSysteemnaam(String systeemnaam) {
        this.systeemnaam = systeemnaam;
    }
    
    @Inject
    StatusMessageService sms;

    public void CreateMessage() {
        this.message = new StatusMessage(this.systeemnaam, this.messagesText);
        sms.CreateStatusMessage(message);
    }

}
