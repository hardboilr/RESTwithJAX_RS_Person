/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import control.ControlPerson;
import entity.Person;
import facade.FacadePerson;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utility.JSONConverter;

/**
 * REST Web Service
 *
 * @author Tobias Jacobsen
 */
@Path("/person")
public class RestServicePerson {

    @Context
    private UriInfo context;
    Gson gson;
    JsonObject jsonObj;

    public RestServicePerson() {
        gson = new GsonBuilder().setPrettyPrinting().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
    }

    //{"fName":"Tobias","lname":"Jacobsen","phone":"31203083","id:0"}
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPerson(@PathParam("id") long index) /*throws QuoteNotFoundException*/ {
        FacadePerson ctrl = new ControlPerson();
        String json = JSONConverter.getJSONFromPerson(ctrl.getPerson(index));
        return Response.status(Response.Status.OK).entity(gson.toJson(json)).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPerson(String json) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("fname", Boolean.TRUE);
        String quote = jsonObject.get("quote").getAsString();
        Facade.createQuote(quote);
        jsonObj = new JsonObject();
        jsonObj.addProperty("id", Facade.getLastIndex());
        jsonObj.addProperty("quote", quote);
        return Response.status(Response.Status.OK).entity(gson.toJson(jsonObj)).build();
        return null;
    }

    @PUT
    @Path("{id}")
    @Consumes("application/json")
    public Response updateQuote(@PathParam("id") int id, String quoteString) /*throws QuoteNotFoundException*/ {
//        JsonObject jsonObject = new Gson().fromJson(quoteString, JsonObject.class);
//        String quote = jsonObject.get("quote").getAsString();
//        Facade.updateQuote(id, quote);
//        jsonObj = new JsonObject();
//        jsonObj.addProperty("id", id);
//        jsonObj.addProperty("quote", quote);
//        return Response.status(Response.Status.OK).entity(gson.toJson(jsonObj)).build();
        return null;
    }

    @DELETE
    @Path("{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response deleteQuote(@PathParam("id") int id) /*throws QuoteNotFoundException*/ {
//        String quote = Facade.getQuote(id);
//        Facade.deleteQuote(id);
//        jsonObj = new JsonObject();
////        quoteObj.addProperty("id", id);
//        jsonObj.addProperty("quote", quote);
//        return Response.status(Response.Status.OK).entity(gson.toJson(jsonObj)).build();
        return null;
    }

}
