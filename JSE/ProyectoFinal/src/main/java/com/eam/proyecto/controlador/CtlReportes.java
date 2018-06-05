package com.eam.proyecto.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 * @author Daryl Ospina
 */
public class CtlReportes {

    public void generarReporteAccidente(Map<String,Object> parametros) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection cone = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADMIN", "1094971007");
            JasperReport jr = JasperCompileManager.compileReport("./src/main/resources/ReportesProyecto/InformeAccidente.jrxml");
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, cone);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setLocationRelativeTo(null);
            jv.setVisible(true);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("[Error] : Generando reporte Excepcion: " + ex);
        }
    }
}
