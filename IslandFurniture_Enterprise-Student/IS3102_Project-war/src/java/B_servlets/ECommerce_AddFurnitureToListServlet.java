/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import HelperClasses.ShoppingCartLineItem;//THEY GOT A SHOPPING CART HELPER CLASS
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author Myridian Star
 */
@WebServlet(name = "ECommerce_AddFurnitureToListServlet", urlPatterns = {"/ECommerce_AddFurnitureToListServlet"})
public class ECommerce_AddFurnitureToListServlet extends HttpServlet {
    
    ArrayList<ShoppingCartLineItem> shoppingCartItems = new ArrayList<>();
    private String message;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String urlPrefix = (String) session.getAttribute("URLprefix");
        PrintWriter out = response.getWriter();
        System.out.println("ECommerce_AddFurnitureToListServlet START");
        try{
            // http:// is the URL prefix, which specifies the protocol used to access the location. techterms.com – the server name or IP address of the server. /definition/url – the path to the directory or file.
            
            if (urlPrefix==null){
                response.sendRedirect("/IS3102_Project-war/B/SG/index.jsp");
                return;
            }
            
            Long countryID = (long) session.getAttribute("countryID");
            String id = request.getParameter("id");
            String sku = request.getParameter("SKU");
            String price = request.getParameter("price");
            
            String name = request.getParameter("name");
            String imageUrl = request.getParameter("imageURL");
            
            ShoppingCartLineItem oneItem = new ShoppingCartLineItem();
            oneItem.setId(id);
            oneItem.setSKU(sku);
            oneItem.setName(name);
            oneItem.setPrice(Double.parseDouble(price));
            oneItem.setImageURL(imageUrl);
            oneItem.setCountryID(countryID);
            oneItem.setQuantity(1);//one item wat
            int quantity = seeQuantity(countryID, sku);//countryID need be Long
            
            ArrayList<ShoppingCartLineItem> shoppingCartItems = (ArrayList<ShoppingCartLineItem>) session.getAttribute("shoppingCart");
            if(quantity<1){
                response.sendRedirect("/IS3102_Project-war/B/"+urlPrefix+"shoppingCart.jsp?errMsg=Item unavailable. Cannot add to cart.");
                return;
            }
            if(shoppingCartItems==null){
                shoppingCartItems = new ArrayList<ShoppingCartLineItem>();
                shoppingCartItems.add(oneItem);
            } 
            else if (!shoppingCartItems.contains(oneItem)){
                shoppingCartItems.add(oneItem);
            } 
            else {
                if (shoppingCartItems.contains(oneItem)){
                    for (ShoppingCartLineItem item : shoppingCartItems){
                        if(item.equals(oneItem)){
                            if(quantity<item.getQuantity()+1){
                                response.sendRedirect("/IS3102_Project-war/B/" + urlPrefix + "shoppingCart.jsp?errMsg=Item unavailable. Cannot add to cart.");
                                return; //64.
                            }
                            else{
                                item.setQuantity(item.getQuantity()+1);
                            }
                            System.out.println("item quantity: "+item.getQuantity());
                            break;
                        }
                    }
                }
            }
            session.setAttribute("shoppingCart", shoppingCartItems);
            response.sendRedirect("/IS3102_Project-war/B/"+urlPrefix+"shoppingCart.jsp?goodMsg=Item has been added.");
        } catch(Exception ex){
            System.out.println("Exception Occured!");
            System.out.println(ex);
            response.sendRedirect("/IS3102_Project-war/B/"+urlPrefix+"Exception occured. Item was not added to cart.");
        }
    }
    
    public int seeQuantity(Long countryID, String sku){
        //debug
        System.out.println("seeQuantity START");
        System.out.println("SKU = "+sku);
        try{
            Client client = ClientBuilder.newClient();
            WebTarget target = client
                    .target("http://localhost:8080/IS3102_WebService-Student/webresources/entity.countryentity")
                    .path("getQuantity")
                    .queryParam("countryID", countryID)
                    .queryParam("SKU", sku);
            //from sep practical
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response  = invocationBuilder.get();
            if(response.getStatus()!=200){
                return 0;
            }
            String incomingResponse = (String) response.readEntity(String.class);
            return Integer.parseInt(incomingResponse);
        } catch(Exception ex){
            System.out.println("Exception Occured!");
            System.out.println(ex);
            return 0;// no QUANtity
        }
        
        //return 0;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
  //wot is this
}
