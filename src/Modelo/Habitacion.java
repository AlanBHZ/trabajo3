/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Habitacion {
    private int numero_habitacion;
    private String hora_entrada;
    private String hora_salida;
    private double importe_a_pagar;

    public Habitacion(int numero_habitacion, String hora_entrada, String hora_salida, double importe_a_pagar) {
        this.numero_habitacion = numero_habitacion;
        this.hora_entrada = hora_entrada;
        this.hora_salida = hora_salida;
        this.importe_a_pagar = importe_a_pagar;
    }

    public Habitacion() {
        this.numero_habitacion = 0;
        this.hora_entrada = null;
        this.hora_salida = null;
        this.importe_a_pagar = 0;
    }

    public int getNumero_habitacion() {
        return numero_habitacion;
    }

    public void setNumero_habitacion(int numero_habitacion) {
        this.numero_habitacion = numero_habitacion;
    }

    public String getHora_entrada() {
        return hora_entrada;
    }

    public void setHora_entrada(String hora_entrada) {
        this.hora_entrada = hora_entrada;
    }

    public String getHora_salida() {
        return hora_salida;
    }

    public void setHora_salida(String hora_salida) {
        this.hora_salida = hora_salida;
    }

    public double getImporte_a_pagar() {
        return importe_a_pagar;
    }

    public void setImporte_a_pagar(double importe_a_pagar) {
        this.importe_a_pagar = importe_a_pagar;
    }
    
    
}
