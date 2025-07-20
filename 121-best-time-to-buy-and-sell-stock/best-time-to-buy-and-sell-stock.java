class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minPrice=Integer.MAX_VALUE;;
        int maxProfit=0;
        for(int i =0;i<n;i++){
            minPrice=Math.min(prices[i],minPrice);
            maxProfit=Math.max(maxProfit,prices[i]-minPrice);
        }
        return  maxProfit;
    }
}