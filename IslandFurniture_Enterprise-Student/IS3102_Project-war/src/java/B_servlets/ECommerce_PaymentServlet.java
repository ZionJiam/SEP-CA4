/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_servlets;

import HelperClasses.Member;
import HelperClasses.ShoppingCartLineItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author futur
 */
@WebServlet(name = "ECommerce_PaymentServlet", urlPatterns = {"/ECommerce_PaymentServlet"})
public class ECommerce_PaymentServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            HttpSession session = request.getSession();
            ArrayList<String> skuList = new ArrayList<>();

            long countryId = (long) session.getAttribute("countryID");
            Member member = (Member) session.getAttribute("member");
            ArrayList<ShoppingCartLineItem> shoppingCart = (ArrayList<ShoppingCartLineItem>) session.getAttribute("shoppingCart");

            for (ShoppingCartLineItem item : shoppingCart) {
                skuList.add(item.getSKU());
            }

            double totalPrice = (double) session.getAttribute("totalPrice");
            int salesRecordId = createSalesRecord(member, totalPrice);
            int itemCount = 0;

            if (salesRecordId == 0) {
                session.setAttribute("errMsg", "Error During Transaction");
                session.setAttribute("goodMsg", null);
            } else {
                for (ShoppingCartLineItem item : shoppingCart) {
                    if (createLineItemRecord(salesRecordId, Long.parseLong(item.getId()), item.getQuantity(), item)) {
                        itemCount++;
                    }
                }

                shoppingCart.clear();
                session.setAttribute("goodMsg", "Transaction Successful");
            }

            response.sendRedirect("/IS3102_Project-war/B/SG/shoppingCart.jsp");
        } catch (Exception ex) {
            out.println("\n\n " + ex.getMessage());
        }
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

    private boolean createLineItemRecord(int salesRecordId, long itemEntityID, int quantity, ShoppingCartLineItem item) {
                try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8080/IS3102_WebService-Student/webresources/commerce/")
                    .path("createECommerceTransactionRecord")
                    .queryParam("salesRecordId", salesRecordId)
                    .queryParam("itemEntityId",itemEntityID)
                    .queryParam("quantity", quantity);
            
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.put(Entity.entity(item, MediaType.APPLICATION_JSON));
            System.out.println("status: " + response.getStatus());
            
            if(response.getStatus() != 201){
                return false;
            }
            
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private int createSalesRecord(Member member, double totalPrice) {
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target("http://localhost:8080/IS3102_WebService-Student/webresources/commerce/")
                    .path("createECommerceTransactionRecord")
                    .queryParam("memberId", member.getId())
                    .queryParam("amountPaid", totalPrice);
            
            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.put(Entity.entity(member, MediaType.APPLICATION_JSON));
            System.out.println("status: " + response.getStatus());
            
            if(response.getStatus() != 201){
                return 0;
            }
            
            String uri = (String)response.getMetadata().getFirst("Location");
            int salesRecordId  = Integer.parseInt(uri.substring(uri.lastIndexOf("/") + 1));
            
            return salesRecordId;

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }

}
