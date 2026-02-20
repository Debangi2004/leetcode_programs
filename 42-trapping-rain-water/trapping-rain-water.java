class Solution {
    public int trap(int[] heights) {
        int n = heights.length;
        if(n == 0) return 0;

        int left = 0, right = n - 1;
        int leftMax = 0 , rightMax = 0;
        int totalWaterContent = 0 ;

        while(left < right){
            if(heights[left] < heights[right]) {
                if(heights[left] >= leftMax) leftMax = heights[left];
                else totalWaterContent += leftMax - heights[left];
                left ++;
            }
            else{
                if(heights[right] >= rightMax) rightMax = heights[right];
                else totalWaterContent += rightMax - heights[right];
                right --;
            }
        }

        return totalWaterContent;
    }
}