class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        int n = nums.length;
        int[] hash = new int[n + 1];  // frequency array
        int left = 0, right = 0;
        int count = 0;
        int unique = 0;

        while (right < n) {
            if (hash[nums[right]] == 0) {
                unique++;
            }
            hash[nums[right]]++;
            right++;

            while (unique > k) {
                hash[nums[left]]--;
                if (hash[nums[left]] == 0) {
                    unique--;
                }
                left++;
            }

            count += right - left;
        }

        return count;
    }
}
