/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import models.Usuario;
/**
 *
 * @author 34681
 */
public class conexion {
    final private String db = "passworddb";
    final private String url = "jdbc:mysql://localhost:3306/passworddb";
    final private String user = "root";
    final private String pass = "";
    
public Connection conectionBBDD () throws SQLException 
{
    Connection link = null;
    
    try
    {   
        Class.forName("com.mysql.cj.jdbc.Driver");
        link = (Connection) DriverManager.getConnection(this.url, this.user, this.pass);
    }
    catch(Exception ex)
    {
      System.out.print("Error:" + ex.getMessage() + "/n");
    }

    return link;
}

public boolean inicioSession(Usuario usuario, Connection con ) throws SQLException, Exception
{
    ResultSet resulSet = null;
    Statement st = con.createStatement();
    int numeroFilas = 0;
    ResultSet rs = null;
    String nombre_manager = usuario.getNombreUsuario();
    String password = usuario.getPassword();
    try{
    PreparedStatement ps = con.prepareStatement("SELECT usuarios.id, usuarios.nombre_manager, password.password FROM usuarios, password where usuarios.id = password.usuarios_id and usuarios.nombre_manager=? and password.id_categoria=0 and password.password=?");
            ps.setString(1, nombre_manager);
            ps.setString(2, password );

            ps.executeQuery();
            rs = ps.executeQuery();
            if(rs != null)
            {
            while(rs.next()){
                System.out.println(rs.getString("nombre_manager") + " " + rs.getString("password"));
                numeroFilas++;
            }            
            ps.close();
            rs.close();
            con.close();

            }
            else
            {
                return false;
            }
        }catch(SQLException slex){
            System.out.println(slex);
        }finally{
         
        }

       if(numeroFilas >= 1 )
       {
           return true;
       }
       else
       {
           return false;
       }

}   
    
}
