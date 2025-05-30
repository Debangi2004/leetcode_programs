class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n =nums.length;
        int count = 0;
        int cnt=Integer.MIN_VALUE;
        for(int i =0;i<n;i++)
        {
            if(nums[i]==1)
            {
                count++;
            }
            else
            {
                count=0;
            }
            cnt=count>cnt?count:cnt;
        }
        return cnt;
    }
}