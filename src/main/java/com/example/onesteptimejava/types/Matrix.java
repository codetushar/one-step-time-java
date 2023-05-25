package com.example.onesteptimejava.types;

import java.util.*;

public class Matrix {
    public List<List<Integer>> inputs = new ArrayList<List<Integer>>();

    public Matrix() {

    }

    public Matrix(List<List<Integer>> inputs) {
        super();
        this.inputs = inputs;
    }

    public List<List<Integer>> getMatrix() {
        return this.inputs;
    }

    public void setMatrix(List<List<Integer>> inputs) {
        this.inputs = inputs;
    }
}
