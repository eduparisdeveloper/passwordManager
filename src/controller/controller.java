/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JFrame;
import javax.swing.JPanel;
import views.vLogin;

/**
 *
 * @author 34681
 */
public class controller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       vLogin ventana = new vLogin();
       ventana.setTitle("Ventana");
       ventana.setVisible(true);
    }
    

    
}
