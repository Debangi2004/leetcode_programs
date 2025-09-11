class Solution {
    public boolean isSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        if(n==0) return true;
        if(m==0) return false;
        
        
        int[][] t = new int[n+1][m+1];
        
        for(int i=0;i<n+1;i++){
            t[i][0]=0;
        }
        for(int j=0;j<m+1;j++){
            t[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)) {
                    t[i][j]=1+t[i-1][j-1];
                }
                else{
                    t[i][j]=Math.max(t[i-1][j],t[i][j-1]);
                }
            }
        }
        if(t[n][m]==n) return true;
        return false;
    }
}