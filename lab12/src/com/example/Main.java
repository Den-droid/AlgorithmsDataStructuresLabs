package com.example;

public class Main {

    public static void main(String[] args) {
        BinaryHeap heap = new BinaryHeap(100000);
        long addTime = System.currentTimeMillis();
        for (int i = 100000; i > 0; i--) {
            heap.insertItem(i);
        }
        addTime = System.currentTimeMillis() - addTime;

        long searchTime = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            heap.find(i);
        }
        searchTime = System.currentTimeMillis() - searchTime;

        long getSortedTime = System.currentTimeMillis();
        int[] sorted = heap.getSorted();
        getSortedTime = System.currentTimeMillis() - getSortedTime;

//        long removeTime = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            heap.deleteItem(i);
//        }
//        removeTime = System.currentTimeMillis() - removeTime;

        System.out.println("Add time 100000 elements: " + addTime + " ms");
        System.out.println("Search time 100000 elements: " + searchTime + " ms");
        System.out.println("Remove time 100000 elements: " + getSortedTime + " ms");

//        for (int i = 0; i < 10; i++) {
//            heap.insertItem(i);
//        }
//        heap.insertItem(20);
//        for (int i = 10; i < 15; i++) {
//            heap.insertItem(i);
//        }
//        for(int elem : heap.getSorted()){
//            System.out.println(elem);
//        }
    }
}
