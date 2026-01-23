class Solution {
    public int maxArea(int[] height) {
        int n =height.length;
        int left=0, right=n-1;
        int area=Integer.MIN_VALUE;
        while(left<right){
            int h=Math.min(height[left],height[right]);
            int b=right-left;
            area=Math.max(area,b*h);
            if(height[left]<height[right]) left++;
            else right--;
        }
        return area;
    }
}