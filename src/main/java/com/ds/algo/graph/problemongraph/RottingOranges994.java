package com.ds.algo.graph.problemongraph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges994 {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("The minimum number of minutes that must elapse until no cell has a fresh orange " +orangesRotting(grid)); // Output: 4

        int[][] grid1 = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        System.out.println("The minimum number of minutes that must elapse until no cell has a fresh orange " +orangesRotting(grid1)); // Output: -1

    }

    private static int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int freshOrange = 0;
        int noOfMinutes = 0;

        Queue<int[]> queue = new LinkedList<>();
        // Step 1: Collect initial rotten oranges and count fresh ones
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2)
                    queue.offer(new int[] {i, j});
                else if(grid[i][j] == 1)
                    freshOrange++;
            }
        }
        // If there are no fresh oranges, return 0
        if(freshOrange == 0) return 0;

        // Step 2: BFS to spread the rotting effect
        int[][] directions ={{-1,0}, {1,0}, {0,-1}, {0,1}};

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean rotted = false;
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int r = cell[0];
                int c = cell[1];

                for(int[] dir : directions){
                    int newRow = r + dir[0];
                    int newCol = c + dir[1];
                    // Convert adjacent fresh oranges to rotten
                    if(newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1){
                        queue.offer(new int[] {newRow, newCol});
                        grid[newRow][newCol] = 2;
                        freshOrange--;
                        rotted = true;
                    }
                }
            }
            if(rotted) noOfMinutes++;
        }
        // If fresh oranges are left, return -1
        return (freshOrange == 0) ? noOfMinutes : -1;
    }
}
