package com.example.classes;

import com.example.interfaces.IReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader implements IReader {
    @Override
    public String read(String filename) {
        StringBuilder str = new StringBuilder();
        String temp;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((temp = reader.readLine()) != null) {
                str.append(temp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str.toString();
    }
}