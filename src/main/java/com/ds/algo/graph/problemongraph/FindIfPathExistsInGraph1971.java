package com.ds.algo.graph.problemongraph;

import java.util.*;

/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 *
 * You want to determine if there is a valid path that exists from vertex source to vertex destination.
 *
 * Given edges and the integers n, source, and destination, return true if there is a valid path from source to destination, or false otherwise
 *
 *
 * Example 1:
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], source = 0, destination = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 *
 * Example 2:
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], source = 0, destination = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 */
public class FindIfPathExistsInGraph1971 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edges = {{0, 1}, {0, 2}, {3,5}, {5,4}, {4,3}};
        int src = 0;
        int dest = 5;
        boolean validPath = validPath(n, edges, src, dest);
        boolean validPathUsingBFS = validPath(n, edges, src, dest);

            System.out.println("Shortest distance from " + src + " to " + dest + " is: " + validPath);
            System.out.println("Shortest distance from " + src + " to " + dest + " is: " + validPathUsingBFS);
    }

    public static List<List<Integer>> createAdjList(int n, int[][] edges){
        //Create the AdjList
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]); //undirected graph
        }
        return adjList;
    }

    //Here cyclic or revisiting node
    private static boolean validPath(int n, int[][] edges, int src, int dest) {

        List<List<Integer>> adjList = createAdjList(n, edges);

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int neighbour : adjList.get(node)){
                if(distance[node] + 1 < distance[neighbour]){
                    distance[neighbour] = distance[node]+1;
                    queue.offer(neighbour);
                }
            }
        }

        return (distance[dest] != Integer.MAX_VALUE);

    }


    //Use a visited set to avoid cycles or revisiting nodes.
    private static boolean validPathUsingBFS(int n, int[][] edges, int src, int dest) {
        List<List<Integer>> adjList = createAdjList(n, edges);
        boolean[] visited = new boolean[n];
        visited[src] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(src);

        while(!queue.isEmpty()){
            int node = queue.poll();
            if(node == dest)
                return true;
            for(int neighbour : adjList.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return false;
    }
}
