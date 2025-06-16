class Solution {
    public int maximumDifference(int[] nums) {
        int min = nums[0];
        //7
        int maxDiff = -1;  

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                //1>7 no
                //5>1 yes
                //1>4
                maxDiff = Math.max(maxDiff, nums[i] - min);
                //maxdiff=5-1=4
            } else {
                min = nums[i]; 
                //min=1
            }
        }

        return maxDiff;
    }
}
