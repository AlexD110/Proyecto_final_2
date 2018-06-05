package com.eam.proyecto.vista.paneles.InformeAccidente;

import com.eam.proyecto.controlador.CtlPersona;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author Daryl Ospina
 */
public class FrmAccidente_Perjudicados_Testigos extends java.awt.Dialog {

    private final CtlPersona controladorPersona;
    private final JFrame padre;
    private final int tipoFrm;
    private final int idPerteneciente;

    public FrmAccidente_Perjudicados_Testigos(JFrame parent, boolean modal, int idPerteneciente, int tipoFrm) {
        super(parent, modal);
        initComponents();

        this.padre = parent;
        this.tipoFrm = tipoFrm;
        this.idPerteneciente = idPerteneciente;
        this.controladorPersona = new CtlPersona();

        if (this.tipoFrm == 0) {
            this.lblTitulo.setText("Añadir Perjudicados");
            this.lblTituloTabla.setText("Perjudicados");
            this.tblPerjidicadosTestigos.setModel(this.controladorPersona.listarPerjudicados(idPerteneciente));
        } else {
            this.lblTitulo.setText("Añadir Testigos");
            this.lblTituloTabla.setText("Testigos");
            this.tblPerjidicadosTestigos.setModel(this.controladorPersona.listarTestigos(idPerteneciente));
        }


        this.listarPersonas();
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPersonas = new javax.swing.JTable();
        lblTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPerjidicadosTestigos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnAniadirPerjudicadoTestigo = new javax.swing.JButton();
        btnTerminarAnexo = new javax.swing.JButton();
        lblTituloTabla = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtBuscarPersona = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(1, 20, 30));

        jPanel3.setBackground(new java.awt.Color(5, 117, 154));

        tblPersonas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(tblPersonas);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
        );

        lblTitulo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Texto");

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Personas");

        jPanel1.setBackground(new java.awt.Color(5, 117, 154));

        tblPerjidicadosTestigos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblPerjidicadosTestigos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(1, 20, 30));

        btnAniadirPerjudicadoTestigo.setText(">>");
        btnAniadirPerjudicadoTestigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirPerjudicadoTestigoActionPerformed(evt);
            }
        });

        btnTerminarAnexo.setText("Terminar");
        btnTerminarAnexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarAnexoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnTerminarAnexo)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnAniadirPerjudicadoTestigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAniadirPerjudicadoTestigo)
                .addGap(18, 18, 18)
                .addComponent(btnTerminarAnexo)
                .addGap(181, 181, 181))
        );

        lblTituloTabla.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloTabla.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTituloTabla.setText("texto");

        jPanel4.setBackground(new java.awt.Color(5, 117, 154));

        txtBuscarPersona.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarPersonaKeyReleased(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscador");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarPersona)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtBuscarPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTituloTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lblTitulo)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblTituloTabla))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void txtBuscarPersonaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarPersonaKeyReleased
        if (this.txtBuscarPersona.getText().trim().isEmpty()) {
            this.listarPersonas();
        }else{
            Map<String, String> campos = new HashMap<>();
            campos.put("Nip", this.txtBuscarPersona.getText());
            campos.put("Nombre_completo", this.txtBuscarPersona.getText());
            campos.put("Fecha_nacimiento", this.txtBuscarPersona.getText());
            campos.put("Direccion", this.txtBuscarPersona.getText());
            campos.put("Eps", this.txtBuscarPersona.getText());
            campos.put("Telefono", this.txtBuscarPersona.getText());
            campos.put("Placa_agente", this.txtBuscarPersona.getText());
            this.tblPersonas.setModel(this.controladorPersona.listarFiltrado(campos));
        }
    }//GEN-LAST:event_txtBuscarPersonaKeyReleased

    private void btnAniadirPerjudicadoTestigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirPerjudicadoTestigoActionPerformed
        if (this.tblPersonas.getSelectedRow() >= 0) {
            String nipPersona = this.tblPersonas.getValueAt(this.tblPersonas.getSelectedRow(), 2).toString();
            if (this.tipoFrm == 0) {
                FrmRegistroPerjudicado ventanaPerjudicado = new FrmRegistroPerjudicado(this.padre, true, this.tblPerjidicadosTestigos, nipPersona,this.idPerteneciente);
                ventanaPerjudicado.setLocationRelativeTo(null);
                ventanaPerjudicado.setVisible(true);
            } else {
                FrmRegistroTestigo ventanaTestigo = new FrmRegistroTestigo(this.padre, true, this.tblPerjidicadosTestigos, nipPersona, this.idPerteneciente);
                ventanaTestigo.setLocationRelativeTo(null);
                ventanaTestigo.setVisible(true);
            }
        }else{
            if (this.tipoFrm == 0) {
                JOptionPane.showMessageDialog(this.padre, "Debe seleccionar una persona de la tabla de personas para poder añadirla como perjudicada");
            }else{
                JOptionPane.showMessageDialog(this.padre, "Debe seleccionar una persona de la tabla de personas para poder añadirla como testigo");
            }
        }
    }//GEN-LAST:event_btnAniadirPerjudicadoTestigoActionPerformed

    private void btnTerminarAnexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarAnexoActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnTerminarAnexoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadirPerjudicadoTestigo;
    private javax.swing.JButton btnTerminarAnexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTituloTabla;
    private javax.swing.JTable tblPerjidicadosTestigos;
    private javax.swing.JTable tblPersonas;
    private javax.swing.JTextField txtBuscarPersona;
    // End of variables declaration//GEN-END:variables

    private void listarPersonas() {
        this.tblPersonas.setModel(this.controladorPersona.listar("Persona"));
    }
}
