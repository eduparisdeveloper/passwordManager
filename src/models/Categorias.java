/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;


/**
 *
 * @author 34681
 */
public class Categorias {
    private int id;
    private String nombreCategoria;
    

    public Categorias(int id, String nombreCategoria) throws SQLException {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
        
    }
    public Categorias()
    {
       
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
    
    public static ArrayList<String>  AllCategorias() throws SQLException
    {
        conexion conexion = new conexion();
        Connection con = conexion.conectionBBDD();
        
        ArrayList<String> categorias = new ArrayList<String>();
        ResultSet rs = null;

    try{
    PreparedStatement ps = con.prepareStatement("SELECT nombre from categoria ");


            ps.executeQuery();
            rs = ps.executeQuery();
            if(rs != null)
            {
                while(rs.next())
                {
                    categorias.add(rs.getString("nombre")); 
                }            
                ps.close();
                rs.close();
                con.close();

            }
            else
            {
            
            }
        }catch(SQLException slex){
            System.out.println(slex);
        }finally{
         
        }
        return categorias;
    }

}
