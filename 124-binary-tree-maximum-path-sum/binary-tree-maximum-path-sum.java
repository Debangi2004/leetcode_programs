class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxValue = new int[1];
        maxValue[0]= Integer.MIN_VALUE;
        maxPathDown(root,maxValue);
        return maxValue[0];
    }
    public int maxPathDown(TreeNode node, int[] maxValue){
        if(node == null) return 0;
        int left =  Math.max(0,maxPathDown(node.left,maxValue));
        int right =  Math.max(0,maxPathDown(node.right,maxValue));

        maxValue[0] = Math.max(maxValue[0], node.val+left+right);

        return Math.max(left,right)+node.val;
    }
}