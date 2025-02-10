package com.ds.algo.graph.problemongraph;

/**
 * In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.
 *
 * Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.
 *
 * Example 1:
 * Input: n = 2, trust = [[1,2]]
 * Output: 2
 *
 * Example 2:
 * Input: n = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 * Example 3:
 * Input: n = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 */
public class FindTheTownJudge997 {

    public static void main(String[] args) {
        int[][] trust = {{1, 3}, {2, 3}, {3, 1}};
        System.out.println(findJudge(3, trust)); // Output: -1 (No Judge)

        int[][] trust2 = {{1, 3}, {2, 3}};
        System.out.println(findJudge(3, trust2)); // Output: 3 (Judge found)
    }

    public static int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n+1];
        //Create Adjacency List
        for(int[] relation : trust){
            int a = relation[0];
            int b = relation[1];
            trustCount[a]--;  //Decrease for trusting someone
            trustCount[b]++;  //Increase for being trusted
        }
        //The judge should be trusted by everyone(n-1) and trust no one
        for(int i = 1; i <= n; i++){
            if(trustCount[i] == n-1){
                return i;
            }
        }
        return -1; //No Judge found
    }


}
