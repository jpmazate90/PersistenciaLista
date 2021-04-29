/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5.Ordenacion;

import com.mycompany.lab5.Listas.Lista;
import com.mycompany.lab5.Listas.Nodo;

/**
 *
 * @author jpmazate
 */
public class Burbuja {

    public static void ordenarBurbuja(Lista lista) {
        Nodo aux = lista.getInicio();
        double pivote;
        boolean cambios = false;
        while (true) {
            cambios = false;
            while (aux != null) {
                if (aux.getSiguiente() != null) {
                    if (aux.getDato() > aux.getSiguiente().getDato()) {
                        pivote = aux.getDato();
                        aux.setDato(aux.getSiguiente().getDato());
                        aux.getSiguiente().setDato(pivote);
                        cambios = true;
                    }
                }
                aux = aux.getSiguiente();
            }
            if(!cambios){
                break;
            }
        }
    }

    public static void actualizarPrimero(Lista lista, Nodo inicial) {
    lista.setInicio(inicial);

    }

    public static void actualizarUltimo(Lista lista, Nodo nodo) {
        while (nodo != null) {
            if (nodo.getSiguiente() == null) {
                lista.setFin(nodo);
            }
            nodo = nodo.getSiguiente();

        }
    }

}
