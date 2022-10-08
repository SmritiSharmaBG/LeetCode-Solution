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
class FindElements {

    private final boolean[] arr = new boolean[10000000];
    public FindElements(TreeNode root) {
        if (root != null) {
            root.val = 0;
            arr[0] = true;
            rec(root);
        }
    }
    
    private void rec(TreeNode root) {
        if(root.left == null && root.right == null) return;
        int p = root.val;
        if(root.left != null) {
            int v = (2*p) + 1;
            root.left.val = v;
            arr[v] = true;
            rec(root.left);
        }
        if(root.right != null) {
            int v = (2*p) + 2;
            root.right.val = v;
            arr[v] = true;
            rec(root.right);
        }
    }
    public boolean find(int target) {
        return arr[target];
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */
