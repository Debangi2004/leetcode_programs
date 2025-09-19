class Solution {
    public int maxProfit(int[] prices) {
        int n =prices.length;
        int dp[][]= new int[n+1][2];
        dp[n][0]=dp[n][1]=0;
        for(int i = n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                if(j==0){
                    dp[i][j]=Math.max(-prices[i]+dp[i+1][1],0+dp[i+1][0]);
                }
                else{
                    dp[i][j]=Math.max(prices[i]+dp[i+1][0],0+dp[i+1][1]);
                }
            }
        }
        return dp[0][0];
    }
}