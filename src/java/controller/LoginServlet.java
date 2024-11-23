package controller;

import dao.AccountDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class LoginServlet extends HttpServlet {

    private final String SUCCESS = "allProduct";
    private final String FAILURE = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String user_raw = request.getParameter("user");
            String pass_raw = request.getParameter("pass");
            HttpSession ss = request.getSession();

            Account x = new AccountDAO(getServletContext()).checkLogin(user_raw, pass_raw);
            if (x!=null) {
                ss.setAttribute("TTDN", x);
//                ss.setAttribute("firstName", x.getFirstName());
//                ss.setAttribute("lastName", x.getLastName());
//                ss.setMaxInactiveInterval(10);
                response.sendRedirect(SUCCESS);
            } else {
                request.setAttribute("ERROR_MES", "Invalid login information");
                request.getRequestDispatcher(FAILURE).forward(request, response);

            }
        } catch (ServletException | IOException | ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
