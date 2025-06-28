class Solution {
    public int SubarraySum(int[] nums, int goal) {
        if(goal<0)
            return 0;
        int l =0,r=0,sum=0,count=0;
        while(r<nums.length)
        {
            sum = sum+(nums[r]%2);
            while(sum>goal)
            {
                sum=sum-(nums[l]%2);
                l++;
            }
            count = count+(r-l+1);
            r++;
        }
        return count;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return SubarraySum(nums, k) - SubarraySum(nums, k-1);
    }
}