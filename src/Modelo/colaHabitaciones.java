/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.LinkedList;

public class colaHabitaciones {

    private LinkedList<Habitacion> cola;

    public colaHabitaciones() {
        cola = new LinkedList<>();
    }

    public LinkedList<Habitacion> getCola() {
        return cola;
    }

    public void setCola(LinkedList<Habitacion> cola) {
        this.cola = cola;
    }

    public void encolar(Habitacion habitacion) {
        cola.add(habitacion);
    }

    public void desencolar() {
        cola.removeFirst();
    }

    public int tamano() {
        return cola.size();
    }

    public boolean estaVacia() {
        return cola.isEmpty();
    }

    public Habitacion frente() {
        return cola.getFirst();
    }

    public Habitacion finalCola() {
        return cola.getLast();
    }
}
