class Solution {
    public int loot(int nums[]){
        int n =nums.length;
        if(n==1) return nums[0];

        int dp[]=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[n-1];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        
        int skipfirst[]= new int[n-1];
        int skiplast[]= new int[n-1];
        for(int i =0;i<n-1;i++){
            skipfirst[i]=nums[i+1];
            skiplast[i]=nums[i];
        }
        int firstloot =loot(skipfirst);
        int lastloot = loot(skiplast);

        return Math.max(firstloot, lastloot);
    }
}