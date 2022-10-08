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
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int sum = 0;
        while(!q.isEmpty()) {
            sum = 0; // new sum for each level
            int s = q.size();
            while(s -- > 0) {
                TreeNode t = q.remove();
                sum += t.val;
                if(t.left != null) q.add(t.left);
                if(t.right != null) q.add(t.right);
            }
        }
        return sum;
    }
}
