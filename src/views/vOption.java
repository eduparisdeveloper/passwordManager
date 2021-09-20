/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.event.WindowAdapter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;
import views.vManager;

/**
 *
 * @author 34681
 */
public class vOption extends javax.swing.JFrame {
    private vLogin log;
    private String nombreUsuario;
    private boolean admin = false;
    private vManager manager;
    private vNewUser user;
    /**
     * Creates new form vOption
     */
    public vOption( ) throws SQLException {
        
        initComponents();
        
        

        manager = new vManager();
        manager.pasarLogin(this);
        user = new vNewUser();
    }
    
    public void pasarLogin(vLogin login, String nombre)
    {
      this.setLog(login);
      this.setNombreUsuario(nombre);

      if( Usuario.comprobarAdmin(nombre) )
      {
          this.admin = true;
          bNewUser.setEnabled(true);
      }

      
    }

    public vLogin getLog() {
        return log;
    }

    public void setLog(vLogin log) {
        this.log = log;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGestion = new javax.swing.JButton();
        bNewUser = new javax.swing.JButton();
        bExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bGestion.setText("Gestion");
        bGestion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bGestionMouseClicked(evt);
            }
        });
        bGestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGestionActionPerformed(evt);
            }
        });

        bNewUser.setText("Añadir usuarios");
        bNewUser.setEnabled(false);
        bNewUser.setFocusable(false);
        bNewUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bNewUserMouseClicked(evt);
            }
        });
        bNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bNewUserActionPerformed(evt);
            }
        });

        bExit.setText("exit");
        bExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bExitMouseClicked(evt);
            }
        });
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(bGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 121, Short.MAX_VALUE)
                .addComponent(bNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bNewUser, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bGestion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bGestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bGestionActionPerformed

    private void bNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bNewUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bNewUserActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bExitActionPerformed

    private void bGestionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bGestionMouseClicked
        manager.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bGestionMouseClicked

    private void bExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bExitMouseClicked
        log.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_bExitMouseClicked

    private void bNewUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bNewUserMouseClicked
      if( admin == true )
      {
        user.setVisible(true);
        this.setVisible(false);
      
      }
    }//GEN-LAST:event_bNewUserMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(vOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new vOption().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(vOption.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bExit;
    private javax.swing.JButton bGestion;
    private javax.swing.JButton bNewUser;
    // End of variables declaration//GEN-END:variables
}
