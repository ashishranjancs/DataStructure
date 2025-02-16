package com.ds.algo.graph;

import java.util.Arrays;

public class FloydWarshallAlgo {

    public static void main(String[] args) {
        int n = 5; // Number of nodes

        int[][] edges = {
                {0, 1, 3},
                {0, 2, 5},
                {1, 3, 4},
                {2, 4, 2},
                {3, 4, 1}
        };
        int[][] graph = createAdjMatrix(n, edges);
        floydWarshall(graph);
        printSolution(graph);

    }
    private static void floydWarshall(int[][] graph) {
        int v = graph.length;
        for(int k = 0; k < v; k++){
            for(int i = 0 ; i < v; i++){
                for(int j = 0; j < v; j++){
                    if (graph[i][k] != 1e8 && graph[k][j] != 1e8) {  // Avoid integer overflow
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }
        for(int i = 0 ; i < v; i++){
            if(graph[i][i] < 0){
                System.out.println("Negative cycle is present in Graph");
                return;
            }
        }
    }

    private static int[][] createAdjMatrix(int n, int[][] edges) {
        int[][] adjMatrix = new int[n][n];
        int INF = (int) 1e8;
        //Initialize matrix with default value as infinity
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                if(i == j)
                    adjMatrix[i][j] = 0;
                else
                    adjMatrix[i][j] = INF;;
            }

        }

        for(int[] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];
            adjMatrix[src][dest] = wt;
        }
        return adjMatrix;
    }

    private static void printSolution(int[][] graph) {
        System.out.println("Shortest distance between all pairs: ");
        for(int[] row : graph){
            for(int col : row){
                System.out.print((col == 1e8 ? "INF" : col) + "\t");
            }
            System.out.println();
        }

    }
}
