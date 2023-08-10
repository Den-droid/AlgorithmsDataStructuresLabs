package com.example;

public class OneSidedList implements IListsFunctionality {
    private class Node {
        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public OneSidedList() {
        head = tail = null;
        length = 0;
    }

    public Node getHead() {
        return head;
    }

    private void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    private void setTail(Node tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    private void setLength(int length) {
        this.length = length;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node();
        node.setData(data);
        node.setNext(this.getHead());

        if (this.getLength() == 0) {
            this.setTail(node);
        }
        this.setHead(node);

        this.length++;
    }

    @Override
    public void addLast(int data) {
        Node node = new Node();
        node.setData(data);

        if (this.getTail() != null) {
            this.getTail().setNext(node);
        }

        if (length == 0) {
            this.setHead(node);
        }
        this.setTail(node);

        this.length++;
    }

    @Override
    public void insert(int data, int index) {
        if (index < 1 || index > this.getLength() + 1) {
            return;
        }
        if (index == 1) {
            this.addFirst(data);
            return;
        }
        if (index == this.getLength() + 1) {
            this.addLast(data);
            return;
        }
        Node node = new Node();
        node.setData(data);
        Node prevNode = new Node();
        Node loopNode = this.getHead();
        for (int i = 1; i < index; i++) {
            if (i == index - 1) {
                prevNode = loopNode;
            }
            loopNode = loopNode.getNext();
        }
        Node prevNodeAtIndex = prevNode.getNext();
        prevNode.setNext(node);
        node.setNext(prevNodeAtIndex);

        this.length++;
    }

    @Override
    public int deleteElement(int index) {
        if (index < 1 || index > this.getLength()) {
            return -1;
        }

        if (index == 1) {
            return this.deleteFirst();
        }

        Node prevDeletedNode = this.getHead();
        int counter = 1;
        while (counter < index - 1) {
            prevDeletedNode = prevDeletedNode.getNext();
            counter++;
        }
        Node deletedNode;

        deletedNode = prevDeletedNode.getNext();
        if (index == this.getLength()) {
            this.setTail(prevDeletedNode);
        } else {
            prevDeletedNode.setNext(deletedNode.getNext());
        }
        this.length--;
        return deletedNode.getData();
    }

    @Override
    public int deleteFirst() {
        if (this.getLength() != 0) {
            Node node = this.getHead();
            int value = node.getData();
            if (this.getLength() == 1) {
                this.setTail(null);
            }
            this.setHead(node.getNext());
            this.length--;
            return value;
        } else return -1;
    }

    @Override
    public int deleteLast() {
        return deleteElement(this.getLength());
    }

    @Override
    public void replace(int newValue, int index) {
        Node replaceNode = this.getHead();
        for (int i = 1; i < this.getLength() + 1; i++) {
            if (i == index) {
                replaceNode.setData(newValue);
                break;
            }
            replaceNode = replaceNode.getNext();
        }
    }

    @Override
    public void replaceFirst(int newValue) {
        this.getHead().setData(newValue);
    }

    @Override
    public void replaceLast(int newValue) {
        this.getTail().setData(newValue);
    }

    @Override
    public int indexAt(int value) {
        Node valueNode = this.getHead();
        int index = 0;
        for (int i = 1; i < this.getLength() + 1; i++) {
            if (valueNode.getData() == value) {
                index = i;
                break;
            }
            valueNode = valueNode.getNext();
        }
        return index;
    }

    @Override
    public int sum() {
        int sum = 0;
        for (Node node = this.getHead(); node.getNext() != null; node = node.getNext()) {
            sum += node.getData();
        }
        return sum;
    }

    @Override
    public void show() {
        for (Node node = this.getHead(); node.getNext() != null; node = node.getNext()) {
            System.out.print(node.getData() + " ");
        }
        System.out.println();
    }
}