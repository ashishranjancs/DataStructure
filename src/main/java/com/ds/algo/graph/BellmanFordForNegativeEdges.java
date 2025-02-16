package com.ds.algo.graph;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.*;

public class BellmanFordForNegativeEdges {

    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int[][] edges = {
                {0, 1, -1}, {0, 2, 4}, {1, 2, 3},
                {1, 3, 2}, {1, 4, 2}, {3, 2, 5}, {3, 1, 1},{4, 3, -3}
        };

        int source = 0;
        int[] dist =  bellmanFord(edges, V, source);
        System.out.println(" Shortest path in Bellman ford Algo : ");
        for(int i = 0; i < dist.length; i++){
            System.out.print(" \t\t "+ dist[i]);
        }
    }

    private static int[] bellmanFord(int[][] edges, int v, int source) {
        //Step 1: distance array
        int[] distance = new int[v];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        //N-1 relaxation for shortest path
        for(int i = 0; i < v-1; i++){
            for(int[] edge : edges){
                int src = edge[0];
                int dest = edge[1];
                int wt = edge[2];
                if(distance[src] != 1e8 && distance[src] + wt < distance[dest]){
                    distance[dest] = distance[src] + wt;
                }
            }
        }

        //Nth relaxation to check negative cycle
        for(int[] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];
            if(distance[src] != 1e8 && distance[src] + wt < distance[dest]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return distance;
    }
}
