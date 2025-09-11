class Solution {
    public String reverse(String s){
        int n =s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = n-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
    public int longestPalindromeSubseq(String text1) {
        int n = text1.length();

        String text2=reverse(text1);
        int m = text2.length();

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
        return t[n][m];
    }
}