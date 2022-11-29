/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.LinkedList;

public class pilaProductos {

    private LinkedList<Producto> pila;

    public pilaProductos() {
        pila = new LinkedList<Producto>();
    }

    public LinkedList<Producto> getPila() {
        return pila;
    }

    public void setPila(LinkedList<Producto> pila) {
        this.pila = pila;
    }

    public void push(Producto producto) {
        pila.addFirst(producto);
    }

    public Producto pop() {
        return pila.removeFirst();
    }

    public boolean isEmpty() {
        return pila.isEmpty();
    }

    public int size() {
        return pila.size();
    }
}
