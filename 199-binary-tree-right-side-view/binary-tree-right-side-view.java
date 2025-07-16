/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rightView(root, ans, 0);
        return ans;
    }
    public void rightView(TreeNode node, List<Integer> ans, int level) {
        if(node == null) return;
        if(level == ans .size()) ans.add(node.val);
        rightView(node.right, ans, level+1);
        rightView(node.left, ans, level+1);
    }
}