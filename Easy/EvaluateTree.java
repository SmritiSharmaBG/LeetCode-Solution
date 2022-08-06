class Solution {
    public boolean evaluateTree(TreeNode root) {
        if(root == null) return false;
        return rec(root);    
    }
    
    boolean rec(TreeNode root) {
        if(root.left == null && root.right == null) return root.val == 0 ? false : true;
        else if(root.val == 2) return rec(root.left) || rec(root.right);
        else return rec(root.left) && rec(root.right);
    }
}
