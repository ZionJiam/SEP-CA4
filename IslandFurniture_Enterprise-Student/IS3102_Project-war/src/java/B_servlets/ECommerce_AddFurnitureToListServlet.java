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
        try (PrintWriter out = response.getWriter()) {
            System.out.println("ECommerce_AddFurnitureToListServlet processRequest START");
            HttpSession session = request.getSession();
            String SKUstring = request.getParameter("SKU");
            boolean exists = false;//not initialised smh
            int id = 0; //shopping cart helperclass has id... //int id has not been initialised
            
            for (int i=0; i<shoppingCartItems.size(); i++) {
                if(shoppingCartItems.get(i).getSKU().equals(SKUstring)){
                    exists = true;
                    id = 1;
                }
            }//end of for loop
            
            if(exists){
                shoppingCartItems.get(id).setQuantity(shoppingCartItems.get(id).getQuantity()+1);//add one from existing amount in cart
                session.setAttribute("shoppingCart", shoppingCartItems);
                message = "Item added to cart";
                response.sendRedirect("/IS3102_Project-war/B/SG/shoppingCart.jsp?");
            }
            
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

}
