import java.util.*;
class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int low=0,mid=0,high=n-1;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                int temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
            else
            {
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
    }
    public static void main(String args[])
    {
        Solution sol =new Solution();
        int arr[]={2,0,2,1,1,0};
        sol.sortColors(arr);
    }
}