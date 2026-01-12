class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;

        List<Integer> ans=new ArrayList<>();
        ans.add(nums[0]);

        for(int i =1;i<n;i++){
            if(nums[i]>ans.get(ans.size()-1)) ans.add(nums[i]);
            else{
                int ind = Collections.binarySearch(ans,nums[i]);
                if(ind<0) ind=-(ind+1);
                ans.set(ind,nums[i]);
            }
        }
        return ans.size();
    }
}