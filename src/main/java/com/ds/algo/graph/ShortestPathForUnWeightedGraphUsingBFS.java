package com.ds.algo.graph;

import java.util.*;

public class ShortestPathForUnWeightedGraphUsingBFS {

    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{1, 2}, {1, 4}, {2, 3}, {2, 5}, {3, 6}, {4, 5}, {5, 6}};
        int src = 1;
        int[] distances = shortestPathUsingBFS(n, edges, src);

        for (int i = 1; i <= n; i++) {
            System.out.println("Shortest distance from " + src + " to " + i + " is: " + distances[i]);
        }
    }

    private static int[] shortestPathUsingBFS(int n, int[][] edges, int src) {
        //Create Adjacency List
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);  //Undirected graph
        }

        //We need to create distance array to store shorted distance which contains max value at the time of initialization
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);

        while (!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : adjList.get(node)){
                if(distance[node] + 1 < distance[neighbour]){
                    distance[neighbour] = distance[node] + 1;
                    queue.offer(neighbour);
                }
            }
        }

        //return distance array
        return distance;

    }
}
