/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gf.app.parque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author noelp
 */
public class GUILogin extends javax.swing.JFrame {

    private Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();

    private JPanel panelBotones;
    private JPanel panelTextFields;

    private JTextField textFdni;
    private JPasswordField textFPassword;

    private JButton cancelarBut;
    private JButton aceptarBut;

    /**
     * Creates new form GUILogin
     */
    public GUILogin() {
        initComponents();
        setFrame();
    }

    private void setFrame() {
        this.setTitle("Acceder");
        this.setSize(tamPantalla);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setLayout(new GridLayout(2, 1));
        setTextFields();
        setButtons();
    }

    private void setTextFields() {
        //va un poco mejor pero no me acaba de convencer
        textFdni = new JTextField();
        textFPassword = new JPasswordField();
        textFdni.setPreferredSize(new Dimension(200, 30));
        textFPassword.setPreferredSize(new Dimension(200, 30));
        panelTextFields = new JPanel(new BorderLayout());
        GridLayout gl = new GridLayout(2, 2, 5, 20);
        JPanel panelExtra = new JPanel(gl);
        JLabel nombre = new JLabel("Nombre: ");
        nombre.setHorizontalAlignment(SwingConstants.RIGHT);
        panelExtra.add(nombre);
        JPanel panelTF1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTF1.add(textFdni);
        panelExtra.add(panelTF1);
        JLabel contra = new JLabel("Contraseña: ");
        contra.setHorizontalAlignment(SwingConstants.RIGHT);
        panelExtra.add(contra);
        JPanel panelTF2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTF2.add(textFPassword);
        panelExtra.add(panelTF2);
        panelTextFields.add(panelExtra, BorderLayout.SOUTH);
        this.getContentPane().add(panelTextFields);
    }

    private void setButtons() {
        cancelarBut = new JButton("Cancelar");
        aceptarBut = new JButton("Aceptar");
        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
        this.getContentPane().add(panelBotones);
        panelBotones.add(aceptarBut);
        panelBotones.add(cancelarBut);
    }

    public JTextField getTextFdni() {
        return textFdni;
    }

    public void setTextFdni(JTextField textFdni) {
        this.textFdni = textFdni;
    }

    public JPasswordField getTextFPassword() {
        return textFPassword;
    }

    public void setTextFPassword(JPasswordField textFPassword) {
        this.textFPassword = textFPassword;
    }

    public JButton getCancelarBut() {
        return cancelarBut;
    }

    public void setCancelarBut(JButton cancelarBut) {
        this.cancelarBut = cancelarBut;
    }

    public JButton getAceptarBut() {
        return aceptarBut;
    }

    public void setAceptarBut(JButton aceptarBut) {
        this.aceptarBut = aceptarBut;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUILogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUILogin().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
