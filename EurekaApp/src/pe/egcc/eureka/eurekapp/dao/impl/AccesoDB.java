/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.egcc.eureka.eurekapp.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author JuanValdemar
 */
public class AccesoDB {
    
    private AccesoDB(){
        
    }
    public static Connection getConnection() throws SQLException{
        Connection cn;
        try {
            //parametros 
            String driver="oracle.jdbc.OracleDriver";
            String url ="jdbc:oracle:thin:@192.168.1.102:1521:XE";
            String user = "eureka";
            String pass = "admin";
            
            //cargar el drive r
            Class.forName(driver).newInstance();
            //obtener objetos connection
            cn = DriverManager.getConnection(url, user, pass);
       } catch (ClassNotFoundException e) { 
             throw new SQLException("No se encuentra el driver");
       } catch (SQLException e) {  
           throw e;
        } catch (Exception e) {
            throw new SQLException("No se puede establecer la coneccion");
        }
        return cn;
    }  
}
