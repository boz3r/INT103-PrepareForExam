package exam;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class database {

    private final String DBUSER = "root";
    private final String DNPASWD = "root";
    private final String URL = "jdbc:mysql://127.0.0.1:8889/mydb2";
    
    private String mail;
    
    public boolean isLogin;

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
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, DBUSER, DNPASWD);
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
