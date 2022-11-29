/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Nodo {
    int key; 
    Nodo left, right; 
  
    public Nodo(int item) 
    { 
        key = item; 
        left = right = null; 
    } 
}
