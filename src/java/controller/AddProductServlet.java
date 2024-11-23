package controller;

import dao.AccountDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Category;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class AddProductServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            AccountDAO a = new AccountDAO();
            List<Account> listAcc = a.listAll();
            request.setAttribute("accountListP", listAcc);  //chon account nào là người chọn sản phẩm
            CategoryDAO c = new CategoryDAO();
            List<Category> listCate = c.listAll();
            request.setAttribute("cateListP", listCate);
            request.getRequestDispatcher("addNewProducts.jsp").forward(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(showAllAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String productImage = request.getParameter("productImage");
        String brief = request.getParameter("brief");
        long postedDate = -1;
        Product p = new Product();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            postedDate = sf.parse(request.getParameter("postedDate")).getTime();
        } catch (ParseException ex) {
            Logger.getLogger(AddCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        int productTypeID = Integer.parseInt(request.getParameter("productTypeID"));
        String productAccount = request.getParameter("productAccount");
        String unit = request.getParameter("unit");
        try {
            String discountParameter = request.getParameter("discount");

            // Check if the parameter is not null and not empty before parsing
            if (discountParameter != null && !discountParameter.isEmpty()) {
                int discount = Integer.parseInt(discountParameter);
                // Now you can use the 'discount' variable as an integer
                p.setDiscount(discount);
            } else {
                request.setAttribute("ERR_Num", "Discount must be a number! Please try again!");
            }
        } catch (NumberFormatException ex) {
            // Handle the case where the parameter is not a valid integer
            Logger.getLogger(AddCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String priceParameter = request.getParameter("price");
            if (priceParameter != null && !priceParameter.isEmpty()) {
                int price = Integer.parseInt(priceParameter);
                p.setPrice(price);
            } else {
                request.setAttribute("ERR_Num", "Discount must be a number! Please try again!");
            }
        } catch (NumberFormatException ex) {
            Logger.getLogger(AddCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            Category c = new Category();
            c.setTypeID(productTypeID);
            Account a = new Account();
            a.setAccount(productAccount);
            p.setProductID(productId);
            p.setProductName(productName);
            p.setProductImage(productImage);
            p.setBrief(brief);
            p.setPostedDate(postedDate == -1 ? null : new Date(postedDate));
            p.setTypeId(c);
            p.setAccount(a);
            p.setUnit(unit);
            ProductDAO pDao = new ProductDAO();
            pDao.insertRec(p);
            response.sendRedirect("allProduct");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AddProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
