import java.util.*;

class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        Arrays.sort(cuts);
        int[] newcuts= new int [m+2];
        newcuts[0]=0;
        newcuts[m+1]=n;
        for(int i = 0 ;i<m;i++){
            newcuts[i+1]=cuts[i];
        }

        int[][] dp= new int[m+2][m+2];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return solve(0,m+1,newcuts,dp);
    }
    public int solve(int i,int j , int[] newCuts, int[][]dp){
        if(i+1 ==  j) return 0;
        if(dp[i][j]!= -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;

        for(int k=i+1;k<j;k++){
            int cost = newCuts[j]-newCuts[i]+solve(i,k,newCuts,dp)+solve(k,j,newCuts,dp);
            mini= Math.min(mini,cost);
        }
        return dp[i][j]=mini;
    }
}