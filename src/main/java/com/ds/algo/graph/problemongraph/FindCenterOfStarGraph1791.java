package com.ds.algo.graph.problemongraph;

/**
 * There is an undirected star graph consisting of n nodes labeled from 1 to n.
 * A star graph is a graph where there is one center node and exactly n - 1 edges that connect the center node with every other node.
 *
 * You are given a 2D integer array edges where each edges[i] = [ui, vi] indicates that there is an edge between the nodes ui and vi.
 * Return the center of the given star graph.
 *
 * Example 1:
 * Input: edges = [[1,2],[2,3],[4,2]]
 * Output: 2
 * Explanation: As shown in the figure above, node 2 is connected to every other node, so 2 is the center.
 *
 * Example 2:
 * Input: edges = [[1,2],[5,1],[1,3],[1,4]]
 * Output: 1
 *
 */
public class FindCenterOfStarGraph1791 {

    public static void main(String[] args) {
        int[][] edges1 = {{1, 2}, {2, 3}, {4, 2}}; // Center = 2
        int[][] edges2 = {{1, 3}, {2, 3}, {4, 3}}; // Center = 3
        int[][] edges3 = {{1,2}, {5,1}, {1,3}, {1,4}}; // Center = 1

        System.out.println(findCenter(edges1)); // Output: 2
        System.out.println(findCenter(edges2)); // Output: 3
        System.out.println(findCenter(edges3)); // Output: 1
    }

    private static int findCenter(int[][] edges) {

        int a = edges[0][0];
        int b = edges[0][1];
        int c = edges[1][0];
        int d = edges[1][1];

        return (a == c || a == d) ? a : b;
    }

}
