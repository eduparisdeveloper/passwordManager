/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import views.vLogin;

/**
 *
 * @author 34681
 */
public class Usuario {
    private String nombreUsuario;
    private String password;

    public Usuario(String nombreUsuario, String password) {
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public static boolean comprobarAdmin(String nombre )
    {
        int numeroFilas = 0;
        ResultSet rs = null;
    
        conexion conecta = new conexion();
        Connection con = null;
        
        try{
                con = conecta.conectionBBDD();
            } catch (SQLException ex) {
                Logger.getLogger(vLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

        try{
                PreparedStatement ps = con.prepareStatement("SELECT usuarios.* FROM usuarios where usuarios.nombre_manager=? and usuarios.rol='admin'");
                ps.setString(1, nombre);

                ps.executeQuery();
                rs = ps.executeQuery();
                if(rs != null)
                {
                    while(rs.next())
                    {
                        System.out.println(rs.getString("nombre_manager") + " " + rs.getString("rol"));
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
            }
            catch(SQLException slex)
            {
                System.out.println(slex);
            }

       if(numeroFilas >= 1 )
       {
           System.out.println("Tenemos un admin");
           return true;
       }
       else
       {
           System.out.println("No es un admin");
           return false;
       }
    }
    
    
}
