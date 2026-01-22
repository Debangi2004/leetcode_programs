class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int freq[]=new int[26];
        int l=0;
        int maxFreq=0;
        int windowSize=0;
        int maxWindow=0;
        for(int r=0;r<n;r++){
            freq[s.charAt(r)-'A']++;
            maxFreq=Math.max(maxFreq, freq[s.charAt(r)-'A']);
            windowSize=r-l+1;
            if(windowSize-maxFreq>k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            windowSize=r-l+1;
            maxWindow=Math.max(maxWindow, windowSize);
        }
        return maxWindow;
    }
}