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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode n = new TreeNode(val);
            n.left = root;
            return n;
        }
        return rec(root, val, depth, 1);
    }
    
    private TreeNode rec(TreeNode root, int val, int depth, int d) {
        if(root == null) return null;
        if(d == depth - 1) {
            TreeNode ll = new TreeNode(val);
            TreeNode rr = new TreeNode(val);
            TreeNode l = root.left;
            TreeNode r = root.right;
            ll.left = l;
            rr.right = r;
            root.left = ll;
            root.right = rr;
            return root;
        }
        root.left = rec(root.left, val, depth, d + 1);
        root.right = rec(root.right, val, depth, d + 1);
        return root;
    }
}
