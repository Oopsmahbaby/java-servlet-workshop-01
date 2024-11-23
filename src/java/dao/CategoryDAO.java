/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import model.Category;

/**
 *
 * @author ADMIN
 */
public class CategoryDAO extends ConnectDB implements Accessible<Category> {

    private ServletContext sc;
    private Connection con;

    public CategoryDAO() throws ClassNotFoundException, SQLException {
        this.sc = null;
        this.con = new ConnectDB().getConnection();
    }

    public CategoryDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
        this.sc = sc;
        this.con = new ConnectDB().getConnection();
    }

    @Override
    public int insertRec(Category obj) {
        int r = 0;
        try {
            String query = "insert into categories (categoryName, memo)"
                    + "values(?,?)";
            PreparedStatement pStm = con.prepareStatement(query);
            pStm.setString(1, obj.getCategoryName());
            pStm.setString(2, obj.getMemo());
            r = pStm.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    @Override
    public int updateRec(Category obj) {
        int r = 0;
        try {
            String query = "update categories\n"
                    + "set categoryName=?,\n"
                    + "memo=?\n"
                    + "where typeId=?";
            PreparedStatement pStm = con.prepareStatement(query);
            pStm.setString(1, obj.getCategoryName());
            pStm.setString(2, obj.getMemo());
            pStm.setInt(3, obj.getTypeID());
            r = pStm.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    @Override
    public int deleteRec(Category obj) throws SQLException {
        int r = 0;
        String query = "delete from categories where typeId=?";
        PreparedStatement pStm = con.prepareStatement(query);
        pStm.setInt(1, obj.getTypeID());
        r = pStm.executeUpdate();
        return r;
    }

    @Override
    public Category getObjByID(String id) {
        try {
            PreparedStatement pStm = con.prepareStatement("select * from categories where typeId=?");
            pStm.setString(1, id);
            ResultSet rs = pStm.executeQuery();
            if (rs.next()) {
                Category c = new Category(
                        rs.getInt("typeID"),
                        rs.getString("categoryName"),
                        rs.getString("memo"));
                return c;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    public Category getObjByID(int id) {
        try {
            PreparedStatement pStm = con.prepareStatement("select * from categories where typeId=?");
            pStm.setInt(1, id);
            ResultSet rs = pStm.executeQuery();
            if (rs.next()) {
                Category c = new Category(
                        rs.getInt("typeID"),
                        rs.getString("categoryName"),
                        rs.getString("memo"));
                return c;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public List<Category> listAll() {
        List<Category> list = new ArrayList<>();
        try {
            PreparedStatement pStm = con.prepareStatement("select * from categories");
            ResultSet rs = pStm.executeQuery();
            while (rs.next()) {
                Category c = new Category(
                        rs.getInt("typeID"),
                        rs.getString("categoryName"),
                        rs.getString("memo"));
//                Category c = new Category(
//                        rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3));
                list.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Category c = new Category();
//        c.setTypeID(6);
        CategoryDAO ad = new CategoryDAO();
//        ad.deleteRec(c);
//        List<Category> list = ad.listAll();
//        for (Category i : list) {
//            System.out.println(i);
//        }
//    c.setTypeID(12);
//    c.setCategoryName("heheheheheh");
//    c.setMemo("hay qua troi");
//    ad.updateRec(c);
    System.out.println(ad.listAll());
    }
}
