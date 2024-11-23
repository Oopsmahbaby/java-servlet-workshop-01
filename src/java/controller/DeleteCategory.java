package controller;

import dao.CategoryDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;

/**
 *
 * @author ADMIN
 */
public class DeleteCategory extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    } 

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        int typeID = Integer.parseInt(request.getParameter("typeID"));
        //HttpSession ss=request.getSession();
        try {
            Category c=new Category();
            c.setTypeID(typeID);
            CategoryDAO cDao=new CategoryDAO();
            cDao.deleteRec(c);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DeleteCategory.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("ERR_DELETE", "You cannot remove this Category");
        }
        request.getRequestDispatcher("modCate").forward(request, response);
//        response.sendRedirect("modCate");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
