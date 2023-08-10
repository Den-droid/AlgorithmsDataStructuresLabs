package com.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("Red black tree:");
        test(new RedBlackTree());
//        System.out.println("AVL tree: ");
//        test(new AVLTree());
    }

    public static void test(IBalancedTrees tree) {
        IBalancedTrees itree = tree;

        long addTimeStart = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            itree.insert(i);
        }
        long addTime = System.currentTimeMillis() - addTimeStart;

        long deleteTimeStart = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            itree.delete(i);
        }
        long deleteTime = System.currentTimeMillis() - deleteTimeStart;


        for (int i = 0; i < 1000000; i++) {
            itree.insert(i);
        }
        long searchTimeStart = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            itree.search(i);
        }
        long searchTime = System.currentTimeMillis() - searchTimeStart;

        System.out.println("Add time (1000000 elements): " + addTime + " ms");
        System.out.println("Remove time (1000000 elements): " + deleteTime + " ms");
        System.out.println("Search time (1000000 elements): " + searchTime + " ms");
    }
}
