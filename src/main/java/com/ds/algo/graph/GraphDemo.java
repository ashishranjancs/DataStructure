package com.ds.algo.graph;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class GraphDemo implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Graph<Integer> graph = new Graph<>(false);

        //Adjacency List
        graph.addEdgeList(1,2);
        graph.addEdgeList(1, 3);
        graph.addEdgeList(2, 4);
        graph.addEdgeList(2, 5);
        graph.addEdgeList(3, 6);
        graph.addEdgeList(3, 7);

        //Adjacency Matrix
        graph.addEdgeMatrix(1,2,1);
        graph.addEdgeMatrix(1, 3, 1);
        graph.addEdgeMatrix(2, 4, 1);
        graph.addEdgeMatrix(2, 5, 1);
        graph.addEdgeMatrix(3, 6, 1);
        graph.addEdgeMatrix(3, 7, 1);

        GraphTraversals<Integer> traversals = new GraphTraversals<>();
        System.out.println("DFS using Adjacency List : " + traversals.dfsList(graph, 1));
        System.out.println("BFS using Adjacency List : " + traversals.bfsList(graph, 1));

        System.out.println("DFS using Adjacency Matrix : " + traversals.dfsMatrix(graph, 1));
        System.out.println("BFS using Adjacency Matrix : " + traversals.bfsMatrix(graph, 1));
    }
}
