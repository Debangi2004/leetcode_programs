class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxlen = 0;
        int left = 0, right = 0;
        int zeroes = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroes++;
            }

            // If we have more than k zeroes, shrink the window from the left
            while (zeroes > k) {
                if (nums[left] == 0) {
                    zeroes--;
                }
                left++;
            }

            // Update maxlen for the current window
            maxlen = Math.max(maxlen, right - left + 1);
            right++;
        }

        return maxlen;
    }
}
