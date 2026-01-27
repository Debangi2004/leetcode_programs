class Solution {
    int maxPath=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxPath;
    }
    public int maxSum(TreeNode root){
        if(root == null) return 0;
        int lh= Math.max(0, maxSum(root.left));
        int rh= Math.max(0, maxSum(root.right));
        maxPath=Math.max(maxPath,lh+rh+root.val);

        return Math.max(lh,rh)+ root.val;
    }
}