/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insert(String key, String value) {
        if (this.root == null) {
            this.root = new Node(key, value);
        } else {
            this.root.insert(key, value);
        }
    }

    public String search(String key) {
        if (this.root == null) {
            return null;
        } else {
            return this.root.search(key);
        }
    }

    public void imprimirArbol(Node node) {
        if (node != null) {
            this.imprimirArbol(node.getLeft());
            System.out.println(node.getKey() + " : " + node.getValue());
            this.imprimirArbol(node.getRight());
        }
    }
}
