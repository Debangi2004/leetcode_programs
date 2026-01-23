class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];
        int l = 0, r = 0, count = 0;
        int minLen = Integer.MAX_VALUE;
        int startIndex = -1;
        int n = s.length(), m = t.length();

        for (int i = 0; i < m; i++) {
            hash[t.charAt(i)]++;
        }

        while (r < n) {
            if (hash[s.charAt(r)] > 0) {
                count++;
            }
            hash[s.charAt(r)]--;

            while (count == m) {
                if (r - l + 1 < minLen) {
                    minLen = r - l + 1;
                    startIndex = l;
                }

                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    count--;
                }
                l++;
            }

            r++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minLen);
    }
}