/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class UpdateAccountServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UpdateAccountServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UpdateAccountServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        String acc = request.getParameter("acc");

        try {
            AccountDAO aDao = new AccountDAO();
            Account a =aDao.getObjByID(acc);
            request.setAttribute("updAccount", a);
            request.getRequestDispatcher("updateAccount.jsp").forward(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UpdateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        request.setCharacterEncoding("UTF-8");
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        Long d = null;
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            d = sf.parse(request.getParameter("dob")).getTime();
        } catch (Exception e) {
        }
        boolean gender=request.getParameter("gender").equals("1");
        String phone=request.getParameter("phone");
        boolean isUse=request.getParameter("isUse").equals("1");
        int role=Integer.parseInt(request.getParameter("role"));
        String adminCode=request.getParameter("adminCode");
        String account=request.getParameter("account");
        String pass=request.getParameter("pass");
        String pass_repeat=request.getParameter("pass-repeat");
        if(!pass_repeat.equalsIgnoreCase(pass)){
            request.setAttribute("ERR_PASS","Password does not match! Please try again!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }else{
            try {
                AccountDAO aDao=new AccountDAO();
                Account a=new Account(account,pass,lname,fname,phone,new Date(d),gender,isUse,role);
                aDao.updateRec(a);
                response.sendRedirect("allAcc");
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UpdateAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
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
