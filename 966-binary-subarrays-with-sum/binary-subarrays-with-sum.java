class Solution {
    public int SubarraySum(int[] nums, int goal) {
        if(goal<0)
            return 0;
        int l =0,r=0,sum=0,count=0;
        while(r<nums.length)
        {
            sum = sum+nums[r];
            while(sum>goal)
            {
                sum=sum-nums[l];
                l++;
            }
            count = count+(r-l+1);
            r++;
        }
        return count;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return SubarraySum(nums, goal) - SubarraySum(nums, goal-1);
    }
}