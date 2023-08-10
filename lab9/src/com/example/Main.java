package com.example;

public class Main {

    public static void main(String[] args) {
        System.out.println("One sided list: \n");
        test(new OneSidedList());
        System.out.println("Two sided list: \n");
        test(new TwoSidedList());
        System.out.println("ArrayList: \n");
        test(new MyArrayList());
    }

    public static void test(IListsFunctionality listInterface) {
        IListsFunctionality list = listInterface;

        for (int i = 0; i < 1000; i++) {
            list.addFirst(i * 3);
        }

        long addFirstTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.addFirst(i + 1);
        }
        addFirstTime = System.nanoTime() - addFirstTime;

        long insertTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.insert(i + 2, 500);
        }
        insertTime = System.nanoTime() - insertTime;

        long addLastTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.addLast(i + 3);
        }
        addLastTime = System.nanoTime() - addLastTime;

        long deleteFirstTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.deleteFirst();
        }
        deleteFirstTime = System.nanoTime() - deleteFirstTime;

        long deleteTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.deleteElement(500);
        }
        deleteTime = System.nanoTime() - deleteTime;

        long deleteLastTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.deleteLast();
        }
        deleteLastTime = System.nanoTime() - deleteLastTime;

        long replaceFirstTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.replaceFirst(i + 3);
        }
        replaceFirstTime = System.nanoTime() - replaceFirstTime;

        long replaceTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.replace(i + 3, i);
        }
        replaceTime = System.nanoTime() - replaceTime;

        long replaceLastTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.replaceLast(i + 3);
        }
        replaceLastTime = System.nanoTime() - replaceLastTime;

        long indexAtTime = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            list.indexAt(i);
        }
        indexAtTime = System.nanoTime() - indexAtTime;

        long sumTime = System.nanoTime();
        list.sum();
        sumTime = System.nanoTime() - sumTime;

        System.out.println("Add first time: " + addFirstTime + " ns");
        System.out.println("Add inside time: " + insertTime + " ns");
        System.out.println("Add last time: " + addLastTime + " ns");
        System.out.println();
        System.out.println("Delete first time: " + deleteFirstTime + " ns");
        System.out.println("Delete inside time: " + deleteTime + " ns");
        System.out.println("Delete last time: " + deleteLastTime + " ns");
        System.out.println();
        System.out.println("Replace first time: " + replaceFirstTime + " ns");
        System.out.println("Replace inside time: " + replaceTime + " ns");
        System.out.println("Replace last time: " + replaceLastTime + " ns");
        System.out.println();
        System.out.println("Index at time: " + indexAtTime + " ns");
        System.out.println("Sum time: " + sumTime + " ns");
        System.out.println();
    }
}