class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];

        // Fill the first row with a large number (except dp[0][0])
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = (j == 0) ? 0 : (int)1e9; // or Integer.MAX_VALUE - 1
        }

        // Fill the rest of the table
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // If unreachable, return -1
        return (dp[n][amount] >= (int)1e9) ? -1 : dp[n][amount];
    }
}
