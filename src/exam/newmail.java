package exam;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class newmail extends database{
    private String oldmail, nmail;

    public newmail(String oldmail, String nmail) {
        this.oldmail = oldmail;
        this.nmail = nmail;
    }
    
    public void updateMail() {
        String sqlupdate = "update mydb2.student set email=? where email=?;";
        Connection update = super.managedb();
        PreparedStatement ps;
        try {
            ps = update.prepareStatement(sqlupdate);
            ps.setString(1, nmail);
            ps.setString(2, oldmail);
            ps.executeUpdate();
            System.out.println("Email is updated!!!");
        } catch (SQLException ex) {
            Logger.getLogger(newmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
