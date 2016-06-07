/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Logic.StatusMessageProvider;
import Model.StatusMessage;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Sander
 */
@Stateless
@Path("statusmessages")
public class StatusMessageService {

    @Inject
    StatusMessageProvider smp;
    @Inject SystemStatusService sss;
    List<StatusMessage> statusmessagelist;

    public void CreateStatusMessage(StatusMessage sm) {
        smp.createStatusMessage(sm);
    }

    public List<StatusMessage> FindAllStatusMessages() {
        this.statusmessagelist = smp.findAllStatusMessages();
        return (List<StatusMessage>) smp.findAllStatusMessages();
    }

    @POST
    @Path("postmessage")
    @Consumes("application/json")
    public Response AddStatus(String json) throws JSONException {
        JSONObject jsnobject = new JSONObject(json);
        StatusMessage s = new StatusMessage(jsnobject.getString("systeemnaam"), jsnobject.getString("message"));
        //persist
        this.CreateStatusMessage(s);
        System.out.println("Fixed: " + s.getMessage() + " " + s.getSysteemNaam());
        sss.incomingSystemStatus(s);
        return Response.status(200).build();
    }

    @GET
    @Path("getall")
    @Produces("application/json")
    public Response test() {
        JsonArray ja = new JsonArray();
        for (StatusMessage s : statusmessagelist) {
            ja.add(s.toJson());
        }
        return Response.status(200).entity(ja.toString()).build();
    }

    public List getJSONArray(JSONObject j) throws JSONException {
        JSONArray jsonArray = j.getJSONArray("");
        List<Object> list = new ArrayList();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject explrObject = jsonArray.getJSONObject(i);
            list.add(explrObject);
        }
        return list;
    }

}
