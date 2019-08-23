/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import entities.Animals;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author benja
 */
@Path("animal")
public class AnimalResource {
    List<Animals> animals = new ArrayList();
    {
    animals.add(new Animals("cat",2,"miw"));
    animals.add(new Animals("dog",30,"bark"));
    animals.add(new Animals("bird",33,"crav"));
    animals.add(new Animals("anotheranimal",50,"baubau"));
    animals.add(new Animals("pig",111,"gront"));
    
    
    }
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalResource
     */
    public AnimalResource() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalResource
     * @return an instance of java.lang.String
     */
    @GET
    //@Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
         return "Hello from my first web service";
    }
     @GET
     @Path("/random")
    @Produces(MediaType.APPLICATION_JSON)
    public String getnewJson() {
        //TODO return proper representation object
        
        Random r = new Random();
        Animals randAne = animals.get(r.nextInt(animals.size()));
        
         //return new Gson().
          return new Gson().toJson(randAne);
    }

    /**
     * PUT method for updating or creating an instance of AnimalResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
