class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0;  // points to position to place the next non-zero

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }

        while (k < nums.length) {
            nums[k++] = 0;
        }
    }
}
