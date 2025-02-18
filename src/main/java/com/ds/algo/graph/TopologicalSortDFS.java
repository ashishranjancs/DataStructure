package com.ds.algo.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {

    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = {
                {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
        };

        System.out.println("Topological Sort (DFS): " + Arrays.toString(topologicalSort(numCourses, prerequisites)));
    }

    private static int[] topologicalSort(int v, int[][] prerequisites) {
        //1. Create Adj List for given graph
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] neighbour: prerequisites){
            adjList.get(neighbour[0]).add(neighbour[1]);
        }

        for (int i = 0; i < adjList.size(); i++) {
            System.out.println("Node " + i + " -> " + adjList.get(i));
        }

        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < v; i++){
            if(!visited[i]){
                dfs(i, visited, stack, adjList);
            }
        }

        int[] result = new int[v];
        int i = 0;
        while(!stack.isEmpty()){
            result[i++] = stack.pop();
        }

        return result;
    }

    private static void dfs(int node, boolean[] visited, Stack<Integer> stack, List<List<Integer>> adjList) {
        visited[node] = true;
        for(int it : adjList.get(node)){
            if(!visited[it]){
                dfs(it, visited, stack, adjList);
            }
        }
        stack.push(node);
    }
}
