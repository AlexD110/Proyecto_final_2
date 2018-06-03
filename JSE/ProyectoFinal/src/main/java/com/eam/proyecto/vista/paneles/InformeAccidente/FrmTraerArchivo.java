/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.vista.paneles.InformeAccidente;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Daryl Ospina
 */
public class FrmTraerArchivo extends java.awt.Dialog {
    
    private File direccionArchivo;
    
    public FrmTraerArchivo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG & PNG","jpg","png");
        this.flArchivo.setFileFilter(filtroImagen);
    }

    public File getDireccionArchivo() {
        return direccionArchivo;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        flArchivo = new javax.swing.JFileChooser();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        flArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                flArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(flArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(flArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
        );

        add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void flArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_flArchivoActionPerformed
        String comando = evt.getActionCommand();
        if (comando.equals(JFileChooser.APPROVE_SELECTION)) {
            this.direccionArchivo = this.flArchivo.getSelectedFile();
            this.dispose();
        }else if (comando.equals(JFileChooser.CANCEL_SELECTION)) {
            this.dispose();
        }
    }//GEN-LAST:event_flArchivoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser flArchivo;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
