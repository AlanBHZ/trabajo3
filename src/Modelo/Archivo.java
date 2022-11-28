/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
            FileWriter file = new FileWriter(nombre + ".txt", true);
            file.write(linea);
        } catch (IOException ex) {
            Logger.getLogger(Archivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void buscar(String nombre) {
        
    }

    public void insertar(String nombre) {

    }

    public void ordenar(String nombre) {

    }

    public void eliminar(String nombre) {

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
}
