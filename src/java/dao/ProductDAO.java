/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import controller.AddCategoryServlet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import model.Account;
import model.Category;
import model.Product;

/**
 *
 * @author ADMIN
 */
public class ProductDAO extends ConnectDB implements Accessible<Product> {

    private ServletContext sc;
    private Connection con;

    public ProductDAO() throws ClassNotFoundException, SQLException {
        this.con = new ConnectDB().getConnection();
    }

    public ProductDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
        this.sc = sc;
        this.con = new ConnectDB().getConnection();
    }

    @Override
    public int insertRec(Product obj) {
        int r = 0;
        try {
            String query = "insert into products\n"
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pStm = con.prepareStatement(query);
            pStm.setString(1, obj.getProductID());
            pStm.setString(2, obj.getProductName());
            pStm.setString(3, obj.getProductImage());
            pStm.setString(4, obj.getBrief());
            if(obj.getPostedDate() == null){
                pStm.setNull(5, Types.DATE);
            } else {
                pStm.setDate(5, obj.getPostedDate());
            }
            pStm.setInt(6, obj.getTypeId().getTypeID());
            pStm.setString(7, obj.getAccount().getAccount());
            pStm.setString(8, obj.getUnit());
            pStm.setInt(9, obj.getPrice());
            pStm.setInt(10, obj.getDiscount());
            r = pStm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AddCategoryServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public int updateRec(Product obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int deleteRec(Product obj) {
        int r = 0;
        try {
            String query = "delete from products where productId=?";
            PreparedStatement pStm = con.prepareStatement(query);
            pStm.setString(1, obj.getProductID());
            r = pStm.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

    @Override
    public Product getObjByID(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Product> listAll() {
        List<Product> list = new ArrayList<>();
        try {
            CategoryDAO categoryDAO = new CategoryDAO();
            Category category = new Category();
            AccountDAO accountDAO = new AccountDAO();
            Account account = new Account();
            PreparedStatement pStm = con.prepareStatement("select * from products");
            ResultSet rs = pStm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getString("productID"));
                p.setProductName(rs.getString("productName"));
                p.setProductImage(rs.getString("productImage"));
                p.setBrief(rs.getString("brief"));
                p.setUnit(rs.getString("unit"));
                p.setPostedDate(rs.getDate("postedDate"));
                category = categoryDAO.getObjByID(rs.getInt("typeId"));
                p.setTypeId(category);
                account = accountDAO.getObjByID(rs.getString("account"));
                p.setAccount(account);
                p.setPrice(rs.getInt("price"));
                p.setDiscount(rs.getInt("discount"));
//                Product p = new Product(
//                        rs.getString("productID"),
//                        rs.getString("productName"),
//                        rs.getString("productImage"),
//                        rs.getString("brief"),
//                        rs.getString("unit"),
//                        rs.getDate("postedDate"),
//                        setTypeId(CategoryDAO.getObjByID(rs.getInt("typeID")),
//                        rs.getString("account"),
//                        rs.getInt("price"),
//                        rs.getInt("discount")
//                );
                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<Product> getProductByRole(String role) {
        List<Product> list = new ArrayList<>();
        try {
            CategoryDAO categoryDAO = new CategoryDAO();
            Category category = new Category();
            AccountDAO accountDAO = new AccountDAO();
            Account account = new Account();
            PreparedStatement pStm = con.prepareStatement("select * from products where account=?");
            pStm.setString(1, role);
            ResultSet rs = pStm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getString("productID"));
                p.setProductName(rs.getString("productName"));
                p.setProductImage(rs.getString("productImage"));
                p.setBrief(rs.getString("brief"));
                p.setUnit(rs.getString("unit"));
                p.setPostedDate(rs.getDate("postedDate"));
                category = categoryDAO.getObjByID(rs.getInt("typeId"));
                p.setTypeId(category);
                account = accountDAO.getObjByID(rs.getString("account"));
                p.setAccount(account);
                p.setPrice(rs.getInt("price"));
                p.setDiscount(rs.getInt("discount"));

                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public List<Product> searchByName(String name) {
        List<Product> list = new ArrayList<>();
        try {
            CategoryDAO categoryDAO = new CategoryDAO();
            Category category = new Category();
            AccountDAO accountDAO = new AccountDAO();
            Account account = new Account();
            PreparedStatement pStm = con.prepareStatement("select * from products where productName like ?");
            pStm.setString(1, "%"+name+"%");
            ResultSet rs = pStm.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setProductID(rs.getString("productID"));
                p.setProductName(rs.getString("productName"));
                p.setProductImage(rs.getString("productImage"));
                p.setBrief(rs.getString("brief"));
                p.setUnit(rs.getString("unit"));
                p.setPostedDate(rs.getDate("postedDate"));
                category = categoryDAO.getObjByID(rs.getInt("typeId"));
                p.setTypeId(category);
                account = accountDAO.getObjByID(rs.getString("account"));
                p.setAccount(account);
                p.setPrice(rs.getInt("price"));
                p.setDiscount(rs.getInt("discount"));

                list.add(p);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Category c=new Category();
        c.setTypeID(3);
        Account a=new Account();
        a.setAccount("admin");
        Product p=new Product();
        p.setProductID("15 Pro Max");
        p.setProductName("Thanh An");
        p.setTypeId(c);
        p.setAccount(a);
        p.setDiscount(0);
        ProductDAO pd = new ProductDAO();
        pd.insertRec(p);
        List<Product> list = pd.getProductByRole("admin");
        for (Product i : list) {
            System.out.println(i);
        }

    }

}
