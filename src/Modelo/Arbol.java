/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Arbol {

    // Root of Binary Tree 
    Nodo root;

    // Constructors 
    Arbol(int key) {
        root = new Nodo(key);
    }

    Arbol() {
        root = null;
    }

    // This method mainly calls insertRec() 
    void insert(int key) {
        root = insertRec(root, key);
    }

    /* A recursive function to insert a new key in BST */
    Nodo insertRec(Nodo root, int key) {

        /* If the tree is empty, return a new node */
        if (root == null) {
            root = new Nodo(key);
            return root;
        }

        /* Otherwise, recur down the tree */
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        /* return the (unchanged) node pointer */
        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST 
    void inorderRec(Nodo root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }
}
