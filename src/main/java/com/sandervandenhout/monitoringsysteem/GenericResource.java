/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sandervandenhout.monitoringsysteem;
//import JMS.ConnectorHelper;
//import Send.ClientSend;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
/**
 * REST Web Service
 *
 * @author casva
 */
@Path("generic")
@Stateless
public class GenericResource {
    @Context
    private UriInfo context;
    boolean response = false;
    public String restcontent;
    private String content;
    
     private static final String JNDI_CONNECTION_FACTORY = "jms/__defaultConnectionFactory";
    
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }
    
    /**
     * Retrieves representation of an instance of Rest.GenericResource
     * @param search
     * @return an instance of java.lang.String
     * @throws javax.jms.JMSException
     */
    
    @GET
    @Path("info")
    @Produces("application/json")
    public Response getXml() throws JMSException {
        
        return Response.ok().build();
    }
    public UriInfo getContext() {
        return context;
    }
    public void setContext(UriInfo context) {
        this.context = context;
    }
    public boolean isResponse() {
        return response;
    }
    public void setResponse(boolean response) {
        this.response = response;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    
    
    
    
    
}