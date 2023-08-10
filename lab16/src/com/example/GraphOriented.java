package com.example;

import java.util.*;

public class GraphOriented {
    Map<Vertex, List<Vertex>> adjVertices;
    boolean isOriented = true;

    public boolean isOriented() {
        return isOriented;
    }

    public void setOriented(boolean oriented) {
        isOriented = oriented;
    }

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }

    public GraphOriented() {
        adjVertices = new HashMap<>();
    }

    public void createGraph() {
        for (int i = 0; i <= 20; i++) {
            this.addVertex(i);
        }
        this.addEdge(0, 1);
        this.addEdge(0, 2);
        this.addEdge(1, 5);
        this.addEdge(1, 6);
        this.addEdge(1, 7);
        this.addEdge(2, 3);
        this.addEdge(2, 4);
        this.addEdge(3, 4);
        this.addEdge(3, 10);
        this.addEdge(4, 11);
        this.addEdge(5, 9);
        this.addEdge(6, 8);
        this.addEdge(6, 17);
        this.addEdge(7, 17);
        this.addEdge(8, 14);
        this.addEdge(8, 15);
        this.addEdge(9, 3);
        this.addEdge(10, 13);
        this.addEdge(11, 12);
        this.addEdge(12, 20);
        this.addEdge(13, 12);
        this.addEdge(14, 13);
        this.addEdge(16, 15);
        this.addEdge(16, 18);
        this.addEdge(17, 16);
        this.addEdge(18, 19);
        this.addEdge(19, 13);
        this.addEdge(20, 19);
    }

    public void addVertex(int number) {
        adjVertices.putIfAbsent(new Vertex(number), new ArrayList<>());
    }

    public void removeVertex(int number) {
        Vertex v = new Vertex(number);
        adjVertices.values().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(number));
    }

    public void addEdge(int from, int to) {
        Vertex v1 = new Vertex(from);
        Vertex v2 = new Vertex(to);
        adjVertices.get(v1).add(v2);
    }

    public void removeEdge(int from, int to) {
        Vertex v1 = new Vertex(from);
        Vertex v2 = new Vertex(to);
        List<Vertex> eV1 = adjVertices.get(v1);
        if (eV1 != null)
            eV1.remove(v2);
    }

    public List<Vertex> getAdjustmentVerticesFull(int number) {
        List<Vertex> adjustments = getAdjVertices(number);
        for (Map.Entry<Vertex, List<Vertex>> elem : adjVertices.entrySet()) {
            if (elem.getValue().contains(new Vertex(number))) {
                adjustments.add(elem.getKey());
            }
        }
        return adjustments;
    }

    public void getBasic() {
        System.out.println("Vertices count: " + getVertexCount());
        System.out.println("Edges count: " + getEdgesCount());
        System.out.println("Degree count: " + getDegreeCount());
    }

    public int getDegreeCount() {
        return getEdgesCount() * 2;
    }

    public int getEdgesCount() {
        final int[] sum = new int[]{0};
        adjVertices.forEach((key, value) -> sum[0] += value.size());
        return sum[0];
    }

    public int getVertexCount() {
        return adjVertices.size();
    }

    public List<Vertex> getAdjVertices(int number) {
        return adjVertices.get(new Vertex(number));
    }

    public void testFullGraph(){
        GraphOriented graphOriented = new GraphOriented();
        graphOriented.createGraph();
        graphOriented.getBasic();

        GraphTraversal.setNonOriented(graphOriented);
        Set<Integer> integers = new HashSet<>();

        long ms = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            integers = GraphTraversal.depthFirstTraversal(graphOriented, 0);
        }
        ms = System.currentTimeMillis() - ms;
        System.out.println("1000 depth-first search (" + graphOriented.getEdgesCount() + " edges): " +
                ms + " ms");
        integers.forEach(e -> System.out.print(e + " "));

        ms = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            integers = GraphTraversal.breadthFirstTraversal(graphOriented, 0);
        }
        ms = System.currentTimeMillis() - ms;
        System.out.println("\n1000 breadth-first search (" + graphOriented.getEdgesCount() + " edges): " +
                ms + " ms");
        integers.forEach(e -> System.out.print(e + " "));
    }

    public void testGraphWithLessEdges(){
        GraphOriented graphOriented2 = new GraphOriented();
        graphOriented2.createGraph();

        for (int i = 0; i < 7; i++) {
            graphOriented2.removeVertex(i);
        }
        graphOriented2.getBasic();

        GraphTraversal.setNonOriented(graphOriented2);
        Set<Integer> integers = new HashSet<>();

        long ms = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            integers = GraphTraversal.depthFirstTraversal(graphOriented2, 7);
        }
        ms = System.currentTimeMillis() - ms;
        System.out.println("1000 depth-first search (" + graphOriented2.getEdgesCount() + " edges): " +
                ms + " ms");
        integers.forEach(e -> System.out.print(e + " "));

        ms = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            integers = GraphTraversal.breadthFirstTraversal(graphOriented2, 7);
        }
        ms = System.currentTimeMillis() - ms;
        System.out.println("\n1000 breadth-first search (" + graphOriented2.getEdgesCount() + " edges): " +
                ms + " ms");
        integers.forEach(e -> System.out.print(e + " "));
    }

    public static void main(String[] args) {
        GraphOriented graphOriented = new GraphOriented();
        graphOriented.testFullGraph();
        System.out.println("\n\nTest graph with less edges:");
        graphOriented.testGraphWithLessEdges();

        GraphOriented graphOriented3 = new GraphOriented();
        graphOriented3.createGraph();
        System.out.println("\n\nTest adjustment vertices to vertex 6:");
        graphOriented3.getAdjustmentVerticesFull(6).forEach(e -> System.out.print(e.number + " "));
    }
}
