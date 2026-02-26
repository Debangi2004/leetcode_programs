class Solution {
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumDown(root);
        return maxPath;
    }
    private int maxPathSumDown(TreeNode root){
        if(root == null) return 0;
        int lh = Math.max(0,maxPathSumDown(root.left));
        int rh = Math.max(0,maxPathSumDown(root.right));
        maxPath = Math.max(maxPath, root.val+lh+rh);
        return root.val+Math.max(lh, rh);
    }
}