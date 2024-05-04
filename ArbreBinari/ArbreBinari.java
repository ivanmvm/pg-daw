package com.arbrebinari;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Set;

public class ArbreBinari<T> {
    private static int instanceCount = 0;
    private static final Set<PhantomReference<ArbreBinari<?>>> phantomRefs = new HashSet<>();
    private static final ReferenceQueue<ArbreBinari<?>> refQueue = new ReferenceQueue<>();

    private Node<T> root;

    public ArbreBinari(int depth) {
        instanceCount++;
        PhantomReference<ArbreBinari<?>> phantomRef = new PhantomReference<>(this, refQueue);
        phantomRefs.add(phantomRef);
    }

    public static int getInstanceCount() {
        processPhantomRefs();
        return instanceCount;
    }

    private static void processPhantomRefs() {
        PhantomReference<?> phantomRef;
        while ((phantomRef = (PhantomReference<?>) refQueue.poll()) != null) {
            phantomRefs.remove(phantomRef);
            instanceCount--;
            System.out.println("Una instància d'arbre ha estat eliminada. Instàncies restants: " + instanceCount);
        }
    }

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node<T> insertRecursive(Node<T> node, T value) {
        if (node == null) {
            return new Node<>(value);
        }

        if (value.hashCode() < node.value.hashCode()) {
            node.left = insertRecursive(node.left, value);
        } else if (value.hashCode() > node.value.hashCode()) {
            node.right = insertRecursive(node.right, value);
        }

        return node;
    }

    public void remove(T value) {
        root = removeRecursive(root, value);
    }

    private Node<T> removeRecursive(Node<T> node, T value) {
        if (node == null) {
            return null;
        }

        if (value.hashCode() < node.value.hashCode()) {
            node.left = removeRecursive(node.left, value);
        } else if (value.hashCode() > node.value.hashCode()) {
            node.right = removeRecursive(node.right, value);
        } else {
            // Cas 1: Node fill (sense fills)
            if (node.left == null && node.right == null) {
                return null;
            }

            // Cas 2: Node amb un fill
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            // Caso 3: Nodo con dos hijos
            Node<T> minNode = findMinNode(node.right);
            node.value = minNode.value;
            node.right = removeRecursive(node.right, minNode.value);
        }

        return node;
    }

    private Node<T> findMinNode(Node<T> node) {
        if (node.left == null) {
            return node;
        }
        return findMinNode(node.left);
    }

    public void traverseRightBranch() {
        traverseRightBranchRecursive(root);
    }

    private void traverseRightBranchRecursive(Node<T> node) {
        if (node != null) {
            traverseRightBranchRecursive(node.right);
            System.out.print(node.value + " ");
        }
    }

    public void traverseLeftBranch() {
        traverseLeftBranchRecursive(root);
    }

    private void traverseLeftBranchRecursive(Node<T> node) {
        if (node != null) {
            System.out.print(node.value + " ");
            traverseLeftBranchRecursive(node.left);
        }
    }

    private static class Node<T> {
        T value;
        Node<T> left;
        Node<T> right;

        Node(T value) {
            this.value = value;
        }
    }
}