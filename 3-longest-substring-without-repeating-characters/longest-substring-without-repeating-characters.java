class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int maxlength=0;
        HashSet<Character> set = new HashSet<>();
        int l=0,r=0;
        for (r = 0; r < n; r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxlength = Math.max(maxlength, r-l+1);
        }
        return maxlength;
    }
}