package com.example;

public class TwoSidedList implements IListsFunctionality {
    public class Node {
        private int data;
        private Node next;
        private Node previous;

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

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public TwoSidedList() {
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

        if (this.getHead() != null) {
            this.getHead().setPrevious(node);
        }

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
        node.setPrevious(this.getTail());

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
        Node prevNodeAtIndex = new Node();
        int middle = this.getLength() / 2;
        if (index <= middle) {
            Node loopNode = this.getHead();
            for (int i = 1; i < index; i++) {
                if (i == index - 1) {
                    prevNode = loopNode;
                }
                loopNode = loopNode.getNext();
            }
            prevNodeAtIndex = prevNode.getNext();
        } else {
            Node loopNode = this.getTail();
            for (int i = this.getLength(); i > index - 1; i--) {
                if (i == index) {
                    prevNodeAtIndex = loopNode;
                }
                loopNode = loopNode.getPrevious();
            }
            prevNode = prevNodeAtIndex.getPrevious();
        }
        prevNode.setNext(node);
        node.setPrevious(prevNode);
        node.setNext(prevNodeAtIndex);
        prevNodeAtIndex.setPrevious(node);

        this.length++;
    }

    @Override
    public int deleteElement(int index) {
        if (index < 1 || index > this.getLength()) {
            return -1;
        }

        if (index == 1) {
            return this.deleteFirst();
        } else if (index == this.getLength()) {
            return this.deleteLast();
        }

        int middle = this.getLength() / 2;
        int counter;
        Node deletedNode;
        if (index <= middle) {
            deletedNode = this.getHead();
            counter = 1;
            while (counter < index) {
                deletedNode = deletedNode.getNext();
                counter++;
            }
        } else {
            deletedNode = this.getTail();
            counter = this.getLength();
            while (counter > index) {
                deletedNode = deletedNode.getPrevious();
                counter--;
            }
        }
        Node previousNode = deletedNode.getPrevious();
        Node nextNode = deletedNode.getNext();

        if (previousNode != null) {
            previousNode.setNext(nextNode);
        }
        if (nextNode != null) {
            nextNode.setPrevious(previousNode);
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
        if (this.getLength() != 0) {
            Node node = this.getTail();
            int value = node.getData();
            if (this.getLength() == 1) {
                this.setHead(null);
            }
            this.setTail(node.getPrevious());
            this.length--;
            return value;
        } else return -1;
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
    public void replace(int newValue, int index) {
        Node replaceNode;
        int middle = this.getLength() / 2;
        if (index <= middle) {
            replaceNode = this.getHead();
            for (int i = 1; i < index + 1; i++) {
                if (i == index) {
                    replaceNode.setData(newValue);
                    break;
                }
                replaceNode = replaceNode.getNext();
            }
        } else {
            replaceNode = this.getTail();
            for (int i = this.getLength(); i > index - 1; i--) {
                if (i == index) {
                    replaceNode.setData(newValue);
                    break;
                }
                replaceNode = replaceNode.getPrevious();
            }
        }
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