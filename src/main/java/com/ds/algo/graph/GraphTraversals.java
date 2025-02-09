package com.ds.algo.graph;

import java.util.*;

public class GraphTraversals<T> {

    //DFS using Adjacency List
    public List<T> dfsList(Graph<T> graph, T start) {
        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        dfsHelper(graph.getAdjList(), start, visited, result);
        return result;
    }

    private void dfsHelper(Map<T, List<T>> adjList, T start, Set<T> visited, List<T> result) {
        if (!visited.contains(start)) {
            visited.add(start);
            result.add(start);
            for (T neighbour : adjList.getOrDefault(start, new ArrayList<>())) {
                dfsHelper(adjList, neighbour, visited, result);
            }
        }
    }

    //BFS using Adjacency List
    public List<T> bfsList(Graph<T> graph, T start) {
        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        while (!queue.isEmpty()) {
            T node = queue.poll();
            result.add(node);
            for (T neighbour : graph.getAdjList().getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }
        return result;
    }

    //DFS using Adjacency Matrix
    public List<T> dfsMatrix(Graph<T> graph, T start) {
        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        dfsMatrixHelper(graph.getAdjMatrix(), start, visited, result);
        return result;
    }

    private void dfsMatrixHelper(Map<T, Map<T, Integer>> adjMatrix, T node, Set<T> visited, List<T> result) {
        if (!visited.contains(node)) {
            visited.add(node);
            result.add(node);
            for (T neighbour : adjMatrix.getOrDefault(node, new HashMap<>()).keySet()) {
                dfsMatrixHelper(adjMatrix, neighbour, visited, result);
            }
        }
    }

    //BFS using Adjacency Matrix
    public List<T> bfsMatrix(Graph<T> graph, T start) {
        List<T> result = new ArrayList<>();
        Set<T> visited = new HashSet<>();
        Queue<T> queue = new LinkedList<>();
        visited.add(start);
        queue.offer(start);
        while (!queue.isEmpty()) {
            T node = queue.poll();
            result.add(node);
            for (T neighbour : graph.getAdjMatrix().getOrDefault(node, new HashMap<>()).keySet()) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }
        return result;
    }


}
