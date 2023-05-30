/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gf.app.parque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author noelp
 */
public class GUIReserva extends javax.swing.JFrame {

    private Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();

    private JPanel panelOpciones;
    private JPanel panelBotones;

    private String[] textosCampos = {"Nombre: ", "Fecha: ", "Numero de participantes: ", "Menu: ", "Sala: "};
    private List<JTextField> camposReserva = new ArrayList<>();

    private JButton cancelarBut;
    private JButton aceptarBut;

    /**
     * Creates new form GUIReserva
     */
    public GUIReserva() {
        initComponents();
        setFrame();
    }

    private void setFrame() {
        this.setTitle("Reservar");
        this.setSize(tamPantalla);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setLayout(new GridLayout(2, 1));
        setTextFields();
        setButtons();
    }

    private void setTextFields() {
        panelOpciones = new JPanel(new BorderLayout());
        JPanel panelExtra = new JPanel(new GridLayout(textosCampos.length, 2, 5, 20));
        for (String textoCampo : textosCampos) {
            JTextField tf = new JTextField();
            tf.setPreferredSize(new Dimension(400, 30));
            JLabel texto = new JLabel(textoCampo);
            texto.setHorizontalAlignment(SwingConstants.RIGHT);
            JPanel panelTF = new JPanel(new FlowLayout(FlowLayout.LEFT));
            panelExtra.add(texto);
            panelTF.add(tf);
            panelExtra.add(panelTF);
            camposReserva.add(tf);
        }
        panelOpciones.add(panelExtra, BorderLayout.SOUTH);
        this.getContentPane().add(panelOpciones);
    }

    private void setButtons() {
        cancelarBut = new JButton("Cancelar");
        aceptarBut = new JButton("Aceptar");
        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
        this.getContentPane().add(panelBotones);
        panelBotones.add(aceptarBut);
        panelBotones.add(cancelarBut);
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
//            java.util.logging.Logger.getLogger(GUIReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(GUIReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(GUIReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(GUIReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GUIReserva().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
