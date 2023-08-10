package com.example;

import com.example.classes.Reader;
import com.example.classes.Searcher;
import com.example.interfaces.IReader;
import com.example.interfaces.ISearcher;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        IReader reader = new Reader();
        ISearcher searcher = new Searcher();
        String text = reader.read("files\\text.txt");
        String pattern = reader.read("files\\pattern.txt");
        long ms = System.currentTimeMillis();
        ArrayList<Integer> res = searcher.search(text, pattern);
        ms = System.currentTimeMillis() - ms;
        System.out.println("Number of \"" + pattern + "\" in text: " + res.size());
        for(int elem : res){
            System.out.print(elem + " ");
        }
        System.out.println();
        System.out.println("Time: " + ms + " ms");
    }
}
