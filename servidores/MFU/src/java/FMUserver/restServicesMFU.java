/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FMUserver;


import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;


/**
 * REST Web Service
 *
 * @author Daniel
 */
@Path("/restServicesMFU")
public class restServicesMFU {
     private static final Banco bancoTabaco = new  Banco("Banco Tabaco",Boolean.TRUE) ;
    private static final Banco bancoPapel = new  Banco("Banco Papel",Boolean.TRUE);
    private static final Banco bancoFosforo = new  Banco("Banco Fosforo",Boolean.TRUE);

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of restServicesMFU
     */
    public restServicesMFU() {
    }

    /**
     * Retrieves representation of an instance of FMUserver.restServicesMFU
     * @return an instance of java.lang.String
     */
   
    
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of restServicesMFU
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
    
    @GET
   @Path("recogerTabaco/{i}")
   @Produces(MediaType.APPLICATION_XML)
   public String recogerTabaco(@PathParam("i") int i){
        try {
            return bancoTabaco.RecogerIngredientes(i) ;
        } catch (InterruptedException ex) {
            Logger.getLogger(restServicesMFU.class.getName()).log(Level.SEVERE, null, ex);
            return "<Banco><Error>Error</Error><Resultado>"+Boolean.FALSE+"</Resultado><Exception>"+ex+"</Exception></Banco>";
        }
   }
   
     @GET
   @Path("recogerPapel/{i}")
   @Produces(MediaType.APPLICATION_XML)
   public String recogerPapel(@PathParam("i") int i){
        try {
            return bancoPapel.RecogerIngredientes(i) ;
        } catch (InterruptedException ex) {
            Logger.getLogger(restServicesMFU.class.getName()).log(Level.SEVERE, null, ex);
            return "<Banco><Error>Error</Error><Resultado>"+Boolean.FALSE+"</Resultado><Exception>"+ex+"</Exception></Banco>";
        }
   }
   
     @GET
   @Path("recogerFosforo/{i}")
   @Produces(MediaType.APPLICATION_XML)
   public String recogerFosforo(@PathParam("i") int i){
        try {
            return bancoFosforo.RecogerIngredientes(i) ;
        } catch (InterruptedException ex) {
            Logger.getLogger(restServicesMFU.class.getName()).log(Level.SEVERE, null, ex);
            return "<Banco><Error>Error</Error><Resultado>"+Boolean.FALSE+"</Resultado><Exception>"+ex+"</Exception></Banco>";
        }
   }
   
   @GET
   @Path("agregarIngrediente/{i}")
   @Produces(MediaType.APPLICATION_JSON)
   public String agregarIngrediente(@PathParam("i") int i){
        try {
           
               if(i==0) {
                   return bancoTabaco.nuevosIngredientes();
           }
              if(i==1){
                   return bancoPapel.nuevosIngredientes();
              }
               if (i==2){
                   return bancoFosforo.nuevosIngredientes();
                        
               }
        } catch (InterruptedException ex) {
            Logger.getLogger(restServicesMFU.class.getName()).log(Level.SEVERE, null, ex);
            return "<Banco><Error>Error</Error><Resultado>"+Boolean.FALSE+"</Resultado><Exception>"+ex+"</Exception></Banco>";
        }
        return "<Banco><Error>Error</Error><Resultado>"+Boolean.FALSE+"</Resultado><Exception>null</Exception></Banco>";
   }
        

}
