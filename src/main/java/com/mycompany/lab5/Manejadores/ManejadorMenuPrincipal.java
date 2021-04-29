/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5.Manejadores;

 import com.mycompany.lab5.GUI.MenuPrincipalGUI;
import com.mycompany.lab5.Listas.Lista;
import com.mycompany.lab5.Persistencia.ManejoPersistencia;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jpmazate
 */
public class ManejadorMenuPrincipal {

    MenuPrincipalGUI frame;

    public ManejadorMenuPrincipal(MenuPrincipalGUI frame) {
        this.frame = frame;

    }

    public void agregarNodo(Double dato, boolean inicio) {
        setAreaList();
        frame.getLista().setArea(frame.getjTextArea1());
        if (inicio) {
            frame.getLista().agregarAlInicio(dato);
        } else {
            frame.getLista().agregarAlFinal(dato);
        }
        mostrarLista();

    }
    
    
    

    public void setAreaList() {
        frame.getLista().setArea(frame.getjTextArea1());
    }

    public void mostrarLista() {

        setAreaList();
        frame.getLista().mostrarLista();

    }

    public void mostrarDatoFinal() {
        try {
            setAreaList();
            frame.getLista().mostrarUltimoDato();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "NO HAY DATO INICIAL");
        }
    }

    public void mostrarDatoInicial() {
        try {
            setAreaList();
            frame.getLista().mostrarPrimerDato();
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "NO HAY DATO INICIAL");
        }

    }

    public void guardarInformacion() throws IOException {
        ManejoPersistencia.almacenarInformacion(frame.getLista());
    }

    public void cargarInformacion() throws IOException, FileNotFoundException, ClassNotFoundException {
        frame.setLista(ManejoPersistencia.cargarInformacion(frame.getjTextArea1()));
        mostrarLista();
    }

}
