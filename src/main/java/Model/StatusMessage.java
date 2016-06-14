/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.google.gson.JsonObject;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Sander
 */
@Entity
@Table(name = "statusmessage")
@NamedQueries({
    @NamedQuery(name = "findAllStatusMessages", query = "SELECT s FROM StatusMessage s")
})
public class StatusMessage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String SysteemNaam;
    private String Message;
    @Temporal(TemporalType.TIMESTAMP)
    private final Calendar creationDate;
    @Transient
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

    public StatusMessage() {
        creationDate = Calendar.getInstance();
    }

    public StatusMessage(String SysteemNaam, String Message) {
        this.SysteemNaam = SysteemNaam;
        this.Message = Message;
        this.creationDate = Calendar.getInstance();
    }

    public String getDate() {
        return dateFormat.format(creationDate.getTime());
    }

    public String getSysteemNaam() {
        return SysteemNaam;
    }

    public void setSysteemNaam(String SysteemNaam) {
        this.SysteemNaam = SysteemNaam;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public JsonObject toJson()
    {
        JsonObject js = new JsonObject();
        js.addProperty("systeemnaam", this.SysteemNaam);
        js.addProperty("message", this.Message);
        return js;
    }

}
