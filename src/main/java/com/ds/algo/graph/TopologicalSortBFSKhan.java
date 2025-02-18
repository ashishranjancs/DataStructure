package com.ds.algo.graph;

import java.util.*;

public class TopologicalSortBFSKhan {
    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = {
                {5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}
        };

        System.out.println("Topological Sort (DFS): " + topologicalSort(numCourses, prerequisites));
    }

    private static List<Integer> topologicalSort(int v, int[][] prerequisites) {
        //Create Adjacency List
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < v; i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] neighbour : prerequisites){
            adjList.get(neighbour[0]).add(neighbour[1]);
        }

        for (int i = 0; i < adjList.size(); i++){
            System.out.println("Adjacency List "+ i + " -> " + adjList.get(i));
        }

        int[] indegree = new int[v];
        // Find indegree of the vertex
        for(int i = 0 ; i < v; i++){
            for(int it : adjList.get(i)){
                indegree[it]++;
            }
        }

        //Insert all the node in queue which having indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < v; i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }

        List<Integer> topoSort = new ArrayList<>();
        while(!queue.isEmpty()){
            int node = queue.poll();
            topoSort.add(node);
            for(int it : adjList.get(node)){
                indegree[it]--;
                if(indegree[it] == 0)
                    queue.offer(it);
            }
        }
        return topoSort;
    }
}
