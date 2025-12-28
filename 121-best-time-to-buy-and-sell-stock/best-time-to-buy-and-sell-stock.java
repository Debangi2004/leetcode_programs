class Solution {
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int profit=0;
        for(int i =0;i<prices.length-1;i++){
            if(prices[i+1]<prices[i]) mini=Math.min(mini,prices[i+1]);
            profit =Math.max(profit,prices[i+1]-mini);
        }
        return profit;
    }
} 