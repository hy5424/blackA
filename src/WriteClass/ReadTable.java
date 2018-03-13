package WriteClass;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ********************************************************
 * 
 * @ClassName: ReadTable
 * @Description: 读取表属性
 * @author DoDo
 * @date 2012-12-26 下午05:36:42
 */
public class ReadTable {

    ConnectionManager db = new ConnectionManager();

    /**
     * ********************************************************
     * 
     * @Title: read
     * @Description: 获取表字段名和数据类型
     * @param table
     * @return Map
     * @date 2012-12-26 下午05:37:20
     */
    @SuppressWarnings("rawtypes")
    public Map read(String table) {
        Map<String, String[][]> map = new LinkedHashMap<String, String[][]>();
        Connection conn = db.getConn();
        PreparedStatement pstmt = null;
        ResultSetMetaData rsmd = null;
        String findsql = "select * from " + table;

        try {
            pstmt = conn.prepareStatement(findsql);
            // pstmt.execute(); // 这点特别要注意:如果是Oracle 而对于mysql可以不用加.
            rsmd = pstmt.getMetaData();

            for (int i = 1; i < rsmd.getColumnCount() + 1; i++) {

                map.put(rsmd.getColumnName(i).toLowerCase(), new String[][] {{rsmd.getColumnTypeName(i).toLowerCase(),
                        rsmd.getScale(i) + "" } });
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
        return map;
    }

    /**
     * ********************************************************
     * 
     * @Title: findDecimals
     * @Description: 查询小数位数
     * @param table
     * @param attribute
     * @return boolean
     * @date 2012-12-27 上午11:49:35
     */
    public Map<String, String> findDecimals(String table, String attribute) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        String sql = "select DISTINCT COLUMN_NAME,NUMERIC_SCALE from information_schema.`COLUMNS` where TABLE_NAME='"
                + table.toUpperCase() + "' AND COLUMN_NAME = '" + attribute + "'";
        Connection conn = db.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                map.put(rs.getString(1).toLowerCase(), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return map;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
        return map;
    }

    /**
     * ********************************************************
     * 
     * @Title: findTableComments
     * @Description: 查询 Oracle 数据库 Comments 表说明
     * @param table
     *            表名
     * @return String
     * @date 2012-12-27 下午05:55:44
     */
    public String findTableComments(String table) {
        String sql = "select TABLE_COMMENT from information_schema.`TABLES` where TABLE_NAME='" + table.toUpperCase()
                + "'";
        Connection conn = db.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String comments = "";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                comments = rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
        return comments;
    }

    /**
     * ********************************************************
     * 
     * @Title: findColComment
     * @Description: 查询该表所有属性的说明
     * @param table
     * @return Map
     * @date 2012-12-27 下午05:59:25
     */
    @SuppressWarnings("rawtypes")
    public Map findColComment(String table) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        Connection conn = db.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select COLUMN_NAME,COLUMN_COMMENT from information_schema.`COLUMNS` where TABLE_NAME='"
                + table.toUpperCase() + "'";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                map.put(rs.getString(1).toLowerCase(), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
        return map;
    }

    /**
     * @Title: findColDataLength
     * @Description: 查询该表所有字段长度
     * @param table
     * @return Map
     * @param table
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Map findColDataLength(String table) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        Connection conn = db.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select COLUMN_NAME,CHARACTER_MAXIMUM_LENGTH from information_schema.`COLUMNS` where TABLE_NAME='"
                + table.toUpperCase() + "'";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                map.put(rs.getString(1).toLowerCase(), rs.getString(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
        return map;
    }

    /**
     * ********************************************************
     * 
     * @Title: findColComment
     * @Description: 查询该表的主键名称
     * @param table
     * @return Map
     * @date 2012-12-27 下午05:59:25
     */

    public String getPK(String table_name) {

        String pk_name = "";
        Connection conn = db.getConn();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select COLUMN_NAME from information_schema.`TABLES` where TABLE_NAME='"
                + table_name.toUpperCase() + "and COLUMN_KEY = 'PRI'";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                pk_name = rs.getString("name").toLowerCase();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {

            }
        }
        return pk_name;
    }
}
