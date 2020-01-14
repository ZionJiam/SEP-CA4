/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B_servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.ws.rs.client.Entity;

/**
 *
 * @author futur
 */
@WebServlet(name = "ECommerce_MemberEditProfileServlet", urlPatterns = {"/ECommerce_MemberEditProfileServlet"})
public class ECommerce_MemberEditProfileServlet extends HttpServlet {

    private String result;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        boolean isSuccess = false;
      try {
            Long id = Long.parseLong(request.getParameter("id"));
            String email = request.getParameter("email");
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String country = request.getParameter("country");
            String address = request.getParameter("address");
            int securityQuestion = Integer.parseInt(request.getParameter("securityQuestion"));
            String securityAnswer = request.getParameter("securityAnswer");
            int age = Integer.parseInt(request.getParameter("age"));
            int income = Integer.parseInt(request.getParameter("income"));
            String password = request.getParameter("password");

            isSuccess = updateMember(id, email, name, phone, country, address, securityQuestion, securityAnswer, age, income, password);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (isSuccess) {
            response.sendRedirect("ECommerce_GetMember?goodMsg=Account Successfully Updated");
            System.out.println("Success Update");
        } else {
            response.sendRedirect("ECommerce_GetMember?errMsg=Account Failed to Update, Please try again later.");
            System.out.println("Failed Update");
        }

    }

    public boolean updateMember(Long id, String email, String name, String phone, String country, String address, int securityQuestion, String securityAnswer, int age, int income, String password) {
        boolean isSuccess = false;
        try {
            Client client = ClientBuilder.newClient();
            WebTarget target = client
                    .target("http://localhost:8080/IS3102_WebService-Student/webresources/entity.memberentity").path("update")
                    .queryParam("id", id)
                    .queryParam("email", email)
                    .queryParam("name", name)
                    .queryParam("phone", phone)
                    .queryParam("country", country)
                    .queryParam("address", address)
                    .queryParam("securityQuestion", securityQuestion)
                    .queryParam("securityAnswer", securityAnswer)
                    .queryParam("age", age)
                    .queryParam("income", income)
                    .queryParam("password", password);

            Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
            Response response = invocationBuilder.put(Entity.entity("", "application/json"));

            if (response.getStatus() == 200) {
                return (!isSuccess);
            } else {
                return isSuccess;
            }

        } catch (Exception ex) {
            System.out.println("servlet error");
            ex.printStackTrace();
        }

        return isSuccess;
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