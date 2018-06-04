package com.eam.proyecto.vista.paneles.InformeAccidente;

import com.eam.proyecto.controlador.CtlComboBox;
import com.eam.proyecto.controlador.CtlInformeAccidente;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 * @author Daryl Ospina
 */
public class pnlAccidente extends javax.swing.JPanel {

    private final JFrame padre;
    private final CtlComboBox controladorComboBox;
    private File croquis;
    private int idInforme;
    private final CtlInformeAccidente controladorAccidente;

    public pnlAccidente(JFrame parent) {
        initComponents();
        this.padre = parent;
        this.controladorComboBox = new CtlComboBox();
        this.llenarLista();
        this.controladorAccidente = new CtlInformeAccidente();
        this.listarInformes();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtFechaAccidente = new com.toedter.calendar.JDateChooser();
        cbGravedadAccidente = new javax.swing.JComboBox<>();
        cbClaseAccidente = new javax.swing.JComboBox<>();
        cbChoqueCon = new javax.swing.JComboBox<>();
        cbObjetoFijo = new javax.swing.JComboBox<>();
        spnHeridos = new javax.swing.JSpinner();
        spnMuertos = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cbAreaAccidente = new javax.swing.JComboBox<>();
        cbSectorAccidente = new javax.swing.JComboBox<>();
        cbZonaAccidente = new javax.swing.JComboBox<>();
        cbDisenioAccidente = new javax.swing.JComboBox<>();
        cbTiempoAccidente = new javax.swing.JComboBox<>();
        txtCoordenadaX = new javax.swing.JTextField();
        txtCoordenadaY = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtDireccionAccidente = new javax.swing.JTextField();
        txtLocalidadComunaAccidente = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        cbCaract1 = new javax.swing.JComboBox<>();
        cbCaract2 = new javax.swing.JComboBox<>();
        cbCaract3 = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        cbUtilizacion = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        cbCalzada = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        cbCarril = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        cbMaterial = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        cbCondicion = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        cbIluminacion = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtAgente = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstAgentes = new javax.swing.JList<>();
        btnAniadirCroquis = new javax.swing.JButton();
        txtCroquis = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        btnAniadirVehiculos = new javax.swing.JButton();
        btnAniadirTestigos = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInformeAccidente = new javax.swing.JTable();
        txtBusqueda = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        cbDisminucion = new javax.swing.JComboBox<>();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cbSemaforo = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        cbDemarcacion = new javax.swing.JComboBox<>();
        txtSenial = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtDisminucionVisual = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtDemarcacion = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        btnPasarAEditar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnTerminarAnexos = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        btnRegistrar = new javax.swing.JButton();

        jLabel16.setText("jLabel16");

        jPanel4.setBackground(new java.awt.Color(1, 20, 30));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Informes de Accidentes");

        jPanel1.setBackground(new java.awt.Color(5, 117, 154));

        cbGravedadAccidente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un tipo de graveda", "Con muertos", "Con heridos", "Solo daños" }));

        cbClaseAccidente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una clase del accidente", "Choque", "Atropello", "Volcamiento", "Caida ocupante", "Incendio", "Otro" }));

        cbChoqueCon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un item", "Vehiculo", "Tren", "Semoviente", "Objeto fijo" }));

        cbObjetoFijo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el objeto fijo", "Muro", "Poste", "Arbol", "Baranda", "Inmueble", "Hidrante", "Valla", "Señal", "Tarima", "Caseta", "Vehiculo estacionado" }));

        spnHeridos.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        spnMuertos.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Fecha del accidente:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tipo de gravedad de accidente:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Clase de accidente:");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Choque con:");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Objeto fijo:");

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Numero de heridos:");

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Numero de muertos:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaAccidente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbClaseAccidente, 0, 264, Short.MAX_VALUE)
                    .addComponent(cbChoqueCon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbObjetoFijo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbGravedadAccidente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnHeridos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnMuertos, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFechaAccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbGravedadAccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbClaseAccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbChoqueCon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbObjetoFijo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnHeridos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnMuertos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(5, 117, 154));

        cbAreaAccidente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un area", "Urbana", "Rural" }));

        cbSectorAccidente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un sector", "Residencial", "Industrial", "Comercial" }));

        cbZonaAccidente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una zona", "Escolar", "Militar", "Deportiva" }));

        cbDisenioAccidente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una diseño", "Tramo de via", "Intercepcion", "Via peatonal", "Paso elevado", "Paso inferior", "Paso a nivel", "Glorieta", "Puente", "Via troncal", "Lote o predio", "Cicloruta" }));

        cbTiempoAccidente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el tiempo", "Normal", "Lluvia", "Viento", "Niebla" }));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Area del accidente:");

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Sector del accidente:");

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Zona del accidente:");

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Diseño del Lugar del accidente:");

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Tiempo del lugar del accidente:");

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Coordenada X del accidente:");

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Coordenada Y del accidente:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbAreaAccidente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbSectorAccidente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbZonaAccidente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbDisenioAccidente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbTiempoAccidente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtCoordenadaX)
                    .addComponent(txtCoordenadaY)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbAreaAccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSectorAccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbZonaAccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDisenioAccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbTiempoAccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCoordenadaX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCoordenadaY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(5, 117, 154));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Direccion del lugar del accidente:");

        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Localidad/Comuna del accidente:");

        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Caracteristicas geometricas:");

        cbCaract1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la geometria 1", "RECTA VIA 1", "RECTA VIA 2", "CURVA VIA 1", "CURVA VIA 2" }));

        cbCaract2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la geometria 2", "PLANO  VIA 1", "PLANO VIA 2", "PENDIENTE VIA 1", "PENDIENTE VIA 2 " }));

        cbCaract3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la geometria 3", "CON VERNAS  VIA 1", "CON VERNAS VIA 2", "SIN BERNAS VIA 1", "SIN BERNAS VIA 2" }));

        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Caracteristicas de la via");

        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Utilización de la via:");

        cbUtilizacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la utilización de la via", "UN SENTIDO VIA 1", "UN SENTIDO VIA 2", "DOBLE SENTIDO VIA 1", "DOBLE SENTIDO VIA 2", "REVERSIBLE VIA 1", "REVERSIBLE VIA 2", "CICLOVIA VIA 1", "CICLOVIA VIA 2" }));

        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Calzada:");

        cbCalzada.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la calzada", "UNA VIA 1", "UNA VIA 2", "DOS VIA 1", "DOS VIA 2", "TRES VIA 1", "TRES VIA 2", "CUATRO O MAS VIA 1", "CUATRO O MAS VIA 2", "VARIABLE VIA 1", "VARIABLE VIA 2" }));

        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Carril:");

        cbCarril.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el carril", "UNA VIA 1", "UNA VIA 2", "DOS VIA 1", "DOS VIA 2", "TRES VIA 1", "TRES VIA 2", "CUATRO O MAS VIA 1", "CUATRO O MAS VIA 2", "VARIABLE VIA 1", "VARIABLE VIA 2" }));

        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Material de la via:");

        cbMaterial.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el material de la via", "ASALTO VIA 1", "ASFALTO VIA 2", "CONCRETO VIA 1", "CONCRETO VIA 2", "AFIRMADO VIA 1", "AFIRMADO VIA 2", "TIRRRA VIA 1", "TIERRA VIA 2" }));

        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Estado de la via:");

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el estado de la via", "BUENO VIA 1", "BUENO VIA 2", "CON HUECOS VIA 1", "CON HUECOS VIA 2", "EN REPARACION VIA 1", "EN REPARACION VIA 2", "HUNDIMIENTOS VIA 1", "HUNDIMIENTOIS VIA 2", "DERRUMBES VIA 1", "DERRUMBES VIA 2", "PARCHAO VIA 1", "PARCHADO VIA 2", "RIZADO VIA 1", "RIZADO VIA 2", "INUNDA VIA 1", "INUNDA VIA2" }));

        cbCondicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione condición de la via", "SECA VIA 1", "SECA VIA 2", "HUMEDA VIA 1", "HUMEDA VIA 2", "MATERIAL SUELTO VIA 1", "MATERIAL SUELTO VIA 2", "ACEITE VIA 1", "ACEITE VIA 2" }));

        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Condición de la via:");

        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Iluminación de la via:");

        cbIluminacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la iluminación de la via", "CON VIA 1", "CON VIA 2", "SIN VIA 1", "SIN VIA 2", "BUENA VIA 1", "BUENA VIA 2", "MALA VIA 1", "MALA VIA 2" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDireccionAccidente)
                    .addComponent(txtLocalidadComunaAccidente)
                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCaract1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCaract2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCaract3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbUtilizacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCalzada, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCarril, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbMaterial, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbCondicion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbIluminacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26)
                            .addComponent(jLabel27)
                            .addComponent(jLabel28))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDireccionAccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalidadComunaAccidente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCaract1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCaract2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCaract3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbUtilizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCalzada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCarril, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCondicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbIluminacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(5, 117, 154));

        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Agente Responsable del Informe:");

        txtAgente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAgenteKeyReleased(evt);
            }
        });

        lstAgentes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAgentesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(lstAgentes);

        btnAniadirCroquis.setText("Añadir");
        btnAniadirCroquis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirCroquisActionPerformed(evt);
            }
        });

        txtCroquis.setEditable(false);

        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Añadir Corquis de accidente:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAgente)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel35))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtCroquis, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAniadirCroquis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtAgente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAniadirCroquis)
                    .addComponent(txtCroquis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(5, 117, 154));

        btnAniadirVehiculos.setText("Añadir Vehiculo Afectado");
        btnAniadirVehiculos.setEnabled(false);
        btnAniadirVehiculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirVehiculosActionPerformed(evt);
            }
        });

        btnAniadirTestigos.setText("Añadir Testigos del Accidente");
        btnAniadirTestigos.setEnabled(false);
        btnAniadirTestigos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirTestigosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAniadirVehiculos, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAniadirTestigos, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAniadirVehiculos)
                    .addComponent(btnAniadirTestigos))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(5, 117, 154));

        tblInformeAccidente.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblInformeAccidente);

        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyReleased(evt);
            }
        });

        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Buscador");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addComponent(txtBusqueda, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel36)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(5, 117, 154));

        cbDisminucion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la disminución visual de la via", "VEHICULO ESTACIONADO VIA 1", "VEHICULO ESTACIONADO VIA 2", "VEGETACION VIA 1", "VEGETACION VIA 2", "CONSTRUCCION VIA 1", "CONSTRUCCION VIA 2", "AVISO VIA 1", "AVISO VIA 2", "POSTE VIA 1", "POSTE VIA 2", "OTROS" }));
        cbDisminucion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDisminucionActionPerformed(evt);
            }
        });

        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Disminución visual de la via:");

        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Semaforo de la via:");

        cbSemaforo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un item", "OPERANDO VIA 1", "OPERANDO VIA 2", "INTERMITENTE VIA 1", "INTERMITENTE VIA 2", "CON DAÑOS VIA 1", "SIN DAÑOS VIA 2", "APAGADO VIA 1", "APAGADO VIA 2" }));

        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Señale de la via:");

        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Demarcación de la via:");

        cbDemarcacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la demarcación de la via", "ZONA PEATONAL VIA 1", "ZONA PEATONAL VIA 2", "LIENA PADRE VIA 1", "LIENA PADRE VIA 2", "LINEA CENTRAL VIA 1", "LINEA CENTRAL VIA 2", "LINEA DE BORDE VIA 2", "LINEA DE BORDE VIA 1", "LINEA DE CARRIL VIA 1", "LINEA DE CARRIL VIA 2", "OTRA" }));
        cbDemarcacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDemarcacionActionPerformed(evt);
            }
        });

        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Escriba cual diminución de la via:");

        txtDisminucionVisual.setEditable(false);

        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Escriba la demarcación de la via:");

        txtDemarcacion.setEditable(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbDisminucion, 0, 0, Short.MAX_VALUE)
                    .addComponent(txtDisminucionVisual)
                    .addComponent(cbSemaforo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSenial)
                    .addComponent(cbDemarcacion, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDemarcacion)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29)
                            .addComponent(jLabel33)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel34))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDisminucion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDisminucionVisual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbSemaforo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel31)
                .addGap(5, 5, 5)
                .addComponent(txtSenial, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbDemarcacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel34)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDemarcacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(5, 117, 154));

        btnPasarAEditar.setText("Pasar a editar");
        btnPasarAEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarAEditarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnTerminarAnexos.setText("Terminar Anexos");
        btnTerminarAnexos.setEnabled(false);
        btnTerminarAnexos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarAnexosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPasarAEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTerminarAnexos, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPasarAEditar)
                    .addComponent(btnModificar)
                    .addComponent(btnTerminarAnexos))
                .addContainerGap())
        );

        jPanel10.setBackground(new java.awt.Color(5, 117, 154));

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRegistrar)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAniadirVehiculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirVehiculosActionPerformed
        if (this.idInforme != 0) {
            FrmAccidente_VehiculoAfectado ventanaVehiculo = new FrmAccidente_VehiculoAfectado(padre, true, this.idInforme);
            ventanaVehiculo.setLocationRelativeTo(null);
            ventanaVehiculo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Hay un error con el informe. por favor contacte a el administrador");
        }
    }//GEN-LAST:event_btnAniadirVehiculosActionPerformed

    private void btnAniadirTestigosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirTestigosActionPerformed
        if (this.idInforme != 0) {
            FrmAccidente_Perjudicados_Testigos ventanaTestigos = new FrmAccidente_Perjudicados_Testigos(padre, true, this.idInforme, 1);
            ventanaTestigos.setLocationRelativeTo(null);
            ventanaTestigos.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Hay un error con el informe. por favor contacte a el administrador");
        }
    }//GEN-LAST:event_btnAniadirTestigosActionPerformed

    private void lstAgentesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAgentesMouseClicked
        this.txtAgente.setText(this.lstAgentes.getSelectedValue());
    }//GEN-LAST:event_lstAgentesMouseClicked

    private void txtAgenteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAgenteKeyReleased
        if (!(this.txtAgente.getText().isEmpty())) {
            this.controladorComboBox.modeloListaFiltrado(this.lstAgentes, this.txtAgente.getText().toUpperCase().trim());
        } else {
            this.llenarLista();
        }
    }//GEN-LAST:event_txtAgenteKeyReleased

    private void cbDisminucionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDisminucionActionPerformed
        if (this.cbDisminucion.getSelectedIndex() == 11) {
            this.txtDisminucionVisual.setEditable(true);
        } else {
            this.txtDisminucionVisual.setEditable(false);
        }
    }//GEN-LAST:event_cbDisminucionActionPerformed

    private void cbDemarcacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDemarcacionActionPerformed
        if (this.cbDemarcacion.getSelectedIndex() == 11) {
            this.txtDemarcacion.setEditable(true);
        } else {
            this.txtDemarcacion.setEditable(false);
        }
    }//GEN-LAST:event_cbDemarcacionActionPerformed

    private void btnAniadirCroquisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirCroquisActionPerformed
        FrmTraerArchivo ventanaArchivo = new FrmTraerArchivo(this.padre, true);
        ventanaArchivo.setLocationRelativeTo(null);
        ventanaArchivo.setVisible(true);
        try {
            this.croquis = ventanaArchivo.getDireccionArchivo();
            this.txtCroquis.setText(croquis.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("[Información] : no se ha cargado nada");
        }
    }//GEN-LAST:event_btnAniadirCroquisActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (this.txtFechaAccidente.getDate() == null || this.cbGravedadAccidente.getSelectedIndex() == 0
                || this.cbClaseAccidente.getSelectedIndex() == 0 || this.cbChoqueCon.getSelectedIndex() == 0
                || this.cbObjetoFijo.getSelectedIndex() == 0 || Integer.parseInt(this.spnHeridos.getValue().toString()) < 0
                || Integer.parseInt(this.spnMuertos.getValue().toString()) < 0 || this.cbAreaAccidente.getSelectedIndex() == 0
                || this.cbSectorAccidente.getSelectedIndex() == 0 || this.cbZonaAccidente.getSelectedIndex() == 0
                || this.cbDisenioAccidente.getSelectedIndex() == 0 || this.cbTiempoAccidente.getSelectedIndex() == 0
                || this.txtDireccionAccidente.getText().trim().isEmpty() || this.txtLocalidadComunaAccidente.getText().trim().isEmpty()
                || this.cbCaract1.getSelectedIndex() == 0 || this.cbCaract2.getSelectedIndex() == 0 || this.cbCaract3.getSelectedIndex() == 0
                || this.cbUtilizacion.getSelectedIndex() == 0 || this.cbCalzada.getSelectedIndex() == 0 || this.cbCarril.getSelectedIndex() == 0
                || this.cbMaterial.getSelectedIndex() == 0 || this.cbEstado.getSelectedIndex() == 0
                || this.cbIluminacion.getSelectedIndex() == 0 || this.txtAgente.getText().trim().isEmpty() || this.cbDisminucion.getSelectedIndex() == 0
                || (this.cbDisminucion.getSelectedIndex() == 11 && this.txtDisminucionVisual.getText().trim().isEmpty())
                || this.cbSemaforo.getSelectedIndex() == 0 || this.txtSenial.getText().trim().isEmpty() || this.cbDemarcacion.getSelectedIndex() == 0
                || (this.cbDemarcacion.getSelectedIndex() == 11 && this.txtDemarcacion.getText().trim().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Por favor llene los campos requeridos (*)");
        } else {

            Date fechaAccidente;
            String tipoGravedad, claseAccidente, choqueCon, objetoFijo, areaAccidente, sectorAccidente, zonaAccidente, disenioAccidente,
                    tiempo, coordenadaX = null, coordenadaY = null, direccionAccidente, LocalidadComunaAccidente, carac1, carac2, carac3, utilizacion,
                    calzada, carril, material, estado, condicion = null, ilumunacion, nipAgente, disminucion, semaforo, senial,
                    demarcacion;
            int numHeridos, numMuertos, id = this.controladorAccidente.id();

            fechaAccidente = this.txtFechaAccidente.getDate();
            tipoGravedad = this.cbGravedadAccidente.getSelectedItem().toString().trim();
            claseAccidente = this.cbClaseAccidente.getSelectedItem().toString().trim();
            choqueCon = this.cbChoqueCon.getSelectedItem().toString().trim();
            objetoFijo = this.cbObjetoFijo.getSelectedItem().toString().trim();
            areaAccidente = this.cbAreaAccidente.getSelectedItem().toString().trim();
            sectorAccidente = this.cbSectorAccidente.getSelectedItem().toString().trim();
            zonaAccidente = this.cbZonaAccidente.getSelectedItem().toString().trim();
            disenioAccidente = this.cbDisenioAccidente.getSelectedItem().toString().trim();
            tiempo = this.cbTiempoAccidente.getSelectedItem().toString().trim();
            if (this.cbCondicion.getSelectedIndex() != 0) {
                condicion = this.cbCondicion.getSelectedItem().toString().trim();
            }
            if (!this.txtCoordenadaX.getText().trim().isEmpty() || !this.txtCoordenadaY.getText().trim().isEmpty()) {
                if (this.txtCoordenadaX.getText().trim().isEmpty() && !this.txtCoordenadaY.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor llene la coordenada X");
                    return;
                }
                if (!this.txtCoordenadaX.getText().trim().isEmpty() && this.txtCoordenadaY.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor llene la coordenada Y");
                    return;
                }
                if (!this.txtCoordenadaX.getText().trim().isEmpty() && !this.txtCoordenadaY.getText().trim().isEmpty()) {
                    coordenadaX = this.txtCoordenadaX.getText().trim();
                    coordenadaY = this.txtCoordenadaY.getText().trim();
                }
            }
            direccionAccidente = this.txtDireccionAccidente.getText().trim();
            LocalidadComunaAccidente = this.txtLocalidadComunaAccidente.getText().trim();
            carac1 = this.cbCaract1.getSelectedItem().toString().trim();
            carac2 = this.cbCaract2.getSelectedItem().toString().trim();
            carac3 = this.cbCaract3.getSelectedItem().toString().trim();
            utilizacion = this.cbUtilizacion.getSelectedItem().toString().trim();
            calzada = this.cbCalzada.getSelectedItem().toString().trim();
            carril = this.cbCarril.getSelectedItem().toString().trim();
            material = this.cbMaterial.getSelectedItem().toString().trim();
            estado = this.cbEstado.getSelectedItem().toString().trim();
            ilumunacion = this.cbIluminacion.getSelectedItem().toString().trim();
            nipAgente = (this.txtAgente.getText().trim()).split(" - ")[0];
            semaforo = this.cbSemaforo.getSelectedItem().toString().trim();
            senial = this.txtSenial.getText().trim();

            if (this.cbDisminucion.getSelectedIndex() == 11) {
                disminucion = this.cbDisminucion.getSelectedItem().toString().trim() + " - " + this.txtDisminucionVisual.getText().trim();
            } else {
                disminucion = this.cbDisminucion.getSelectedItem().toString().trim();
            }

            if (this.cbDemarcacion.getSelectedIndex() == 11) {
                demarcacion = this.cbDemarcacion.getSelectedItem().toString().trim() + " - " + this.txtDemarcacion.getText().trim();
            } else {
                demarcacion = this.cbDemarcacion.getSelectedItem().toString().trim();
            }

            numHeridos = Integer.parseInt(this.spnHeridos.getValue().toString());
            numMuertos = Integer.parseInt(this.spnMuertos.getValue().toString());

            if (this.controladorAccidente.registrar(fechaAccidente, tipoGravedad,
                    claseAccidente, choqueCon, objetoFijo, areaAccidente,
                    sectorAccidente, zonaAccidente, disenioAccidente, tiempo,
                    coordenadaX, coordenadaY, direccionAccidente, LocalidadComunaAccidente,
                    carac1, carac2, carac3, utilizacion, calzada, carril, material, estado,
                    condicion, ilumunacion, nipAgente, disminucion, semaforo, senial, demarcacion,
                    numHeridos, numMuertos, id, croquis)) {

                JOptionPane.showMessageDialog(null, "Se ha guardado la información exitosamente");

                if (JOptionPane.showConfirmDialog(null, "¿Desea añadir algun anexo a este informe?") == 0) {
                    this.btnAniadirVehiculos.setEnabled(true);
                    this.btnAniadirTestigos.setEnabled(true);
                    this.btnRegistrar.setEnabled(false);
                    this.btnPasarAEditar.setEnabled(false);
                    this.idInforme = id;
                } else {
                    this.limpiarCampos();
                }
                this.listarInformes();
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al guardar la información");
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnPasarAEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarAEditarActionPerformed
        if (this.tblInformeAccidente.getSelectedRow() >= 0) {
            this.btnModificar.setEnabled(true);
            this.btnRegistrar.setEnabled(false);
            this.btnAniadirVehiculos.setEnabled(true);
            this.btnAniadirTestigos.setEnabled(true);
            this.btnTerminarAnexos.setEnabled(true);
            this.btnPasarAEditar.setEnabled(false);
            this.idInforme = Integer.parseInt(this.tblInformeAccidente.getValueAt(this.tblInformeAccidente.getSelectedRow(), 0).toString().trim());
            try {
                this.llenearCampos(this.controladorAccidente.buscar(this.idInforme, "InformeAccidente"));
            } catch (ParseException | UnsupportedEncodingException ex) {
                JOptionPane.showMessageDialog(null, "Error cargando la información");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un informe de la tabla para poder pasar a editarlo");
        }
    }//GEN-LAST:event_btnPasarAEditarActionPerformed

    private void btnTerminarAnexosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarAnexosActionPerformed
        this.btnModificar.setEnabled(false);
        this.btnRegistrar.setEnabled(true);
        this.btnAniadirVehiculos.setEnabled(false);
        this.btnAniadirTestigos.setEnabled(false);
        this.btnTerminarAnexos.setEnabled(false);
        this.btnPasarAEditar.setEnabled(true);
        this.listarInformes();
        this.limpiarCampos();
        this.idInforme = 0;
    }//GEN-LAST:event_btnTerminarAnexosActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (this.txtFechaAccidente.getDate() == null || this.cbGravedadAccidente.getSelectedIndex() == 0
                || this.cbClaseAccidente.getSelectedIndex() == 0 || this.cbChoqueCon.getSelectedIndex() == 0
                || this.cbObjetoFijo.getSelectedIndex() == 0 || Integer.parseInt(this.spnHeridos.getValue().toString()) < 0
                || Integer.parseInt(this.spnMuertos.getValue().toString()) < 0 || this.cbAreaAccidente.getSelectedIndex() == 0
                || this.cbSectorAccidente.getSelectedIndex() == 0 || this.cbZonaAccidente.getSelectedIndex() == 0
                || this.cbDisenioAccidente.getSelectedIndex() == 0 || this.cbTiempoAccidente.getSelectedIndex() == 0
                || this.txtDireccionAccidente.getText().trim().isEmpty() || this.txtLocalidadComunaAccidente.getText().trim().isEmpty()
                || this.cbCaract1.getSelectedIndex() == 0 || this.cbCaract2.getSelectedIndex() == 0 || this.cbCaract3.getSelectedIndex() == 0
                || this.cbUtilizacion.getSelectedIndex() == 0 || this.cbCalzada.getSelectedIndex() == 0 || this.cbCarril.getSelectedIndex() == 0
                || this.cbMaterial.getSelectedIndex() == 0 || this.cbEstado.getSelectedIndex() == 0
                || this.cbIluminacion.getSelectedIndex() == 0 || this.txtAgente.getText().trim().isEmpty() || this.cbDisminucion.getSelectedIndex() == 0
                || (this.cbDisminucion.getSelectedIndex() == 11 && this.txtDisminucionVisual.getText().trim().isEmpty())
                || this.cbSemaforo.getSelectedIndex() == 0 || this.txtSenial.getText().trim().isEmpty() || this.cbDemarcacion.getSelectedIndex() == 0
                || (this.cbDemarcacion.getSelectedIndex() == 11 && this.txtDemarcacion.getText().trim().isEmpty())) {
            JOptionPane.showMessageDialog(null, "Por favor llene los campos requeridos (*)");
        } else {
            Date fechaAccidente;
            String tipoGravedad, claseAccidente, choqueCon, objetoFijo, areaAccidente, sectorAccidente, zonaAccidente, disenioAccidente,
                    tiempo, coordenadaX = null, coordenadaY = null, direccionAccidente, LocalidadComunaAccidente, carac1, carac2, carac3, utilizacion,
                    calzada, carril, material, estado, condicion = null, ilumunacion, nipAgente, disminucion, semaforo, senial,
                    demarcacion;
            int numHeridos, numMuertos, id = this.idInforme;

            fechaAccidente = this.txtFechaAccidente.getDate();
            tipoGravedad = this.cbGravedadAccidente.getSelectedItem().toString().trim();
            claseAccidente = this.cbClaseAccidente.getSelectedItem().toString().trim();
            choqueCon = this.cbChoqueCon.getSelectedItem().toString().trim();
            objetoFijo = this.cbObjetoFijo.getSelectedItem().toString().trim();
            areaAccidente = this.cbAreaAccidente.getSelectedItem().toString().trim();
            sectorAccidente = this.cbSectorAccidente.getSelectedItem().toString().trim();
            zonaAccidente = this.cbZonaAccidente.getSelectedItem().toString().trim();
            disenioAccidente = this.cbDisenioAccidente.getSelectedItem().toString().trim();
            tiempo = this.cbTiempoAccidente.getSelectedItem().toString().trim();
            if (this.cbCondicion.getSelectedIndex() != 0) {
                condicion = this.cbCondicion.getSelectedItem().toString().trim();
            }
            if (!this.txtCoordenadaX.getText().trim().isEmpty() || !this.txtCoordenadaY.getText().trim().isEmpty()) {
                if (this.txtCoordenadaX.getText().trim().isEmpty() && !this.txtCoordenadaY.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor llene la coordenada X");
                    return;
                }
                if (!this.txtCoordenadaX.getText().trim().isEmpty() && this.txtCoordenadaY.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor llene la coordenada Y");
                    return;
                }
                if (!this.txtCoordenadaX.getText().trim().isEmpty() && !this.txtCoordenadaY.getText().trim().isEmpty()) {
                    coordenadaX = this.txtCoordenadaX.getText().trim();
                    coordenadaY = this.txtCoordenadaY.getText().trim();
                }
            }
            direccionAccidente = this.txtDireccionAccidente.getText().trim();
            LocalidadComunaAccidente = this.txtLocalidadComunaAccidente.getText().trim();
            carac1 = this.cbCaract1.getSelectedItem().toString().trim();
            carac2 = this.cbCaract2.getSelectedItem().toString().trim();
            carac3 = this.cbCaract3.getSelectedItem().toString().trim();
            utilizacion = this.cbUtilizacion.getSelectedItem().toString().trim();
            calzada = this.cbCalzada.getSelectedItem().toString().trim();
            carril = this.cbCarril.getSelectedItem().toString().trim();
            material = this.cbMaterial.getSelectedItem().toString().trim();
            estado = this.cbEstado.getSelectedItem().toString().trim();
            ilumunacion = this.cbIluminacion.getSelectedItem().toString().trim();
            nipAgente = (this.txtAgente.getText().trim()).split(" - ")[0];
            semaforo = this.cbSemaforo.getSelectedItem().toString().trim();
            senial = this.txtSenial.getText().trim();

            if (this.cbDisminucion.getSelectedIndex() == 11) {
                disminucion = this.cbDisminucion.getSelectedItem().toString().trim() + " - " + this.txtDisminucionVisual.getText().trim();
            } else {
                disminucion = this.cbDisminucion.getSelectedItem().toString().trim();
            }

            if (this.cbDemarcacion.getSelectedIndex() == 11) {
                demarcacion = this.cbDemarcacion.getSelectedItem().toString().trim() + " - " + this.txtDemarcacion.getText().trim();
            } else {
                demarcacion = this.cbDemarcacion.getSelectedItem().toString().trim();
            }

            numHeridos = Integer.parseInt(this.spnHeridos.getValue().toString());
            numMuertos = Integer.parseInt(this.spnMuertos.getValue().toString());
            
            if (this.controladorAccidente.modificar(fechaAccidente, tipoGravedad,
                    claseAccidente, choqueCon, objetoFijo, areaAccidente,
                    sectorAccidente, zonaAccidente, disenioAccidente, tiempo,
                    coordenadaX, coordenadaY, direccionAccidente, LocalidadComunaAccidente,
                    carac1, carac2, carac3, utilizacion, calzada, carril, material, estado,
                    condicion, ilumunacion, nipAgente, disminucion, semaforo, senial, demarcacion,
                    numHeridos, numMuertos, id, croquis)) {

                JOptionPane.showMessageDialog(null, "Se ha guardado la información exitosamente");

                if (JOptionPane.showConfirmDialog(null, "¿Desea añadir algun anexo a este informe?") == 0) {
                    this.btnAniadirVehiculos.setEnabled(true);
                    this.btnAniadirTestigos.setEnabled(true);
                    this.btnRegistrar.setEnabled(false);
                    this.btnPasarAEditar.setEnabled(false);
                } else {
                    this.limpiarCampos();
                    this.btnAniadirVehiculos.setEnabled(false);
                    this.btnAniadirTestigos.setEnabled(false);
                    this.btnRegistrar.setEnabled(true);
                    this.btnPasarAEditar.setEnabled(true);
                    this.btnModificar.setEnabled(false);
                    this.btnTerminarAnexos.setEnabled(false);
                }
                this.listarInformes();
            } else {
                JOptionPane.showMessageDialog(null, "Hubo un error al modificar la información");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtBusquedaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyReleased
        if (this.txtBusqueda.getText().trim().isEmpty()) {
            this.listarInformes();
        } else {
            Map<String, String> campos = new HashMap<>();
            campos.put("IA.TIPO_GRAVEDAD", this.txtBusqueda.getText());
            campos.put("IA.FECHA_HORA", this.txtBusqueda.getText());
            campos.put("IA.CLASE_ACCIDENTE", this.txtBusqueda.getText());
            campos.put("IA.CHOQUE_CON", this.txtBusqueda.getText());
            campos.put("IA.OBJETO_FIJO", this.txtBusqueda.getText());
            campos.put("IA.NUMERO_MUERTOS", this.txtBusqueda.getText());
            campos.put("IA.NUMERO_HERIDOS", this.txtBusqueda.getText());
            this.controladorAccidente.listar(this.tblInformeAccidente, campos);
        }
    }//GEN-LAST:event_txtBusquedaKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadirCroquis;
    private javax.swing.JButton btnAniadirTestigos;
    private javax.swing.JButton btnAniadirVehiculos;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnPasarAEditar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnTerminarAnexos;
    private javax.swing.JComboBox<String> cbAreaAccidente;
    private javax.swing.JComboBox<String> cbCalzada;
    private javax.swing.JComboBox<String> cbCaract1;
    private javax.swing.JComboBox<String> cbCaract2;
    private javax.swing.JComboBox<String> cbCaract3;
    private javax.swing.JComboBox<String> cbCarril;
    private javax.swing.JComboBox<String> cbChoqueCon;
    private javax.swing.JComboBox<String> cbClaseAccidente;
    private javax.swing.JComboBox<String> cbCondicion;
    private javax.swing.JComboBox<String> cbDemarcacion;
    private javax.swing.JComboBox<String> cbDisenioAccidente;
    private javax.swing.JComboBox<String> cbDisminucion;
    private javax.swing.JComboBox<String> cbEstado;
    private javax.swing.JComboBox<String> cbGravedadAccidente;
    private javax.swing.JComboBox<String> cbIluminacion;
    private javax.swing.JComboBox<String> cbMaterial;
    private javax.swing.JComboBox<String> cbObjetoFijo;
    private javax.swing.JComboBox<String> cbSectorAccidente;
    private javax.swing.JComboBox<String> cbSemaforo;
    private javax.swing.JComboBox<String> cbTiempoAccidente;
    private javax.swing.JComboBox<String> cbUtilizacion;
    private javax.swing.JComboBox<String> cbZonaAccidente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstAgentes;
    private javax.swing.JSpinner spnHeridos;
    private javax.swing.JSpinner spnMuertos;
    private javax.swing.JTable tblInformeAccidente;
    private javax.swing.JTextField txtAgente;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCoordenadaX;
    private javax.swing.JTextField txtCoordenadaY;
    private javax.swing.JTextField txtCroquis;
    private javax.swing.JTextField txtDemarcacion;
    private javax.swing.JTextField txtDireccionAccidente;
    private javax.swing.JTextField txtDisminucionVisual;
    private com.toedter.calendar.JDateChooser txtFechaAccidente;
    private javax.swing.JTextField txtLocalidadComunaAccidente;
    private javax.swing.JTextField txtSenial;
    // End of variables declaration//GEN-END:variables

    private void llenarLista() {
        this.lstAgentes.setModel(this.controladorComboBox.modelList("Persona/Agentes", "nip", "nombreCompleto"));
    }

    private void limpiarCampos() {
        this.txtFechaAccidente.setDate(null);
        this.cbGravedadAccidente.setSelectedIndex(0);
        this.cbClaseAccidente.setSelectedIndex(0);
        this.cbChoqueCon.setSelectedIndex(0);
        this.cbObjetoFijo.setSelectedIndex(0);
        this.spnHeridos.setValue(0);
        this.spnMuertos.setValue(0);
        this.cbAreaAccidente.setSelectedIndex(0);
        this.cbSectorAccidente.setSelectedIndex(0);
        this.cbZonaAccidente.setSelectedIndex(0);
        this.cbDisenioAccidente.setSelectedIndex(0);
        this.cbTiempoAccidente.setSelectedIndex(0);
        this.txtCoordenadaX.setText("");
        this.txtCoordenadaY.setText("");
        this.txtDireccionAccidente.setText("");
        this.txtLocalidadComunaAccidente.setText("");
        this.txtAgente.setText("");
        this.llenarLista();
        this.cbCaract1.setSelectedIndex(0);
        this.cbCaract2.setSelectedIndex(0);
        this.cbCaract3.setSelectedIndex(0);
        this.cbUtilizacion.setSelectedIndex(0);
        this.cbCalzada.setSelectedIndex(0);
        this.cbCarril.setSelectedIndex(0);
        this.cbMaterial.setSelectedIndex(0);
        this.cbEstado.setSelectedIndex(0);
        this.cbCondicion.setSelectedIndex(0);
        this.cbIluminacion.setSelectedIndex(0);
        this.txtCroquis.setText("");
        this.cbDisminucion.setSelectedIndex(0);
        this.txtDisminucionVisual.setText("");
        this.cbSemaforo.setSelectedIndex(0);
        this.txtSenial.setText("");
        this.cbDemarcacion.setSelectedIndex(0);
        this.txtDemarcacion.setText("");
    }

    private void llenearCampos(JSONObject obj) throws ParseException, UnsupportedEncodingException {
        this.txtFechaAccidente.setDate((new SimpleDateFormat("yyyy-MM-dd")).parse(((obj.get("fechaHora").toString()).split("T"))[0]));
        this.cbGravedadAccidente.setSelectedItem(URLDecoder.decode(obj.get("tipoGravedad").toString(), "UTF-8"));
        this.cbClaseAccidente.setSelectedItem(URLDecoder.decode(obj.get("claseAccidente").toString(), "UTF-8"));
        this.cbChoqueCon.setSelectedItem(URLDecoder.decode(obj.get("choqueCon").toString(), "UTF-8"));
        this.cbObjetoFijo.setSelectedItem(URLDecoder.decode(obj.get("objetoFijo").toString(), "UTF-8"));
        this.spnHeridos.setValue(Integer.parseInt(obj.get("numeroHeridos").toString()));
        this.spnMuertos.setValue(Integer.parseInt(obj.get("numeroMuertos").toString()));
        JSONObject caracLugar = (JSONObject) obj.get("caracteristicaLugar");
        this.cbAreaAccidente.setSelectedItem(caracLugar.get("areaId").toString());
        this.cbSectorAccidente.setSelectedItem(caracLugar.get("sectorId").toString());
        this.cbZonaAccidente.setSelectedItem(caracLugar.get("zonaId").toString());
        this.cbDisenioAccidente.setSelectedItem(caracLugar.get("disenioId").toString());
        this.cbTiempoAccidente.setSelectedItem(caracLugar.get("tiempoId").toString());
        JSONObject lugar = (JSONObject) obj.get("lugar");
        if (lugar.get("coordenandaX").toString() != null && lugar.get("coordenadaY").toString() != null) {
            this.txtCoordenadaX.setText(lugar.get("coordenandaX").toString());
            this.txtCoordenadaY.setText(lugar.get("coordenadaY").toString());
        }
        this.txtDireccionAccidente.setText(lugar.get("direccion").toString());
        this.txtLocalidadComunaAccidente.setText(lugar.get("localidadComuna").toString());
        JSONObject agente = (JSONObject) obj.get("agente");
        this.controladorComboBox.modeloListaFiltrado(this.lstAgentes, agente.get("nip").toString());
        this.lstAgentes.setSelectedIndex(0);
        this.txtAgente.setText(this.lstAgentes.getSelectedValue());
        JSONObject caracVia = (JSONObject) obj.get("caracteristicaVia");
        this.cbCaract1.setSelectedItem(caracVia.get("caracGeometricaVia1").toString());
        this.cbCaract2.setSelectedItem(caracVia.get("caracGeometricaVia2").toString());
        this.cbCaract3.setSelectedItem(caracVia.get("caracGeometricaVia3").toString());
        this.cbUtilizacion.setSelectedItem(caracVia.get("utilizacion").toString());
        this.cbCalzada.setSelectedItem(caracVia.get("calzada").toString());
        this.cbCarril.setSelectedItem(caracVia.get("carril").toString());
        this.cbMaterial.setSelectedItem(caracVia.get("material").toString());
        this.cbEstado.setSelectedItem(caracVia.get("estado").toString());
        if (caracVia.get("condicion").toString() != null) {
            this.cbCondicion.setSelectedItem(caracVia.get("condicion").toString());
        }
        this.cbIluminacion.setSelectedItem(caracVia.get("iluminacion").toString());
        String disminu = caracVia.get("disminucionVisual").toString();
        if (disminu.contains(" - ")) {
            this.cbDisminucion.setSelectedItem(disminu.split(" - ")[0]);
            this.txtDisminucionVisual.setText(disminu.split(" - ")[1]);
        } else {
            this.cbDisminucion.setSelectedItem(disminu);
            this.txtDisminucionVisual.setText("");
        }
        this.cbSemaforo.setSelectedItem(caracVia.get("controlSemaforo").toString());
        this.txtSenial.setText(caracVia.get("controlSenales").toString());
        String demarca = caracVia.get("controlDemarcacion").toString();
        if (demarca.contains(" - ")) {
            this.cbDemarcacion.setSelectedItem(demarca.split(" - ")[0]);
            this.txtDemarcacion.setText(demarca.split(" - ")[1]);
        } else {
            this.cbDemarcacion.setSelectedItem(demarca);
            this.txtDemarcacion.setText("");
        }
    }

    private void listarInformes() {
        this.controladorAccidente.listar(this.tblInformeAccidente, null);
    }

}
