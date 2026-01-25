class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> ans= new ArrayList<>();
        ans.add(nums[0]);
        int n=nums.length;

        for(int i=1;i<n;i++){
            if(nums[i]>ans.get(ans.size()-1)){
                ans.add(nums[i]);
            }
            else{
                int idx=Collections.binarySearch(ans,nums[i]);
                if(idx<0) idx=-(idx+1);
                ans.set(idx, nums[i]);
            }
        }
        return ans.size();
    }
}