import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        int n=nums.length;
        for (int i = 0; i < n; i++) {

            sum += nums[i];

            if (sum > maxi) {
                maxi = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return maxi;
    }
    public static void main(String[] args)
    {
        Solution sol = new Solution(); 
        int[] na={-2,1,-3,4,-1,2,1,-5,4};
        int maxSum=sol.maxSubArray(na);
        System.out.println(maxSum);
    }
}