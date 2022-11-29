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
        return searchRec(root, key);
    }

    //Metodo para buscar recursivamente
    String searchRec(Node root, String key) {
        if (root == null) {
            return null;
        }
        if (key.equals(root.getKey())) {
            return root.getValue();
        }

        if (key.compareTo(root.getKey()) < 0) {
            return searchRec(root.getLeft(), key);
        }

        return searchRec(root.getRight(), key);
    }

    public void imprimirArbol(Node node) {
        if (node != null) {
            this.imprimirArbol(node.getLeft());
            System.out.println(node.getKey() + " : " + node.getValue());
            this.imprimirArbol(node.getRight());
        }
    }
}
