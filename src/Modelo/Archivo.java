/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Archivo {

    public Archivo() {
    }

    public boolean crear(String nombre) {
        File f = new File(nombre + ".txt");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        } else {
            return false;
        }
    }

    public void agregar(String nombre, String linea) {
        try {
            FileWriter writer = new FileWriter(nombre + ".txt");
            PrintWriter salida = new PrintWriter(writer);
            salida.print(linea);
            salida.close();
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Habitacion buscar_habitacion(String habitacion) {
        Habitacion hab = new Habitacion();
        try {
            File archivo = new File("Alquiler.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int numero = 0;
            int entrada = 0;
            int precio = 0;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split(",");
                if (data[1].equals(habitacion)) {
                    numero = Integer.parseInt(data[1]);
                    entrada += Integer.parseInt(data[9]);
                    precio += Integer.parseInt(data[11]);
                }
            }
            br.close();
            hab.setNumero(numero);
            hab.setEntrada(entrada);
            hab.setPrecio(precio);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hab;
    }

    public ArrayList<Habitacion> buscar_hora(String hora) {
        ArrayList<Habitacion> reporte = new ArrayList<>();
        try {
            File archivo = new File("Alquiler.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int numero = 0;
            int entrada = 0;
            int precio = 0;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split(",");
                if (data[9].equals(hora)) {
                    numero = Integer.parseInt(data[1]);
                    entrada = Integer.parseInt(data[9]);
                    precio = Integer.parseInt(data[11]);
                    Habitacion hab = new Habitacion();
                    hab.setNumero(numero);
                    hab.setEntrada(entrada);
                    hab.setPrecio(precio);
                    reporte.add(hab);
                }
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reporte;
    }

    public boolean eliminarArchivo(String nombre) {
        File f = new File(nombre + ".txt");
        if (f.exists()) {
            f.delete();
            return true;
        } else {
            return false;
        }
    }

    public void leer_reporte(String escribir) {
        String datos = escribir;
        try {
            File archivo = new File("Alquiler.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                datos += "\n" + linea;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        agregar("Alquiler", datos);
    }

    public void leerCliente(String escribir) {
        String datos = escribir;
        try {
            File archivo = new File("Clientes.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                datos += "\n" + linea;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        agregar("Clientes", datos);
    }
    public Cliente clientes(){
        Cliente cli = new Cliente();
        try {
            File archivo = new File("Clientes.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split(",");
                cli.guardarClienteArbol(data[0], data[1], data[2], data[3]);
                cli.guardarClienteHash(data[0], data[1], data[2], data[3]);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cli;
    }
    public void colaReservas(String escribir) {
        String datos = escribir;
        try {
            File archivo = new File("Reservadas.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                datos += "\n" + linea;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        agregar("Reservadas", datos);
    }

    public ArrayList<Habitacion> leer_reportes() {
        ArrayList<Habitacion> reporte = new ArrayList<>();
        try {
            File archivo = new File("Alquiler.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] data = linea.split(",");
                Habitacion hab = new Habitacion();
                hab.setNumero(Integer.parseInt(data[1]));
                hab.setEntrada(Integer.parseInt(data[9]));

                hab.setPrecio(Integer.parseInt(data[11]));
                reporte.add(hab);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reporte;
    }

    public ArrayList<Habitacion> leer() {
        ArrayList<Habitacion> lista = new ArrayList<>();
        try {
            File archivo = new File("habitaciones.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                Habitacion hab = new Habitacion();
                String[] data = linea.split(",");
                hab.setNumero(Integer.parseInt(data[0]));
                hab.setDisponibilidad(Boolean.valueOf(data[1]));
                lista.add(hab);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public pilaProductos leerPila() {
        pilaProductos pila = new pilaProductos();
        try {
            File archivo = new File("Productos.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                Producto p = new Producto();
                String[] data = linea.split(",");
                p.setNombre(data[0]);
                p.setCantidad(Integer.parseInt(data[1]));
                p.setPrecio(Double.parseDouble(data[2]));
                pila.getPila().add(p);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pila;
    }

    public void cambiar(int n, int h, String dispo) throws FileNotFoundException, IOException {
        File archivo = new File("habitaciones.txt");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        String linea;
        String datos = "";
        int i = 0;
        while ((linea = br.readLine()) != null) {
            if (i < 10) {
                String[] data = linea.split(",");
                try {
                    FileWriter writer = new FileWriter("habitaciones.txt");
                    PrintWriter salida = new PrintWriter(writer);
                    if (n == Integer.parseInt(data[0])) {
                        datos += data[0] + "," + dispo + "\n";
                    } else if (n == Integer.parseInt(data[0]) && Integer.parseInt(data[0]) == 10) {
                        datos += data[0] + "," + dispo;
                    } else if (Integer.parseInt(data[0]) == 10) {
                        datos += linea;
                    } else if (Integer.parseInt(data[0]) != 10) {
                        datos += linea + "\n";
                    }
                    salida.print(datos);
                    salida.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                i++;
            }
        }
        fr.close();
        br.close();
    }

    public void escribir(int n, int h) throws FileNotFoundException, IOException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");
        String fechaActual = formatter.format(date);
        String horaActual = formatter1.format(date);
        cambiar(n, h, "true");
        try {
            Date horaActual1 = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
            horaActual1.setHours(horaActual1.getHours() + h);
            int precio = 0;
            if (n <= 5) {
                switch (h) {
                    case 1:
                        precio = 15;
                        break;
                    case 2:
                        precio = 20;
                        break;
                    case 3:
                        precio = 30;
                        break;
                    default:
                        precio = h * 20;
                        break;
                }
            } else if (n >= 5) {
                switch (h) {
                    case 1:
                        precio = 25;
                        break;
                    case 2:
                        precio = 35;
                        break;
                    case 3:
                        precio = 50;
                        break;
                    default:
                        precio = h * 30;
                        break;
                }
            }
            String dato = "";
            dato += "Numero_habitación," + n + ",Fecha," + fechaActual
                    + ",Hora_de_inicio," + horaActual + ",Hora_de_salida,"
                    + formato.format(horaActual1) + ",Hora_estadia," + h
                    + ",Precio_final," + precio;
            leer_reporte(dato);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void escribirReserva(int n, int h) throws FileNotFoundException, IOException {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss");
        String fechaActual = formatter.format(date);
        String horaActual = formatter1.format(date);
        cambiar(n, h, "true");
        try {
            Date horaActual1 = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("HH:mm:ss");
            horaActual1.setHours(horaActual1.getHours() + h);
            int precio = 0;
            if (n <= 5) {
                switch (h) {
                    case 1:
                        precio = 15;
                        break;
                    case 2:
                        precio = 20;
                        break;
                    case 3:
                        precio = 30;
                        break;
                    default:
                        precio = h * 20;
                        break;
                }
            } else if (n >= 5) {
                switch (h) {
                    case 1:
                        precio = 25;
                        break;
                    case 2:
                        precio = 35;
                        break;
                    case 3:
                        precio = 50;
                        break;
                    default:
                        precio = h * 30;
                        break;
                }
            }
            String dato = "";
            dato += "Numero_habitación," + n + ",Fecha," + fechaActual
                    + ",Hora_de_inicio," + horaActual + ",Hora_de_salida,"
                    + formato.format(horaActual1) + ",Hora_estadia," + h
                    + ",Precio_final," + precio;
            leer_reporte(dato);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
