/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Base64;

import java.io.UnsupportedEncodingException;



/**
 *
 * @author 34681
 */
public class Password {
    private int id;
    private String contraseña;
    private int id_categoria;
    
    
    private String Alcode(String pass) throws UnsupportedEncodingException
    {
        return Base64.getEncoder().encodeToString(pass.getBytes("utf-8"));
    }
    
    private String exCode(String pass) throws UnsupportedEncodingException
    {
        byte[] decode = Base64.getDecoder().decode(pass.getBytes());
        
        return new String (decode, "utf-8");
    }
    
    
    
    
}
