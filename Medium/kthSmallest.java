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
    int ans = -1;
    int count;
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        findSmall(root);
        return ans;           
    }
    void findSmall(TreeNode root) {
        if(count == 0 || root == null) return;
        findSmall(root.left);
        if(count > 0) {
            ans = root.val;
            count --;
        }
        findSmall(root.right);
    }
}
