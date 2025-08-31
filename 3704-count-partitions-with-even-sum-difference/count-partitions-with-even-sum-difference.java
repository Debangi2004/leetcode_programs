class Solution {
    public int countPartitions(int[] nums) {
        int n =nums.length;
        int total = 0;
        for(int i =0;i<n;i++){
            total+=nums[i];
        }
        int sumLeft = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            sumLeft += nums[i];
            int diff = 2 * sumLeft - total;
            if (diff % 2 == 0) count++;
        }
        return count;
    }
}