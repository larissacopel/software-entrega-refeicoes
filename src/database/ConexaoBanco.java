/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class ConexaoBanco {
    
    private static String connectionString = "jdbc:postgresql://queenie.db.elephantsql.com/pysfyfqx";
    
    public static Connection getConnection(){
        try {
            Connection con = DriverManager.getConnection(connectionString, "pysfyfqx", "tSmubqNt3u8jARsQof8yVabZJBdeo1x6");
            System.out.printf("Banco Conectado com Sucesso");        
            return con;
        } catch (SQLException ex) {
            throw new RuntimeException("Erro na conexao", ex);
        }
    }
    
    public static void closeConnection(Connection con){ 
        try {
            if(con!=null){
            con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void closeConnectionStmt(Connection con, PreparedStatement stmt){
        closeConnection(con);
        try {
            if(stmt!=null){
            stmt.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    
    
    public static void closeConnectionSet(Connection con, PreparedStatement stmt, ResultSet set){
        closeConnectionStmt(con,stmt);
        try {
            if(set!=null){
                set.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexaoBanco.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
