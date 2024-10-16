class Solution {
    public int maxProfit(int[] prices) {
        int n= prices.length;
        int maxPro = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            minPrice = Math.min(minPrice,prices[i]);
            maxPro=Math.max(maxPro,prices[i]-minPrice);
        }
        return maxPro;
    }
    public static void main(String args[])
    {
        Solution sol = new Solution();
        int p[] = {7,1,5,3,6,4};
        System.out.println(sol.maxProfit(p));
        
    }
}