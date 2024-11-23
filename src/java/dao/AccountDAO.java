/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import model.Account;

/**
 *
 * @author ADMIN
 */
public class AccountDAO extends ConnectDB implements Accessible<Account> {

    private ServletContext sc;
    private Connection con;

    public AccountDAO() throws ClassNotFoundException, SQLException {
//        con = new ConnectDB().getConnection();
        this.sc=null;
        this.con=new ConnectDB().getConnection();
    }

    public AccountDAO(ServletContext sc) throws ClassNotFoundException, SQLException {
        this.sc = sc;
        this.con = new ConnectDB().getConnection();

    }
    
//    private Connection getConnect(ServletContext sc) throws ClassNotFoundException, SQLException{
//        return sc==null? new ConnectDB().getConnection():new ConnectDB(sc).getConnection();
//    }

    @Override
    public int insertRec(Account obj) {
        int r=0;
        try {
            String query = "insert into accounts\n"
                    + "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pStm = con.prepareStatement(query);
            pStm.setString(1, obj.getAccount());
            pStm.setString(2, obj.getPass());
            pStm.setString(3, obj.getLastName());
            pStm.setString(4, obj.getFirstName());
            pStm.setDate(5, obj.getBirthday());
            pStm.setBoolean(6, obj.isGender());
            pStm.setString(7, obj.getPhone());
            pStm.setBoolean(8, obj.isIsUse());
            pStm.setInt(9, obj.getRoleInSystem());
            r = pStm.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    @Override
    public int updateRec(Account obj) {
        int r=0;
        try {
            String query = "UPDATE accounts SET firstName=?, lastName=?, birthday=?, phone=? WHERE account=?";
            PreparedStatement pStm = con.prepareStatement(query);
            pStm.setString(1, obj.getFirstName());
            pStm.setString(2, obj.getLastName());
            pStm.setDate(3, obj.getBirthday());
            pStm.setString(4, obj.getPhone());
            pStm.setString(5, obj.getAccount());
            r = pStm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public int deleteRec(Account obj) {
        int r=0;
        try {
            String query="delete from accounts where account=?";
            PreparedStatement pStm=con.prepareStatement(query);
            pStm.setString(1, obj.getAccount());
            r=pStm.executeUpdate();
        } catch (SQLException e) {
        }
        return r;
    }

    public Account checkLogin(String acc,String pass) { // check password
        try {
            PreparedStatement pStm = con.prepareStatement("select * from accounts where account=? and pass=?");
            pStm.setString(1, acc);
            pStm.setString(2, pass);
            ResultSet rs = pStm.executeQuery();
            if(rs.next()){
                Account a=new Account(rs.getString("account"),
                        rs.getString("pass"),
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getString("phone"),
                        rs.getDate("birthday"),
                        rs.getBoolean("gender"),
                        rs.getBoolean("isUse"),
                        rs.getInt("roleInSystem"));
                return a;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    @Override
    public Account getObjByID(String id) { // check password
        try {
            PreparedStatement pStm = con.prepareStatement("select * from accounts where account=?");
            pStm.setString(1, id);
            ResultSet rs = pStm.executeQuery();
            if(rs.next()){
                Account a=new Account(rs.getString("account"),
                        rs.getString("pass"),
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getString("phone"),
                        rs.getDate("birthday"),
                        rs.getBoolean("gender"),
                        rs.getBoolean("isUse"),
                        rs.getInt("roleInSystem"));
                return a;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }
    
    public Account checkAccountExist(String acc) { 
        try {
            PreparedStatement pStm = con.prepareStatement("select * from accounts where account=?");
            pStm.setString(1, acc);
            ResultSet rs = pStm.executeQuery();
            if(rs.next()){
                Account a=new Account(rs.getString("account"),
                        rs.getString("pass"),
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getString("phone"),
                        rs.getDate("birthday"),
                        rs.getBoolean("gender"),
                        rs.getBoolean("isUse"),
                        rs.getInt("roleInSystem"));
                return a;
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

    @Override
    public List<Account> listAll() {
        List<Account> list = new ArrayList<>();
        try {
            PreparedStatement pStm = con.prepareStatement("select * from accounts");
            ResultSet rs = pStm.executeQuery();
            while (rs.next()) {
                Account a = new Account(
                        rs.getString("account"),
                        rs.getString("pass"),
                        rs.getString("lastName"),
                        rs.getString("firstName"),
                        rs.getString("phone"),
                        rs.getDate("birthday"),
                        rs.getBoolean("gender"),
                        rs.getBoolean("isUse"),
                        rs.getInt("roleInSystem")
                );
                list.add(a);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return list;
    }
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Account a=new Account();
        a.setAccount("hi");
//        Long d = null;
//        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
//        try {
//            d = sf.parse("2000-16-10").getTime();
//        } catch (Exception e) {
//        }
//        a.setBirthday(new Date(d));
        a.setFirstName("Hello hello");
        a.setPhone("123456");
        a.setAccount("staff");
        AccountDAO ad=new AccountDAO();
        
//        List<Account> list=ad.listAll();
//        for(Account i: list){
//            System.out.println(i);
        System.out.println(ad.updateRec(a));
    }

    
}
