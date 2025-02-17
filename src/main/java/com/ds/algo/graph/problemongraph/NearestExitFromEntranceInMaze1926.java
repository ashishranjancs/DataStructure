package com.ds.algo.graph.problemongraph;

import java.util.LinkedList;
import java.util.Queue;

public class NearestExitFromEntranceInMaze1926 {
    public static void main(String[] args) {
        char[][] maze = {
                {'+', '+', '.', '+'},
                {'.', '.', '.', '+'},
                {'+', '+', '+', '.'}
        };
        int[] entrance = {1, 0};
        System.out.println("Nearest Exit from Entrance in Maze : " + nearestExit(maze, entrance)); // Output: 3

        char[][] maze1 = {
                {'+','+','.','.'},
                {'.','.','.','.'},
                {'.','.','.','.'}
        };
        int[] entrance1 = {1,2};
        System.out.println("Nearest Exit from Entrance in Maze : " + nearestExit(maze1, entrance1)); // Output: 1

        char[][] maze2 = {
                {'+','+','+'},
                {'.','.','.'},
                {'+','+','+'}
        };

        int[] entrance2 = {1,0};
        System.out.println("Nearest Exit from Entrance in Maze : " + nearestExit(maze2, entrance2)); // Output: 2

    }

    private static int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0],entrance[1], 0});
        maze[entrance[0]][entrance[1]] = '+';
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int steps = cell[2];

            for(int[] dir : directions){
                int newRow = dir[0] + r;
                int newCol = dir[1] + c;

                if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && maze[newRow][newCol] == '.'){
                    //Border condition
                    if(newRow == 0 || newRow == m-1 || newCol == 0 || newCol == n-1){
                        return steps+1;
                    }

                    maze[newRow][newCol] = '+';
                    queue.offer(new int[]{newRow, newCol, steps+1});
                }
            }
        }
        return -1;
    }
}
