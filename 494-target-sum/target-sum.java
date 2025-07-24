class Solution {
    public int count(int[] nums, int n, int target) {
        int[][] t = new int[n + 1][target + 1];

        for (int i = 0; i < n + 1; i++)
            t[i][0] = 1; // Only one way to make sum 0: pick nothing

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < target + 1; j++) {
                if (nums[i - 1] <= j)
                    t[i][j] = t[i - 1][j - nums[i - 1]] + t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }

        return t[n][target];
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;

        if ((sum + target) % 2 != 0 || (sum + target) < 0)
            return 0;

        int s1 = (sum + target) / 2;

        return count(nums, nums.length, s1);
    }
}
