/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletContext;


public class ConnectDB {
    private String hostName;
    private String instance;
    private String port;
    private String dbName;
    private String user;
    private String pass;
    /**
     * Default constructor
     */

    public ConnectDB() {
        this.hostName="127.0.0.1";      //--- localhost
        this.port="1433";
        this.dbName="ProductIntro";
        this.user="sa";
        this.pass="12345";
        this.instance="OOPSMAHBABY\\SQLEXPRESS";
    }

    ConnectDB(ServletContext sc) {
        this.hostName=sc.getInitParameter("hostAddress");
        this.instance=sc.getInitParameter("instance");
        this.port=sc.getInitParameter("dbPort");
        this.dbName=sc.getInitParameter("dbName");
        this.user=sc.getInitParameter("userName");
        this.pass=sc.getInitParameter("userPass");
    }
    public String getURLString(){
        String fm = "jdbc:sqlserver://%s\\%s:%s;databaseName=%s;user=%s;password=%s;";
        return String.format(fm,
                this.hostName,this.instance.trim(), this.port,this.dbName, this.user,this.pass );
    }
    public Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(getURLString());
    }
}
