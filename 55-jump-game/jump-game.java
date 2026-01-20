class Solution {
    public boolean canJump(int[] nums) {
        int finalPos=nums.length-1;
        for(int i = finalPos-1; i >= 0; i--){
            if(i+nums[i]>=finalPos) finalPos=i;
        }
        return finalPos==0;
    }
}