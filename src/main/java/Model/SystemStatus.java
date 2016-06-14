/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Sander
 */
@Entity
@Table(name = "systemstatus")
@NamedQueries({
    @NamedQuery(name = "findstatusmessagebyname",
            query = "SELECT e FROM SystemStatus e WHERE e.Systeemnaam = :systeemnaam")
})
public class SystemStatus implements Serializable {

    private String Systeemnaam;
    @Transient
    private String status;
    private boolean online = true;
    @Id
    private Long id;

    public SystemStatus() {
    }

    public SystemStatus(String Systeemnaam, boolean online) {
        this.Systeemnaam = Systeemnaam;
        this.online = online;
    }

    public String getSysteemnaam() {
        return Systeemnaam;
    }

    public void setSysteemnaam(String Systeemnaam) {
        this.Systeemnaam = Systeemnaam;
    }

    public String getStatus() {
        if (this.online == true) {
            return "Systeem online";
        } else {
            return "Systeem offline";
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void ChangeStatus() {     
            this.online = !this.online;
    }
}
