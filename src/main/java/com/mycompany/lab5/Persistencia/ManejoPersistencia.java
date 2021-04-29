/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5.Persistencia;

import com.mycompany.lab5.Listas.Lista;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JTextArea;

/**
 *
 * @author jpmazate
 */
public class ManejoPersistencia {
    
    private static final String INFORMACION_PERSISTENTE = "listaAlmacenada.dat";
    
    public static void almacenarInformacion(Lista listaConInformacion) throws FileNotFoundException, IOException {
        try (ObjectOutputStream archivoDeSalida = new ObjectOutputStream(new FileOutputStream(INFORMACION_PERSISTENTE))) {
            archivoDeSalida.writeObject(listaConInformacion);
            archivoDeSalida.flush();
        }
    }
    
    public static Lista cargarInformacion(JTextArea area) throws FileNotFoundException, IOException, ClassNotFoundException{
        File archivoEntrada = new File(INFORMACION_PERSISTENTE);
        if (archivoEntrada.exists()) {
            FileInputStream archivoConInfoEntrada = new FileInputStream(archivoEntrada);
            ObjectInputStream informacionDeEntrada = new ObjectInputStream(archivoConInfoEntrada);
            return (Lista) informacionDeEntrada.readObject();
        } else {
            return new Lista(area);
        }
    }
    
    
    
    
}
