class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] t = new boolean[n+1][m+1];
        t[0][0] = true;
        for (int j = 1; j <m+1; j++) {
            if (p.charAt(j - 1) != '*') t[0][j]=false;
            else t[0][j] = t[0][j-1];
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if (s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?') {
                    t[i][j] = t[i-1][j-1];
                }
                else{
                    if (p.charAt(j-1) == '*'){
                        t[i][j]=t[i-1][j]||t[i][j-1];
                    }
                    else{
                        t[i][j]=false;
                    }
                }
            }
        }
        return t[n][m];
    }
}