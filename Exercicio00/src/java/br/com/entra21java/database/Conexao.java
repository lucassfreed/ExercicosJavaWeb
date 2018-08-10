package br.com.entra21java.database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Lucas Rodrigo
 */
public class Conexao {
    
    private static final String HOST = "jdbc:mysql://localhost/ex_javaweb_00";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static final String CLASS = "com.mysql.jdbc.Driver";
    private static Connection conexao;
    
    public static Connection getConnection() {
        try {
            Class.forName(CLASS);
            conexao = DriverManager.getConnection(HOST, USER, PASSWORD);
            return conexao;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void closeConnection() {
        try {
            conexao.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
