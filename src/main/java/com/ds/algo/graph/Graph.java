package com.ds.algo.graph;

import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class Graph<T> {
    private Map<T, List<T>> adjList = new HashMap<>();
    private Map<T, Map<T, Integer>> adjMatrix = new HashMap<>();
    private boolean isDirected;

    // Constructor: Pass true if graph is directed
    public Graph(boolean isDirected) {
        this.isDirected = isDirected;
    }

    //Add edge for Adjacency List
    public void addEdgeList(T src, T dest) {
        adjList.putIfAbsent(src, new ArrayList<>());
        adjList.putIfAbsent(dest, new ArrayList<>());
        adjList.get(src).add(dest);
        if (!isDirected)
            adjList.get(dest).add(src);
    }

    //Add edge for Adjacency Matrix
    public void addEdgeMatrix(T src, T dest, int weight) {
        adjMatrix.putIfAbsent(src, new HashMap<>());
        adjMatrix.putIfAbsent(dest, new HashMap<>());
        adjMatrix.get(src).put(dest, weight);
        if (!isDirected)
            adjMatrix.get(dest).put(src, weight);
    }
}
