/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.proyecto.controlador;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Daryl Ospina
 */
public class CtlInformeAcidente extends ControladorAbstracto {

    @Override
    public DefaultTableModel listar(String entidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ImageIcon traerImagen() {
        try {
            JSONObject informe = ((JSONObject) (new JSONParser().parse(this.traerlistar("InformeAccidente/1"))));

            Object imagenEnBase64 = informe.get("croquis");
            
//            String imagenCodigo = new String(Base64.getDecoder().decode(imagenEnBase64));
            
//            System.out.println(imagenCodigo);

//            byte[] imagenEnBytes = imagenCodigo.getBytes();

//            BufferedImage image = ImageIO.read(new ByteArrayInputStream(imagenEnBytes));
            
//            return new ImageIcon(image.getScaledInstance(60, 60, 0));
        } catch (ParseException ex) {
            System.out.println("[Error] : " + ex);
        } 
//        catch (IOException ex) {
//            Logger.getLogger(CtlInformeAcidente.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }

}
