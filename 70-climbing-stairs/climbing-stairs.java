class Solution {
    public int climbStairs(int n) {
        if(n==1) return 1;
        int t[]=new int[n+1];
        t[1]=1;
        t[2]=2;
        for(int i=3;i<n+1;i++){
            t[i]=t[i-1]+t[i-2];
        }
        return t[n];
    }
}