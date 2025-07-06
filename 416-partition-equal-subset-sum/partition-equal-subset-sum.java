class Solution {
    public boolean PartitionSubsetSum(int[] nums, int n, int target) {
        boolean t[][] = new boolean[n+1][target+1];
        
        for(int i =0;i<n+1;i++){
            for(int j = 0;j<target+1;j++){
                if(i==0){
                    t[i][j]=false;
                }
                if(j==0){
                    t[i][j]=true;
                }
            }
        }
        
        for(int i =1;i<n+1;i++){
            for(int j = 1;j<target+1;j++){
                if(nums[i-1]<=j){
                    t[i][j]=t[i-1][j] || t[i-1][j-nums[i-1]];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        
        return t[n][target];
    }

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i = 0;i<nums.length;i++){
            sum = sum + nums[i];
        }
        if(sum % 2 !=0)
        {
            return false;
        }
        return PartitionSubsetSum(nums,nums.length,sum/2); 
    }
}