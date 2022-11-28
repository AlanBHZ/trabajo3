/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Familia Niño
 */
public class Producto {
    private String nombre;
    private String tipo;
    private double precio;

    public Producto(String nombre, String tipo, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Producto() {
        this.nombre = null;
        this.tipo = null;
        this.precio = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + '}';
    }
    
    
}
