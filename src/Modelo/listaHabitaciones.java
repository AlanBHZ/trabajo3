/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;
public class listaHabitaciones{
    private ArrayList<Habitacion> lista; 
    private String categoria; 

    public listaHabitaciones(ArrayList<Habitacion> lista, String categoria) {
        this.lista = lista;
        this.categoria = categoria;
    }

    public listaHabitaciones() {
        this.lista = new ArrayList<>();
        this.categoria = null;
    }

    public ArrayList<Habitacion> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Habitacion> lista) {
        this.lista = lista;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String mostrarLista(){
        String mensaje = "",dispo="";
        for (int i = 0; i < lista.size(); i++) {
            mensaje += "\nNúmero de habitacion: "+lista.get(i).getNumero()+
                    "\nDisponibilidad: "+lista.get(i).mostrarDisponibilidad();
            if(i>5){
                this.categoria="Barata";
                mensaje+="\nCategoría: "+categoria;
            }
            else{
                this.categoria="Cara";
                mensaje+="\nCategoría: "+categoria;
            }
        }
        return mensaje;
    }
    public void precio(){
        
    }
    @Override
    public String toString() {
        return "listaHabitaciones{" +mostrarLista()+ "lista=" + lista + ", categoria=" + categoria +'}';
    }
    
}
