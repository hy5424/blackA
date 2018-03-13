package WriteClass;

import java.sql.*;

public class ConnectionManager {

    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String URL = "jdbc:mysql://127.0.0.1:3306/ares";
    public static final String UID = "root";
    public static final String PWD = "root";

    protected Connection conn;
    protected PreparedStatement pstmt;
    protected ResultSet rs;

    public Connection getConn() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, UID, PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public void colseAll() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
