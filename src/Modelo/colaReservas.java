/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Arrays;
import static java.util.Collections.sort;
import java.util.LinkedList;

/**
 *
 * @author Familia Niño
 */
public class colaReservas {
    private LinkedList<Habitacion> colaHabitaciones;

    public colaReservas(LinkedList<Habitacion> colaHabitaciones) {
        this.colaHabitaciones = colaHabitaciones;
    }

    public colaReservas() {
        this.colaHabitaciones = new LinkedList<>();
    }
    //Agregar
    public void agregar(Habitacion habitacion) {
        colaHabitaciones.addLast(habitacion);
    }
    //Eliminar
    public Habitacion eliminar() {
        return colaHabitaciones.removeFirst();
    }
    public LinkedList<Habitacion> getColaHabitaciones() {
        return colaHabitaciones;
    }
    
    public void setColaHabitaciones(LinkedList<Habitacion> colaHabitaciones) {
        this.colaHabitaciones = colaHabitaciones;
    }
    
}
