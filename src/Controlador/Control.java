/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivo;
import Modelo.Habitacion;
import Vista.VentanaMenu;
import Vista.VentanaReporte;
import Vista.VentanaReserva;
import Vista.VentanaSalida;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Control implements ActionListener {

    VentanaMenu menu;
    VentanaReporte reporte;
    VentanaReserva reserva;
    VentanaSalida salida;

    public Control(VentanaMenu menu, VentanaReporte reporte, VentanaReserva reserva, VentanaSalida salida) {
        this.menu = menu;
        this.reporte = reporte;
        this.reserva = reserva;
        this.salida = salida;
    }

    public Control() {
        menu = new VentanaMenu();
        reporte = new VentanaReporte();
        reserva = new VentanaReserva();
        salida = new VentanaSalida();
    }

    public void iniciar() {
        menu.setVisible(true);
        menu.getBtnReporte().addActionListener(this);
        menu.getBtnRerservar().addActionListener(this);
        menu.getBtnSalida().addActionListener(this);
        reporte.getBtnMenu().addActionListener(this);
        reporte.getBtnBuscar().addActionListener(this);
        reserva.getBtnMenu().addActionListener(this);
        reserva.getBtnReservar().addActionListener(this);
        salida.getBtnMenu().addActionListener(this);
        salida.getBtnSalida().addActionListener(this);
    }

    public void escribir_reporte(Habitacion lista) {
        DefaultTableModel tabla = new DefaultTableModel();
        String[] fila = new String[3];
        tabla.addColumn("N° Habitacion");
        tabla.addColumn("Horas reservadas");
        tabla.addColumn("Total horas");
        fila[0] = String.valueOf(lista.getNumero());
        fila[1] = String.valueOf(lista.getEntrada());
        fila[2] = String.valueOf(lista.getPrecio());
        tabla.addRow(fila);
        reporte.getTblBusqueda().setModel(tabla);
    }

    public void escribir_reporte(ArrayList<Habitacion> lista) {
        DefaultTableModel tabla = new DefaultTableModel();
        String[] fila = new String[3];
        tabla.addColumn("N° Habitacion");
        tabla.addColumn("Horas reservadas");
        tabla.addColumn("Total horas");
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = String.valueOf(lista.get(i).getNumero());
            fila[1] = String.valueOf(lista.get(i).getEntrada());
            fila[2] = String.valueOf(lista.get(i).getPrecio());
            tabla.addRow(fila);
        }
        reporte.getTblBusqueda().setModel(tabla);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.getBtnReporte()) {
            reporte.setVisible(true);
            menu.setVisible(false);
            Archivo arch = new Archivo();
            ArrayList<Habitacion> lista = new ArrayList<>();
            lista = arch.leer_reportes();
            DefaultTableModel tabla = new DefaultTableModel();
            String[] fila = new String[3];
            tabla.addColumn("N° Habitacion");
            tabla.addColumn("Tiempo de estadia Total");
            tabla.addColumn("Total recaudado");
            int total = 0;
            for (int i = 0; i < lista.size(); i++) {
                fila[0] = String.valueOf(lista.get(i).getNumero());
                fila[1] = String.valueOf(lista.get(i).getEntrada());
                fila[2] = String.valueOf(lista.get(i).getPrecio());
                tabla.addRow(fila);
                total += lista.get(i).getPrecio();
            }
            reporte.getTblReporte().setModel(tabla);
            reporte.getTxtRecaudo().setText(String.valueOf(total));
        }
        if (e.getSource() == menu.getBtnRerservar()) {
            reserva.setVisible(true);
            menu.setVisible(false);
            Archivo archivo = new Archivo();
            ArrayList<Habitacion> lista = new ArrayList<>();
            lista = archivo.leer();
            DefaultTableModel tabla = new DefaultTableModel();
            String[] fila = new String[2];
            tabla.addColumn("N° Habitacion");
            tabla.addColumn("Disponibilidad");
            for (int i = 0; i < lista.size(); i++) {
                fila[0] = String.valueOf(lista.get(i).getNumero());
                if (lista.get(i).isDisponibilidad()) {

                    fila[1] = "Ocupado";
                } else {
                    fila[1] = "Disponible";
                }
                if (!lista.get(i).isDisponibilidad()) {
                    reserva.getCmbDisponibles().addItem(fila[0]);
                }
                tabla.addRow(fila);
            }
            reserva.getTblHabitaciones().setModel(tabla);
        }
        if (e.getSource() == menu.getBtnSalida()) {
            salida.setVisible(true);
            menu.setVisible(false);
            Archivo archivo = new Archivo();
            ArrayList<Habitacion> lista = new ArrayList<>();
            lista = archivo.leer();
            DefaultTableModel tabla = new DefaultTableModel();
            String[] fila = new String[2];
            tabla.addColumn("N° Habitacion");
            tabla.addColumn("Disponibilidad");
            for (int i = 0; i < lista.size(); i++) {

                if (lista.get(i).isDisponibilidad()) {
                    fila[0] = String.valueOf(lista.get(i).getNumero());
                    if (lista.get(i).isDisponibilidad()) {
                        fila[1] = "Ocupado";
                    }
                    if (lista.get(i).isDisponibilidad()) {
                        salida.getCmbHabitacion().addItem(fila[0]);
                    }
                    tabla.addRow(fila);
                }
            }
            salida.getTblHabitaciones().setModel(tabla);
        }
        if (e.getSource() == reporte.getBtnMenu()) {
            menu.setVisible(true);
            reporte.setVisible(false);
        }
        if (e.getSource() == reporte.getBtnBuscar()) {
            String dato;
            dato = (String) reporte.getCmbReserva().getSelectedItem();
            Archivo arch = new Archivo();
            Habitacion lista;
            switch (dato) {
                case "Habitación": {
                    lista = arch.buscar_habitacion(reporte.getTxtBusqueda().getText());
                    escribir_reporte(lista);
                    break;
                }
                case "Horas": {
                    ArrayList<Habitacion> lista1 = new ArrayList<>();
                    lista1 = arch.buscar_hora(reporte.getTxtBusqueda().getText());
                    escribir_reporte(lista1);
                    break;
                }
                case "Total por Horas": {

                    break;
                }
            }
        }
        if (e.getSource() == reserva.getBtnMenu()) {
            menu.setVisible(true);
            reserva.setVisible(false);
            reserva.getCmbDisponibles().removeAllItems();
        }
        if (e.getSource() == reserva.getBtnReservar()) {
            Archivo arch = new Archivo();
            int n = Integer.parseInt((String) reserva.getCmbDisponibles().getSelectedItem());
            int h;
            h = (Integer) (reserva.getSpnHoras().getValue());
            try {
                arch.escribir(n, h);
            } catch (IOException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Su reservación fue realizada con éxito...",
                    "RESERVACIÓN ÉXITOSA", JOptionPane.INFORMATION_MESSAGE);
            menu.setVisible(true);
            reserva.getCmbDisponibles().removeAllItems();
            reserva.setVisible(false);
        }
        if (e.getSource() == salida.getBtnMenu()) {
            menu.setVisible(true);
            salida.setVisible(false);
            salida.getCmbHabitacion().removeAllItems();
        }
        if (e.getSource() == salida.getBtnSalida()) {
            Archivo arch = new Archivo();
            int n = Integer.parseInt((String) salida.getCmbHabitacion().getSelectedItem());
            try {
                arch.cambiar(n, 0, "false");
            } catch (IOException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "La liberación de la habitación "
                    + "fue realizada con éxito...", "LIBERACIÓN ÉXITOSA",
                    JOptionPane.INFORMATION_MESSAGE);
            menu.setVisible(true);
            salida.getCmbHabitacion().removeAllItems();
            salida.setVisible(false);
        }

    }
}
