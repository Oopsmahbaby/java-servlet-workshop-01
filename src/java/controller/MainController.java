/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class MainController extends HttpServlet {
    private String REGISTER="register";
    private String SHOW_ALL_ACC="allAcc";
    private String SHOW_ALL_CATEGORY="allCate";
    private String SHOW_ALL_PRODUCT="allProduct";
    private String SEARCH="search";
    private String ADD_CATEGORY="addCate";
    private String MODIFY_CATEGORY="modCate";
    private String ADD_PRODUCT="addProduct";
    private String MODIFY_PRODUCT="showProductByRole";
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
        String url=null;
        try {
           String action=request.getParameter("action");
           if(action==null){
               
           }else if(action.equals(REGISTER)){
               url=REGISTER;
           }else if(action.equals(SHOW_ALL_ACC)){
               url=SHOW_ALL_ACC;
           }else if(action.equals(SHOW_ALL_CATEGORY)){
               url=SHOW_ALL_CATEGORY;
           }else if(action.equals(SHOW_ALL_PRODUCT)){
               url=SHOW_ALL_PRODUCT;
           }else if(action.equals("Search")){
               url=SEARCH;
           }else if(action.equals(ADD_CATEGORY)){
               url= ADD_CATEGORY;
           }else if(action.equals(MODIFY_CATEGORY)){
               url=MODIFY_CATEGORY;
           }else if(action.equals(ADD_PRODUCT)){
               url=ADD_PRODUCT;
           }else if(action.equals(MODIFY_PRODUCT)){
               url=MODIFY_PRODUCT;
           }
        }finally{
            RequestDispatcher rd=request.getRequestDispatcher(url);
            rd.forward(request, response);
            out.close();
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
