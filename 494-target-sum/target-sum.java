class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n =nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if (sum < Math.abs(target) || (sum + target) % 2 != 0) return 0;


        int subsetSum=(sum+target)/2;
        return countSubsets(nums,subsetSum); 
    }
    private int countSubsets(int[] nums, int target){
        int n =nums.length;
        int t[][]=new int[n+1][target+1];
        for(int i=0;i<n;i++){
            t[i][0]=1;
        }
        for(int i =1;i<n+1;i++){
            for(int j =0;j<target+1;j++){
                if(nums[i-1]<=j){
                    t[i][j]=t[i-1][j]+t[i-1][j-nums[i-1]];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        } 
        return t[n][target];
    }
}