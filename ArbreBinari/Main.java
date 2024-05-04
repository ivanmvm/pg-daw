package com.arbrebinari;

public class Main {
    public static void main(String[] args) {
        // A. Crear 2 Arbres d'enters de fondaria 5
        ArbreBinari<Integer> intTree1 = new ArbreBinari<>(5);
        ArbreBinari<Integer> intTree2 = new ArbreBinari<>(5);

        for (int i = 1; i <= 31; i++) {
            intTree1.insert(i);
            intTree2.insert(i);
        }

        // B. Mostrar quantes instancies existeixen d'arbres
        System.out.println("\nInstàncies d'arbres: " + ArbreBinari.getInstanceCount());

        // C. Crear 2 Arbres de caràcters de fondaria 3
        ArbreBinari<Character> charTree1 = new ArbreBinari<>(3);
        ArbreBinari<Character> charTree2 = new ArbreBinari<>(3);

        for (char c = 'a'; c <= 'o'; c++) {
            charTree1.insert(c);
            charTree2.insert(c);
        }

        // D. Mostrar quantes instancies existeixen d'arbres
        System.out.println("\nInstàncies d'arbres: " + ArbreBinari.getInstanceCount());

        // E. Forçar al Garbage Collector
        System.gc();

        // F. Recorrer el primer arbre d'enters i mostrant els valors per pantalla, fent servir unica i exclusivament les branques dretes
        System.out.print("\nRecorregut de intTree1 per la rama dreta: ");
        intTree1.traverseRightBranch();

        // G. Recorrer el segon arbre d'enters i mostrant els valors per pantalla, fent servir unica i exclusivament les branques esquerres
        System.out.print("\nRecorregut de intTree2 per la rama esquerra: ");
        intTree2.traverseLeftBranch();

        // H. Tornar a mostrar quantes instancies existeixen
        System.out.println("\nInstàncies d'arbres: " + ArbreBinari.getInstanceCount());

        // I. Tornar a forçar al Garbage Collector
        System.gc();

        // J. Tornar a mostrar quantes instancies existeixen
        System.out.println("\nInstàncies d'arbres: " + ArbreBinari.getInstanceCount());
    }
}
