import java.util.concurrent.atomic.AtomicInteger;

class Solution {
    public int solve(TreeNode root, AtomicInteger res) {
        if (root == null) return 0;

        int l = solve(root.left, res);
        int r = solve(root.right, res); 

        // Update diameter at this node
        res.set(Math.max(res.get(), l + r));

        // Return height of current subtree
        return 1 + Math.max(l, r);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger res = new AtomicInteger(0); // Diameter is measured in edges
        solve(root, res);
        return res.get();
    }
}
