class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int point = -1;

        // Step 1: Find the first index 'point' from the end such that nums[i] < nums[i+1]
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                point = i;
                break;
            }
        }

        // Step 2: If no such point found, reverse the whole array
        if (point == -1) {
            reverse(nums, 0, n - 1);
            return;
        }

        // Step 3: Find the smallest number larger than nums[point] to the right
        int indexToSwap = -1;
        for (int i = n - 1; i > point; i--) {
            if (nums[i] > nums[point]) {
                indexToSwap = i;
                break;
            }
        }

        // Step 4: Swap
        int temp = nums[point];
        nums[point] = nums[indexToSwap];
        nums[indexToSwap] = temp;

        // Step 5: Reverse the suffix starting at point + 1
        reverse(nums, point + 1, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}
