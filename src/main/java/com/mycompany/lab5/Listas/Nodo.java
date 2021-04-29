/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab5.Listas;

/**
 *
 * @author jpmazate
 */
import java.io.Serializable;

/**
 *
 * @author jpmazate
 * @param <T>
 */
public class Nodo implements Serializable {
    
    private Double dato;
    private Nodo siguiente;

    public Nodo(Double dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Nodo(Double dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
    
    
    public Double getDato(){
        return this.dato;
    }
    
    public void setDato(Double dato){
        this.dato = dato;
    }
    

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    
    
 
}