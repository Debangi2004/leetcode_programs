class Solution {
    public int lengthOfLongestSubstring(String str) {
        if (str.length() == 0)
            return 0;

        int maxans = 0;  // Changed from Integer.MIN_VALUE
        for (int i = 0; i < str.length(); i++) {
            Set<Character> se = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                if (se.contains(str.charAt(j))) {
                    break;
                }
                se.add(str.charAt(j));
                maxans = Math.max(maxans, j - i + 1); // update max every time
            }
        }
        return maxans;
    }
}
