package service;

import DbAccess.EcommerceEntityDb;
import Entity.LineItem;
import Entity.SalesRecord;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("commerce")
public class ECommerceFacadeREST {

    @Context
    private UriInfo context;

    public ECommerceFacadeREST() {
    }

    @GET
    @Produces("application/json")
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ECommerce
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(String content) {
    }

    @PUT
    @Path("createECommerceTransactionRecord")
    @Consumes({"application/xml", "application/json"})
    @Produces({"application/xml", "application/json"})
    public Response createEcommerceTransactionRecord(@QueryParam("memberId") long memberId, @QueryParam("amountPaid") double amountPaid) {
        System.out.println("createEcommerceTransactionRecord ENTER");
        try {
            EcommerceEntityDb db = new EcommerceEntityDb();
            SalesRecord salesRecord = db.createSalesRecord(memberId, amountPaid);

            if (salesRecord.getSalesRecordId() == 0) {
                System.out.println("Fail createEcommerceTransactionRecord");
            } else {
                System.out.println("Success createEcommerceTransactionRecord");
                return Response.status(201).entity(salesRecord).build();         
            } 

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Response.status(Response.Status.NOT_FOUND)
                .build();
    }

    @PUT
    @Path("createEcommerceLineItemRecord")
    @Consumes({"application/json"})
    public Response createEcommerceLineItemRecord(@QueryParam("salesRecordId") long salesRecordId, @QueryParam("itemEntityId") long itemEntityId,@QueryParam("quantity") int quantity) {
        try {
            EcommerceEntityDb db = new EcommerceEntityDb();
            LineItem lineItem = db.createLineItemRecord(itemEntityId, quantity);
            
            if(lineItem  == null){
                throw new SQLException("Create Line item fail");
            }
            
            int result = db.createSalesRecordLineItem(salesRecordId, lineItem.getLineItemId());
            
            if(result != 1){
                throw new SQLException("Create Line item sales record fail");
            }
            //Update quanity in database
            db.updateItemQuantity(quantity, itemEntityId);
            db.updateFreeVolume(quantity, lineItem.getItemEntityId());
            
            return Response.status(Response.Status.CREATED).build();
            
        } catch (Exception ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
