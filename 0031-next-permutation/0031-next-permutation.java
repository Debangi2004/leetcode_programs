class Solution {
    public void nextPermutation(int[] nums) {
        int len=nums.length;
        int ind=-1;
        for(int i = len-2; i>=0 ;i--)
        {
            if(nums[i]<nums[i+1])
            {
                ind=i;
                break;
            }
        }
        
        if(ind==-1){
            reverse(nums, 0, len - 1);
        }
        else
        {
            for(int i=len-1;i>ind;i--)
            {
                if(nums[i]>nums[ind])
                {
                    int temp=nums[i];
                    nums[i]=nums[ind];
                    nums[ind]=temp;
                    break;
                }
            }
            reverse(nums, ind+1, len - 1);
        }
    }
    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    public static void main(String args[]){
        Solution sol= new Solution();
        int nums[]={2,1,5,4,3,0,0};
        sol.nextPermutation(nums);
        
        for(int ele:nums)
        {
            System.out.println(ele + " ");
        }
    }
}







