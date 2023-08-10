package com.example;

public interface IListsFunctionality {
    void addFirst(int data);
    void insert(int data, int index);
    void addLast(int data);
    int deleteFirst();
    int deleteElement(int index);
    int deleteLast();
    void replaceFirst(int newValue);
    void replace(int newValue, int index);
    void replaceLast(int newValue);
    int indexAt(int index);
    int sum();
    void show();
}
