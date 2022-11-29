/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
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
    VentanaBuscar buscar;
    VentanaRegistro registro;

    public Control(VentanaMenu menu, VentanaReporte reporte, VentanaReserva reserva, VentanaSalida salida, VentanaBuscar buscar, VentanaRegistro registro) {
        this.menu = menu;
        this.reporte = reporte;
        this.reserva = reserva;
        this.salida = salida;
        this.buscar = buscar;
        this.registro = registro;
    }

    public Control() {
        menu = new VentanaMenu();
        reporte = new VentanaReporte();
        reserva = new VentanaReserva();
        salida = new VentanaSalida();
        buscar = new VentanaBuscar();
        registro = new VentanaRegistro();
    }

    public void iniciar() {
        menu.setVisible(true);
        menu.getBtnReporte().addActionListener(this);
        menu.getBtnRerservar().addActionListener(this);
        menu.getBtnSalida().addActionListener(this);
        menu.getBtnBuscar().addActionListener(this);
        menu.getBtnRegistrar().addActionListener(this);
        reporte.getBtnMenu().addActionListener(this);
        reporte.getBtnBuscar().addActionListener(this);
        reserva.getBtnMenu().addActionListener(this);
        reserva.getBtnReservar().addActionListener(this);
        salida.getBtnMenu().addActionListener(this);
        salida.getBtnSalida().addActionListener(this);
        reserva.getRadioDisponibles().addActionListener(this);
        reserva.getRadioOcupadas().addActionListener(this);
        reserva.getRadioSi().addActionListener(this);
        reserva.getRadioNo().addActionListener(this);
        buscar.getBtnMenu().addActionListener(this);
        buscar.getBtnBuscar().addActionListener(this);
        buscar.getRadioHash().addActionListener(this);
        buscar.getRadioArbol().addActionListener(this);
        registro.getBtnRegistrar().addActionListener(this);
        registro.getRadioFemenino().addActionListener(this);
        registro.getRadioMasculino().addActionListener(this);
        registro.getBtnMenu().addActionListener(this);

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

    public void tablaProductos() {
        Archivo archivo = new Archivo();
        DefaultTableModel tabla = new DefaultTableModel();
        String[] fila = new String[3];
        pilaProductos pila = archivo.leerPila();
        tabla.addColumn("Producto");
        tabla.addColumn("Precio");
        tabla.addColumn("Cantidad");
        for (int i = 0; i < pila.size(); i++) {
            fila[0] = String.valueOf(pila.getPila().get(i).getNombre());
            fila[1] = String.valueOf(pila.getPila().get(i).getPrecio());
            fila[2] = String.valueOf(pila.getPila().get(i).getCantidad());
            reserva.getCmbProductos().addItem(fila[0]);
            tabla.addRow(fila);
        }
        reserva.getTblProductos().setModel(tabla);
    }

    public void tablaReporte() {
        Archivo arch = new Archivo();
        ArrayList<Habitacion> lista = arch.leer_reportes();
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

    public void tablaReserva() {
        Archivo archivo = new Archivo();
        ArrayList<Habitacion> lista = archivo.leer();
        DefaultTableModel tabla = new DefaultTableModel();
        String[] fila = new String[2];
        tabla.addColumn("N° Habitacion");
        tabla.addColumn("Disponibilidad");
        for (int i = 0; i < lista.size(); i++) {
            fila[0] = String.valueOf(lista.get(i).getNumero());
            if (lista.get(i).isDisponibilidad()) {
                fila[1] = "Ocupado";
                reserva.getCmbOcupadas().addItem(fila[0]);
            } else {
                fila[1] = "Disponible";
                reserva.getCmbDisponibles().addItem(fila[0]);
            }
            tabla.addRow(fila);
        }
        reserva.getTblHabitaciones().setModel(tabla);
    }

    public void tablaSalida() {
        Archivo archivo = new Archivo();
        ArrayList<Habitacion> lista = archivo.leer();
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

    public void buscar() {
        Archivo archivo = new Archivo();
        Cliente cliente = archivo.clientes();
        cliente.imprimirArbol();
        cliente.imprimirTablaHash();
        String key = buscar.getTxtApellido().getText() + " " + buscar.getTxtNombre().getText();
        if (cliente.getClientes().containsKey(key) || !cliente.buscarClienteArbol(key).isEmpty()) {
            DefaultTableModel tabla = new DefaultTableModel();
            String[] datos;
            if(buscar.getRadioHash().isSelected()){
                datos = cliente.buscarClienteHash(key).split(":");
            }
            else{
                datos = cliente.buscarClienteArbol(key).split(":");
            }
            String[] fila = datos[1].split(" ");
            tabla.addRow(fila);
            buscar.getTblCliente().setModel(tabla);
        }
        else{
            JOptionPane.showMessageDialog(null, "No se encontró el cliente buscado",
                        "Búsqueda Fallida", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menu.getBtnReporte()) {
            reporte.setVisible(true);
            menu.setVisible(false);
            tablaReporte();
        }
        if (e.getSource() == menu.getBtnRerservar()) {
            reserva.setVisible(true);
            menu.setVisible(false);
            tablaReserva();
            tablaProductos();
        }
        if (e.getSource() == menu.getBtnSalida()) {
            salida.setVisible(true);
            menu.setVisible(false);
            tablaSalida();
        }
        if (e.getSource() == reporte.getBtnMenu()) {
            menu.setVisible(true);
            reporte.setVisible(false);
        }
        if (e.getSource() == registro.getBtnMenu()) {
            menu.setVisible(true);
            registro.setVisible(false);
        }
        if (e.getSource() == buscar.getBtnMenu()) {
            menu.setVisible(true);
            buscar.setVisible(false);
        }
        if (e.getSource() == reporte.getBtnBuscar()) {
            String dato;
            dato = (String) reporte.getCmbReserva().getSelectedItem();
            Archivo arch = new Archivo();
            Habitacion lista;
            String dato1 = reporte.getTxtBusqueda().getText();
            switch (dato) {
                case "Habitación": {
                    if (Integer.parseInt(dato1) > 0 && Integer.parseInt(dato1) < 11) {
                        lista = arch.buscar_habitacion(dato1);
                        escribir_reporte(lista);
                    } else {
                        JOptionPane.showMessageDialog(null, "Esa habitación no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
                case "Horas": {
                    if (Integer.parseInt(dato1) > 0 && Integer.parseInt(dato1) <= 100) {
                        ArrayList<Habitacion> lista1 = arch.buscar_hora(dato1);
                        escribir_reporte(lista1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Esa hora no esta determinada en el sistema",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
                case "Total por Horas": {
                    if (Integer.parseInt(dato1) > 0 && Integer.parseInt(dato1) <= 100) {
                        ArrayList<Habitacion> lista1 = new ArrayList<>();
                        escribir_reporte(lista1);
                    } else {
                        JOptionPane.showMessageDialog(null, "Esa hora no esta determinada en el sistema",
                                "ERROR", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                }
            }
        }
        if (e.getSource() == reserva.getBtnMenu()) {
            menu.setVisible(true);
            reserva.setVisible(false);
            reserva.getCmbDisponibles().removeAllItems();
            reserva.getRadioOcupadas().setEnabled(true);
            reserva.getRadioDisponibles().setEnabled(true);
            reserva.getRadioSi().setEnabled(true);
            reserva.getRadioNo().setEnabled(true);
            reserva.getRadioOcupadas().setSelected(false);
            reserva.getRadioDisponibles().setSelected(false);
            reserva.getRadioSi().setSelected(false);
            reserva.getRadioNo().setSelected(false);
        }
        if (e.getSource() == reserva.getBtnReservar()) {
            Archivo arch = new Archivo();
            if (reserva.getRadioDisponibles().isSelected()) {
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
            } else {
                int n = Integer.parseInt((String) reserva.getCmbOcupadas().getSelectedItem());
                int h;
                h = (Integer) (reserva.getSpnHoras().getValue());

            }
            menu.setVisible(true);
            reserva.getCmbDisponibles().removeAllItems();
            reserva.getCmbOcupadas().removeAllItems();
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
        if (e.getSource() == reserva.getRadioDisponibles()) {
            reserva.getRadioOcupadas().setSelected(false);
            reserva.getCmbOcupadas().setEnabled(false);
            reserva.getCmbDisponibles().setEnabled(true);
        }
        if (e.getSource() == reserva.getRadioOcupadas()) {
            reserva.getRadioDisponibles().setSelected(false);
            reserva.getCmbDisponibles().setEnabled(false);
            reserva.getCmbOcupadas().setEnabled(true);
        }
        if (e.getSource() == reserva.getRadioSi()) {
            reserva.getRadioNo().setSelected(false);
            reserva.getCmbProductos().setEnabled(true);

        }
        if (e.getSource() == reserva.getRadioNo()) {
            reserva.getRadioSi().setSelected(false);
            reserva.getCmbProductos().setEnabled(false);
        }
        if (e.getSource() == menu.getBtnBuscar()) {
            buscar.setVisible(true);
            menu.setVisible(false);
        }
        if (e.getSource() == menu.getBtnRegistrar()) {
            registro.setVisible(true);
            menu.setVisible(false);
        }
        if (e.getSource() == buscar.getBtnBuscar()) {
            if (buscar.getTxtNombre().getText().isEmpty()
                    || buscar.getTxtApellido().getText().isEmpty()
                    || (!buscar.getRadioArbol().isSelected()
                    && !buscar.getRadioHash().isSelected())) {
                JOptionPane.showMessageDialog(null, "Hay un campo vacío\n Vuelve a intentar",
                        "Búsqueda Fallida", JOptionPane.INFORMATION_MESSAGE);
            } else {
                buscar();
            }

            buscar.getTxtNombre().setText("");
            buscar.getTxtApellido().setText("");
            buscar.getRadioHash().setSelected(false);
            buscar.getRadioArbol().setSelected(false);

        }
        if (e.getSource() == buscar.getRadioArbol()) {
            buscar.getRadioHash().setSelected(false);
        }
        if (e.getSource() == buscar.getRadioHash()) {
            buscar.getRadioArbol().setSelected(false);
        }
        if (e.getSource() == registro.getBtnRegistrar()) {
            boolean valido = true;
            String mensaje = "";
            String datos[] = new String[3];
            datos[0] = registro.getTxtNombre().getText();
            datos[1] = registro.getTxtApellido().getText();
            datos[2] = registro.getTxtTelefono().getText();
            for (String dato : datos) {
                if (dato.isEmpty()) {
                    valido = false;
                    break;
                } else {
                    mensaje += dato + ",";
                }
            }
            if (!registro.getRadioFemenino().isSelected()
                    && !registro.getRadioMasculino().isSelected()) {
                valido = false;
            } else if (registro.getRadioFemenino().isSelected()) {
                mensaje += "Femenino";
            } else {
                mensaje += "Masculino";
            }

            if (valido) {
                Archivo archivo = new Archivo();
                archivo.leerCliente(mensaje);
                JOptionPane.showMessageDialog(null, "El cliente ha sido registrado exitosamente",
                        "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Hay un campo vacío\n Vuelve a intentar",
                        "Registro Fallido", JOptionPane.INFORMATION_MESSAGE);
            }
            registro.getTxtNombre().setText("");
            registro.getTxtApellido().setText("");
            registro.getTxtTelefono().setText("");
            registro.getRadioFemenino().setSelected(false);
            registro.getRadioMasculino().setSelected(false);
        }
        if (e.getSource() == registro.getRadioFemenino()) {
            registro.getRadioMasculino().setSelected(false);
        }
        if (e.getSource() == registro.getRadioMasculino()) {
            registro.getRadioFemenino().setSelected(false);
        }
    }

}
