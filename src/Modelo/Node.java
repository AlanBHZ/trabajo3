/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

class Node {

    private String key;
    private String value;
    private Node left;
    private Node right;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void insert(String key, String value) {
        if (key.compareTo(this.key) < 0) {
            if (this.left == null) {
                this.left = new Node(key, value);
            } else {
                this.left.insert(key, value);
            }
        } else if (key.compareTo(this.key) > 0) {
            if (this.right == null) {
                this.right = new Node(key, value);
            } else {
                this.right.insert(key, value);
            }
        }
    }

    public String search(String key) {
        if (key.equals(this.key)) {
            return this.value;
        } else if (key.compareTo(this.key) < 0) {
            if (this.left == null) {
                return null;
            } else {
                return this.left.search(key);
            }
        } else {
            if (this.right == null) {
                return null;
            } else {
                return this.right.search(key);
            }
        }
    }
}
