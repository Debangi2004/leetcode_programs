
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    private void preorder(TreeNode node, List<Integer> result) {
        if (node == null) return;
        result.add(node.val);               // Visit root
        preorder(node.left, result);        // Traverse left
        preorder(node.right, result);       // Traverse right
    }

}