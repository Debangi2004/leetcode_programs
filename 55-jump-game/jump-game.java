class Solution {
    public boolean canJump(int[] nums) {
        int n =nums.length;
        int maxStep=0;

        for(int i =0;i<n;i++){
            if(i>maxStep) return false;
            maxStep=Math.max(maxStep,i+nums[i]);
        }
        return true;
    }
}