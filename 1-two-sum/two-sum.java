
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n =nums.length;
        HashMap<Integer,Integer> set = new HashMap<>();
        for(int i =0;i<n;i++){
            int rem=target-nums[i];
            if(set.containsKey(rem)){
                return new int[]{i,set.get(rem)};
            }
            set.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}

