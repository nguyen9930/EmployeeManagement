/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TienIch;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hoang Dong Tien
 */
public class EmpConnection {


    private static String readConnectionString() {
        String str = "";
        StringBuilder connStr = new StringBuilder();
		connStr.append("jdbc:sqlserver://");
		connStr.append("localhost");
		connStr.append(":");
		connStr.append("59430");
		connStr.append(";databaseName=EmployeeTransferManagement2010;user=sa");
		connStr.append(";password=123456");
		str = connStr.toString();
        return str;
    }

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
//
//        String url = "jdbc:odbc:embedded_sql_app"; // establish connection to database
        Connection oConn = null;
////        String url = "jdbc:sqlserver://localhost:1433;databaseName=EmployeeTransferManagement2010;user=sa;password=123456";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        oConn = DriverManager.getConnection(readConnectionString());
        //oConn = DriverManager.getConnection("jdbc:sqlserver://abcxzy:1659;databaseName=EmployeeTransferManagement2010;user=sa;password=1234567");
        return oConn;
    }

    public static void closeConnection(Connection oConn) throws SQLException {
        if (oConn != null) {
            oConn.close();
        }
    }

    public static boolean testConnection() {
        Connection oConn = null;
        try {
            oConn = EmpConnection.getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(EmpConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EmpConnection.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (oConn != null) {
            try {
                EmpConnection.closeConnection(oConn);
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(EmpConnection.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
        if (preparedStatement != null) {
            preparedStatement.close();
        }
    }

    public static void closeCallableStatement(CallableStatement callableStatement) throws SQLException {
        if (callableStatement != null) {
            callableStatement.close();
        }
    }

    public static void main(String[] args) {
//        try {
//            Connection oConn = getConnection();
//            if(oConn != null)
//            {
//                System.out.println("Connected");
//            }
//            closeConnection(oConn);
//        } catch (SQLException ex) {
//            System.out.println(ex.getMessage());
//        } catch (ClassNotFoundException ex) {
//            System.out.println(ex.getMessage());
//        }
        System.out.println(readConnectionString());
        System.out.println(testConnection());
    }
}
