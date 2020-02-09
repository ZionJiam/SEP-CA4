package service;

import DbAccess.FurnitureproductEntityDb;
import DbAccess.RetailproductEntityDb;
import Entity.Furniture;
import Entity.Furnitureentity;
import Entity.RetailProduct;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.Response;

@Stateless
@Path("entity.furnitureentity")
public class FurnitureentityFacadeREST extends AbstractFacade<Furnitureentity> {

    @PersistenceContext(unitName = "WebService")
    private EntityManager em;

    public FurnitureentityFacadeREST() {
        super(Furnitureentity.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Furnitureentity entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Long id, Furnitureentity entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Furnitureentity find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Furnitureentity> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Furnitureentity> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    //Display a list of all the furniture
    //this function is not used in the student's copy, can be found in the ECommerce_AllFurnituresServlet of Lecturer's copy
    @GET
    @Path("getFurnitureList")
    @Produces("application/json")
    public Response getFurnitureList(@QueryParam("countryID") Long countryID) {
        System.out.println("RESTful: getFurnitureList() called with countryID " + countryID);
        try {
            FurnitureproductEntityDb db = new FurnitureproductEntityDb();
            List<Furniture> list = db.getFurnitureList(countryID);

            GenericEntity<List<Furniture>> entity = new GenericEntity<List<Furniture>>(list) {
            };
            return Response
                    .status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity(entity)
                    .build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    //#viewfurniturebycategorytask4a - retrieve a list of furniture by category
    //this function is used in the FurnitureCategoryServlet
    @GET
    @Path("getFurnitureListByCategory")
    @Produces("application/json")
    public Response getFurnitureListByCategory(@QueryParam("countryID") Long countryID, @QueryParam("category") String category) {
        System.out.println("RESTful: getFurnitureListByCategory() called with countryID " + countryID + " and category " + category);

        try {       
            FurnitureproductEntityDb db = new FurnitureproductEntityDb();
            List<Furniture> list = db.getFurnitureListByCategory(countryID, category);

            GenericEntity<List<Furniture>> entity = new GenericEntity<List<Furniture>>(list) {
            };
            return Response
                    .status(200)
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
                    .header("Access-Control-Allow-Credentials", "true")
                    .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
                    .header("Access-Control-Max-Age", "1209600")
                    .entity(entity)
                    .build();
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
