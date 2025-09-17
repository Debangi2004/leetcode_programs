class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int maxProfit=0;
        int n=prices.length;
        for(int i =1;i<n;i++){
            maxProfit=Math.max(maxProfit,prices[i]-mini);
            mini=Math.min(mini,prices[i]);
        }
        return maxProfit;
    }
}