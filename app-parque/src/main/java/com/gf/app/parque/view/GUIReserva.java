/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.gf.app.parque.view;

import com.gf.app.parque.entities.Menu;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

/**
 *
 * @author noelp
 */
public class GUIReserva extends javax.swing.JFrame {

    private Dimension tamPantalla = Toolkit.getDefaultToolkit().getScreenSize();

    private JPanel panelOpciones;
    private JPanel panelBotones;
    private JPanel panelCentrar;

    private final String[] textosCampos = {"Nombre: ", "Fecha: ", "Numero de participantes: ", "Menu: ", "Sala: ", "Es cumple: "};

    private JTextField nombreEvento;
    //fecha
    UtilDateModel modelo = new UtilDateModel();
    private JDatePanelImpl panelDate = new JDatePanelImpl(modelo, new Properties());
    private JDatePickerImpl panelPicker = new JDatePickerImpl(panelDate, new DateComponentFormatter());
    //mas movidas
    private JTextField numeroParticipantes;
    private JComboBox<Menu> opcionesMenu = new JComboBox<>();
    private JComboBox<String> opcionesSala = new JComboBox<>();
    private JCheckBox checkIsCumple;
    
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
        panelCentrar = new JPanel(new GridLayout(6, 0));
        setTFNombreField();
        setPickerFechaField();
        setTFNumeroParticipantes();
        setComboOpcionMenu();
        setComboNumeroSala();
        setRadioIsCumple();
        panelOpciones.add(panelCentrar, BorderLayout.SOUTH);
        this.getContentPane().add(panelOpciones);
    }

    private void setTFNombreField() {
        nombreEvento = new JTextField();
        nombreEvento.setPreferredSize(new Dimension(200, 30));
        JPanel panelExtra = new JPanel(new GridLayout(0, 2));
        JLabel texto = new JLabel(textosCampos[0]);
        texto.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel panelTF = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelExtra.add(texto);
        panelTF.add(nombreEvento);
        //panelTF.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        panelExtra.add(panelTF);
        panelCentrar.add(panelExtra);
    }

    private void setPickerFechaField() {
        JPanel panelExtra = new JPanel(new GridLayout(0, 2));
        JLabel texto = new JLabel(textosCampos[1]);
        texto.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel panelTF = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelExtra.add(texto);
        panelTF.add(panelPicker);
        //panelTF.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        panelExtra.add(panelTF);
        panelCentrar.add(panelExtra);
    }

    private void setTFNumeroParticipantes() {
        numeroParticipantes = new JTextField();
        numeroParticipantes.setPreferredSize(new Dimension(200, 30));
        JPanel panelExtra = new JPanel(new GridLayout(0, 2));
        JLabel texto = new JLabel(textosCampos[2]);
        texto.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel panelTF = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelExtra.add(texto);
        panelTF.add(numeroParticipantes);
        //panelTF.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        panelExtra.add(panelTF);
        panelCentrar.add(panelExtra);
    }

    private void setComboOpcionMenu() {
        JPanel panelExtra = new JPanel(new GridLayout(0, 2));
        JLabel texto = new JLabel(textosCampos[3]);
        texto.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel panelTF = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelExtra.add(texto);
        panelTF.add(opcionesMenu);
        //panelTF.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        panelExtra.add(panelTF);
        panelCentrar.add(panelExtra);
    }

    private void setComboNumeroSala() {
        JPanel panelExtra = new JPanel(new GridLayout(0, 2));
        JLabel texto = new JLabel(textosCampos[4]);
        texto.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel panelTF = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelExtra.add(texto);
        panelTF.add(opcionesSala);
        //panelTF.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        panelExtra.add(panelTF);
        panelCentrar.add(panelExtra);
    }

    private void setRadioIsCumple() {
        checkIsCumple = new JCheckBox();
        JPanel panelExtra = new JPanel(new GridLayout(0, 2));
        JLabel texto = new JLabel(textosCampos[5]);
        texto.setHorizontalAlignment(SwingConstants.RIGHT);
        JPanel panelTF = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelExtra.add(texto);
        panelTF.add(checkIsCumple);
        //panelTF.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        panelExtra.add(panelTF);
        panelCentrar.add(panelExtra);
    }

    private void setButtons() {
        cancelarBut = new JButton("Cancelar");
        aceptarBut = new JButton("Aceptar");
        panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
        this.getContentPane().add(panelBotones);
        panelBotones.add(aceptarBut);
        panelBotones.add(cancelarBut);
    }

    public JTextField getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(JTextField nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public UtilDateModel getModelo() {
        return modelo;
    }

    public void setModelo(UtilDateModel modelo) {
        this.modelo = modelo;
    }

    public JComboBox<Menu> getOpcionesMenu() {
        return opcionesMenu;
    }

    public void setOpcionesMenu(JComboBox<Menu> opcionesMenu) {
        this.opcionesMenu = opcionesMenu;
    }

    public JTextField getNumeroParticipantes() {
        return numeroParticipantes;
    }

    public void setNumeroParticipantes(JTextField numeroParticipantes) {
        this.numeroParticipantes = numeroParticipantes;
    }

    public JComboBox<String> getOpcionesSala() {
        return opcionesSala;
    }

    public void setOpcionesSala(JComboBox<String> opcionesSala) {
        this.opcionesSala = opcionesSala;
    }

    public JCheckBox getCheckIsCumple() {
        return checkIsCumple;
    }

    public void setCheckIsCumple(JCheckBox checkIsCumple) {
        this.checkIsCumple = checkIsCumple;
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
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
//        </editor-fold>
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
