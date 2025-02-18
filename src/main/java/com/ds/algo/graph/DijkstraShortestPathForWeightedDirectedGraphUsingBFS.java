package com.ds.algo.graph;

import java.util.*;

public class DijkstraShortestPathForWeightedDirectedGraphUsingBFS {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {
                {0, 1, 2}, {0, 3, 6}, {1, 2, 3},
                {1, 3, 8}, {1, 4, 5}, {2, 4, 7}
        };
        int source = 0;
        int[] shortestPaths = dijkstra(n, edges, source);
        System.out.println("Shortest distances from node " + source + ": " + Arrays.toString(shortestPaths));
    }

    private static int[] dijkstra(int n, int[][] edges, int source) {
        //Step 1: Creating adjacency List
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for(int i = 0 ; i < n; i++){
            adjList.put(i, new ArrayList<>());
        }

        for(int[] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            int weight = edge[2];
            adjList.get(src).add(new int[] {dest,weight});
            //We can add  for undirected graph ->adjList.get(dest).add(new int[] {src,weight});
        }

        // Step 2: Min Heap (Priority Queue) to always fetch the smallest distance node
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        pq.offer(new int[] {0, source});

        // Step 3: Process nodes in order of their shortest known distance
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currWeight = curr[0];
            int currNode = curr[1];

            //Skip if we found better path earlier
            if(currWeight > distance[currNode])
                continue;

            // Step 4: Relaxation step - Update neighbors
            for(int[] neighbour : adjList.get(currNode)){
                int neighbourNode = neighbour[0];
                int neighbourWeight = neighbour[1];
                int newDistance = neighbourWeight + currWeight;

                // If found a shorter path, update and push to PQ
                if(newDistance < distance[neighbourNode]){
                    distance[neighbourNode] = newDistance;
                    pq.offer(new int[] {newDistance, neighbourNode});
                }
            }

        }
        return distance;
    }
}
