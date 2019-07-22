package indi.tony.yrtester.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DBUtil {
    private static final String driver = "org.sqlite.JDBC";
    private static final String dbPath = "src/main/resources/database/yrtester.db";

    public static void initDB() {
        Connection connection = createConnection();
        closeConnection(connection);
    }

    public static ArrayList<String> selectOneColumn(String tableName, String columnName) {
        Connection connection = createConnection();
        Statement statement = createStatement(connection);
        String sql = "select " + columnName + " from " + tableName;
        ResultSet rs = createSet(statement, sql);
        ArrayList<String> result = new ArrayList<String>();
        try {
            while (rs.next()) {
                result.add(rs.getString(columnName));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeSet(rs);
            closeStatement(statement);
            closeConnection(connection);
        }
        return result;
    }

    public static HashMap<String, ArrayList<String>> selectContentMap(String sql) {
        HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();
        Connection connection = createConnection();
        Statement statement_col = createStatement(connection);
        Statement statement = createStatement(connection);
        ResultSet rs_col = createSet(statement_col, sql);
        ResultSet rs = null;
        try {
            for (int i = 0; i < rs_col.getMetaData().getColumnCount(); i++) {
                String columnName = rs_col.getMetaData().getColumnName(i + 1);
                ArrayList<String> result_col = new ArrayList<String>();
                rs = createSet(statement, sql);
                while (rs.next()) {
                    result_col.add(rs.getString(columnName));
                }
                result.put(columnName, result_col);
                closeSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeSet(rs_col);
            closeSet(rs);
            closeStatement(statement_col);
            closeStatement(statement);
            closeConnection(connection);
        }
        return result;
    }

    public static void insertContent(ArrayList<String> sqlList) {
        Connection connection = createConnection();
        Statement statement = createStatement(connection);
        try {
            for (String sql : sqlList
            ) {
                statement.executeUpdate(sql);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeStatement(statement);
        closeConnection(connection);
    }

    private static Connection createConnection() {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + dbPath);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    private static void closeConnection(Connection cn) {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static Statement createStatement(Connection cn) {
        Statement statement = null;
        try {
            statement = cn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    private static void closeStatement(Statement stat) {
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static ResultSet createSet(Statement stat, String sql) {
        ResultSet rs = null;
        try {
            rs = stat.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    private static void closeSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
