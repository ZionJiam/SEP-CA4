/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_servlets;

import HelperClasses.ShoppingCartLineItem;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author 2014p
 */
public class ECommerce_RemoveItemFromListServlet extends HttpServlet {
     protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         System.out.println("ECommerce_RemoveItemFromListServlet");
         
         try{
             String[] deleteArr = request.getParameterValues("delete");
             HttpSession session = request.getSession();
             List<ShoppingCartLineItem> shoppingCart = (List<ShoppingCartLineItem>) session.getAttribute("shoppingCart");
             for(int i=0;i<deleteArr.length;i++){
                 ShoppingCartLineItem item = new ShoppingCartLineItem();
                 item.setSKU(deleteArr[i]);
                 shoppingCart.remove(item);
             }
             session.setAttribute("shoppingCart", shoppingCart);
             response.sendRedirect("/IS3102_Project-war/B/shoppingCart.jsp");
         }catch(Exception ex){
             ex.printStackTrace();
         }
     }
    
    
}
