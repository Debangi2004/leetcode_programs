class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLen=Integer.MIN_VALUE;
        int end=0, start=0;
        for(int centre =0;centre<n;centre++){
            int evenLen= expandFromCentre(s,centre,centre);
            int oddLen= expandFromCentre(s,centre,centre+1);

            maxLen=Math.max(evenLen,oddLen);

            if(maxLen>end-start){
                end=centre+maxLen/2;
                start=centre-(maxLen-1)/2;
            }
        }
        return s.substring(start,end+1);
    }
    private int expandFromCentre(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}