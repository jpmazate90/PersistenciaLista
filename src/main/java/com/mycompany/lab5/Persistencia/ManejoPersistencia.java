/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5.Persistencia;

import com.mycompany.lab5.Listas.Lista;
import com.mycompany.lab5.Listas.Nodo;
import com.mycompany.lab5.Manejadores.ManejadorMenuPrincipal;
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
    private static final String INFORMACION_DIRECTORIO = "directorioListado";

    public static void almacenarInformacion(Lista listaConInformacion) throws FileNotFoundException, IOException {
        Nodo aux = listaConInformacion.getInicio();
        int numeroNodo = 0;
        while (aux != null) {
            try (ObjectOutputStream archivoDeSalida = new ObjectOutputStream(new FileOutputStream(INFORMACION_DIRECTORIO + "/nodo" + numeroNodo))) {
                archivoDeSalida.writeObject(aux);
                archivoDeSalida.flush(); 
            }
            numeroNodo++;
            aux = aux.getSiguiente();
        }
    }
    
    

    public static Lista cargarInformacion(JTextArea area) throws FileNotFoundException, IOException, ClassNotFoundException {

        Lista lista = new Lista(area);
        File dirEntrada = new File(INFORMACION_DIRECTORIO);

        File[] listado = dirEntrada.listFiles();

        for (File listado1 : listado) {
            if (listado1.exists()) {
                FileInputStream archivoConInfoEntrada = new FileInputStream(listado1);
                ObjectInputStream informacionDeEntrada = new ObjectInputStream(archivoConInfoEntrada);
                Double dato = ((Nodo) informacionDeEntrada.readObject()).getDato();
                lista.agregarAlFinal(dato);
            }
        }
        return lista;
    }

}
