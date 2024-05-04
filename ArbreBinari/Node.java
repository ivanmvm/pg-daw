package com.arbrebinari;

class Node<T> implements AutoCloseable {
    T data;
    Node<T> left;
    Node<T> right;
    int depth;

    Node(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.depth = 1;
    }

    @Override
    public void close() {
        System.out.println("Node eliminat per el Garbage Collector");
    }
}
