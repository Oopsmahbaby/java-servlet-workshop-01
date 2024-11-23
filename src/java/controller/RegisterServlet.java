

package controller;

import dao.AccountDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class RegisterServlet extends HttpServlet {
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegisterServlet</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegisterServlet at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    } 

    
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
            AccountDAO aDao;
            try {
                aDao = new AccountDAO();
                Account a=aDao.checkAccountExist(account);
                if(a==null){ //không trùng == kh tồn tại => được regis
                    Account acc=new Account(account,pass,lname,fname,phone,new Date(d),gender,isUse,role);
                    aDao.insertRec(acc);
                    response.sendRedirect("allAcc");
                }else{
                    request.setAttribute("ACC_Exist", "This account is existed! Please choose another Account name!");
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                    
                    
                }
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
