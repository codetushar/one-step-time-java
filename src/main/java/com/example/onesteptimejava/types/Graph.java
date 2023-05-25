package com.example.onesteptimejava.types;

import java.util.*;

public class Graph {
    public HashMap<Integer, ArrayList<Integer>> outputs = new HashMap<>();

    public Graph() {

    }

    public Graph(HashMap<Integer, ArrayList<Integer>> outputs) {
        super();
        this.outputs = outputs;
    }

    public HashMap<Integer, ArrayList<Integer>> getGraph() {
        return this.outputs;
    }

    public void setGraph(HashMap<Integer, ArrayList<Integer>> outputs) {
        this.outputs = outputs;
    }
}
