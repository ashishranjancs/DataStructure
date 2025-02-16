package com.ds.algo.graph;

public class FloydWarshalAlgoTest {
    public static void main(String[] args) {
        int n = 4; // Number of nodes
        int[][] edges = {
                {0, 1, -1},
                {1, 2, 4},
                {2, 3, 2},
                {3, 1, -5},  // <- This creates a negative cycle
                {0, 2, 3}
        };

        int[][] graph = createAdjMatrix(n, edges);
        floydWarshall(graph);
        printSolution(graph);
    }

    private static void floydWarshall(int[][] graph) {
        int v = graph.length;

        // Run Floyd-Warshall algorithm
        for (int k = 0; k < v; k++) {
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    if (graph[i][k] != Integer.MAX_VALUE / 2 && graph[k][j] != Integer.MAX_VALUE / 2) {
                        graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        // **Detect Negative Cycles AFTER Floyd-Warshall**
        for (int i = 0; i < v; i++) {
            if (graph[i][i] < 0) {
                System.out.println("🚨 Negative cycle detected in the graph!");
                return;
            }
        }
    }

    private static int[][] createAdjMatrix(int n, int[][] edges) {
        int[][] adjMatrix = new int[n][n];
        int INF = Integer.MAX_VALUE / 2;  // Prevent overflow

        // Initialize matrix with INF
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    adjMatrix[i][j] = 0;
                else
                    adjMatrix[i][j] = INF;
            }
        }

        // Fill in edges
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];
            adjMatrix[src][dest] = wt;
        }
        return adjMatrix;
    }

    private static void printSolution(int[][] graph) {
        int INF = Integer.MAX_VALUE / 2;
        System.out.println("Shortest distance between all pairs: ");
        for (int[] row : graph) {
            for (int col : row) {
                System.out.print((col == INF ? "INF" : col) + "\t");
            }
            System.out.println();
        }
    }
}





