/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Hospedaje {

    private listaHabitaciones lista;
    private int cantidad;

    public Hospedaje(listaHabitaciones lista, int cantidad) {
        this.lista = lista;
        this.cantidad = cantidad;
    }

    public Hospedaje() {
        this.lista = new listaHabitaciones();
        this.cantidad = 0;
    }

    public listaHabitaciones getLista() {
        return lista;
    }

    public void setLista(listaHabitaciones lista) {
        this.lista = lista;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void precio(int n) {
        for (int i = 0; i < lista.getLista().size(); i++) {
            int horas = lista.getLista().get(i).getSalida() - lista.getLista().get(i).getEntrada();
            if (lista.getCategoria().equals("Barata")) {
                switch (horas) {
                    case 1:
                        lista.getLista().get(i).setPrecio(15);
                        break;
                    case 2:
                        lista.getLista().get(i).setPrecio(20);
                        break;
                    case 3:
                        lista.getLista().get(i).setPrecio(30);
                        break;
                    default:
                        lista.getLista().get(i).setPrecio(horas * 20);
                        break;
                }
            } else {
                switch (horas) {
                    case 1:
                        lista.getLista().get(i).setPrecio(25);
                        break;
                    case 2:
                        lista.getLista().get(i).setPrecio(35);
                        break;
                    case 3:
                        lista.getLista().get(i).setPrecio(50);
                        break;
                    default:
                        lista.getLista().get(i).setPrecio(horas * 30);
                        break;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Hospedaje{" + "lista=" + lista + ", cantidad=" + cantidad + '}';
    }
}
