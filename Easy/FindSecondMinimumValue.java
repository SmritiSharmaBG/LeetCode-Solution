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
    int min, secondMin;
    public int findSecondMinimumValue(TreeNode root) {
        return findSecMin(root);
    }
    
    public int findSecMin(TreeNode root) {
        if(root == null) return -1;
        if(root.left == null) return -1; // 0 child
        int left = root.left.val;
        int right = root.right.val;
        if(root.val == root.left.val) left = findSecMin(root.left);
        if(root.val == root.right.val) right = findSecMin(root.right);
        if(left == -1)
            return right;
        if(right == -1)
            return left;
        return left < right ? left : right;
        
    }
}
