package personnel.connection;
/*
 * Connect to Oracle SQL
 *
 */
import java.sql.*;

public class ConnectionManager {
    private static String URL = "jdbc:oracle:thin:@localhost:1521:orcl";    
    private static String Username = "sys as sysdba";   
    private static String Password = "123456";
    private static Connection con;

    public static Connection getConnection() {
        try {
            Connection con = (Connection) DriverManager.getConnection(URL,Username,Password);
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public static Boolean IsTableExist(Connection con, String tableName) {
        try {
            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, null, tableName, null);
            if (tables.next()) {
                return true;
            } else {
                return false;            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Boolean getAdminInfo(Connection con, String tableName, String username, String password) {
        try {
            String sql = "select * from " + tableName + " where AdminName = '" + username + "' AND AdminPassword = '" + password + "'";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            } else {
                return false;            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ResultSet getALLInfo(Connection con, String tableName) {
        ResultSet rs = null;

        try {
            String sql = "select * from " + tableName;
            PreparedStatement ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

}
