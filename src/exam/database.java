/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exam;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {

    private String dbuser, dbpaswd, url;
    public boolean isLogin;
    public String mail;

    public void accountDatabase(String mail) {
        this.mail = pullMail();
        if (!mail.equals(this.mail)) {
            System.out.println("You shall not pass!!!");
        } else {
            System.out.println("Connecting to DB...");
            this.isLogin = true;
        }
    }

    public Connection managedb() {
        try {
            dbuser = "root";
            dbpaswd = "root";
            url = "jdbc:mysql://127.0.0.1:8889/mydb2";

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, dbuser, dbpaswd);
            return conn;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String pullMail() {
        try {
            String sql = "select email from mydb2.student;";
            Statement sm = managedb().createStatement();
            ResultSet rs = sm.executeQuery(sql);
            while (rs.next()) {
                String dbmail = rs.getString(1);
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
}
