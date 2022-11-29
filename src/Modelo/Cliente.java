/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.HashMap;

public class Cliente {

    private BinarySearchTree cliente;
    private HashMap<String, String> clientes;

    public Cliente() {
        this.clientes = new HashMap<>();
        this.cliente = new BinarySearchTree();
    }

    public BinarySearchTree getCliente() {
        return cliente;
    }

    public void setCliente(BinarySearchTree cliente) {
        this.cliente = cliente;
    }

    public HashMap<String, String> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, String> clientes) {
        this.clientes = clientes;
    }

    public void guardarClienteHash(String nombre, String apellido, String telefono, String genero) {
        String key = nombre + " " + apellido;
        this.clientes.put(key, nombre + " " + apellido + " " + telefono + " " + genero);
    }

    public String buscarClienteHash(String key) {
        return this.clientes.get(key);
    }

    public void guardarClienteArbol(String nombre, String apellido, String telefono, String genero) {
        String key = nombre + " " + apellido;
        this.cliente.insert(key, nombre + " " + apellido + " " + telefono + " " + genero);
    }

    public String buscarClienteArbol(String key) {
        return this.cliente.search(key);
    }

    public void imprimirArbol() {
        if (this.cliente.getRoot() != null) {
            this.cliente.imprimirArbol(cliente.getRoot());
        }
    }

    public void imprimirTablaHash() {
        for (String key : this.clientes.keySet()) {
            System.out.println(key + ":" + this.clientes.get(key));
        }
    }

    
    
}
