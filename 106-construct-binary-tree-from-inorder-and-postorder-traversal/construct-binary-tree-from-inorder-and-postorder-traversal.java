class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length) return null;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hash.put(inorder[i],i);
        }
        return inPostBuild(0,inorder.length-1,inorder, 0, postorder.length-1, postorder, hash);
    }
    private TreeNode inPostBuild(int is,int ie, int[] inorder, int ps, int pe, int [] postorder, HashMap<Integer,Integer> hash){
        if(ps>pe || is>ie) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int inRoot= hash.get(postorder[pe]);
        int numsLeft= inRoot - is;

        root.left=inPostBuild(is,inRoot-1,inorder, ps, ps+numsLeft-1, postorder, hash);
        root.right=inPostBuild(inRoot+1, ie,inorder, ps+numsLeft, pe-1, postorder, hash);

        return root;
    }
}