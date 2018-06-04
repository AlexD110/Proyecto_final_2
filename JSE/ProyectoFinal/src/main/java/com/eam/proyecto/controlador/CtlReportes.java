/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Daryl Ospina
 */
public class CtlReportes {

    public void generarReporte() {
        try {
            //"jdbc:mariadb://localhost:3306/juego","root",""
            Class.forName("oracle.jdbc.driver.OracleDriver"); //se carga el driver en memoria
            Connection cone = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADMIN", "1094971007");
            JasperReport jr = JasperCompileManager.compileReport("./src/main/resources/ReportesProyecto/InformeAccidente.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, null, cone);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (SQLException | JRException | ClassNotFoundException ex) {
            System.out.println("[Error] : Generando reporte Excepcion: " + ex);
        }
    }
}
