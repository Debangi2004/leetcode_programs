import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);

        // Add 0 and n
        int[] newCuts = new int[m + 2];
        newCuts[0] = 0;
        newCuts[m + 1] = n;
        for (int i = 0; i < m; i++) {
            newCuts[i + 1] = cuts[i];
        }

        // dp[i][j] = min cost to cut between cuts[i] and cuts[j]
        int[][] dp = new int[m + 2][m + 2];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, m + 1, newCuts, dp);
    }

    private int solve(int i, int j, int[] cuts, int[][] dp) {
        if (i + 1 == j) return 0; // No cuts possible

        if (dp[i][j] != -1) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = (cuts[j] - cuts[i]) + solve(i, k, cuts, dp) + solve(k, j, cuts, dp);
            min = Math.min(min, cost);
        }

        return dp[i][j] = min;
    }
}
