class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum=0;
        for(int i =0;i<n;i++){
            sum=sum+nums[i];
        }
        if(sum%2!=0) return false;
        return subsetSumToK(n,sum/2,nums);
    }
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean t[][]= new boolean[n+1][k+1];
        for(int j=0;j<k+1;j++){
            t[0][j]=false;
        }
        for(int i=0;i<n+1;i++){
            t[i][0]= true;
        }

        for(int i =1;i<n+1;i++){
            for(int j=1;j<k+1;j++){
                if(arr[i-1]<=j){
                    t[i][j]=t[i-1][j]||t[i-1][j-arr[i-1]];
                }
                else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][k];
    } 
}