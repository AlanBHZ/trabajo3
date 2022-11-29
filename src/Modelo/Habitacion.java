/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Habitacion {
    private int numero;
    private int entrada;
    private int salida; 
    private double precio;
    private boolean disponibilidad;
    
    public Habitacion(int numero, int entrada, int salida, double precio, boolean disponibilidad) {
        this.numero = numero;
        this.entrada = entrada;
        this.salida = salida;
        this.precio = precio;
        this.disponibilidad = disponibilidad;
    }

    public Habitacion() {
        this.numero = 0;
        this.entrada = 0;
        this.salida = 0;
        this.precio = 0;
        this.disponibilidad = true;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getEntrada() {
        return entrada;
    }

    public void setEntrada(int entrada) {
        this.entrada = entrada;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
    
    public String mostrarDisponibilidad(){
        if(isDisponibilidad()){
            return "Disponible";
        }
        else{
            return "Ocupada";
        }
    }
    @Override
    public String toString() {
        return "Habitacion{" + "numero=" + numero + ", entrada=" + entrada + ", salida=" + salida + ", precio=" + precio + ", disponibilidad=" + mostrarDisponibilidad() + '}';
    }
    
}
