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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        if(root == null) return ans; // CORNER CASE
        while(!queue.isEmpty()) {
            List<Integer> ds = new ArrayList<>();
            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode temp = queue.remove();
               // if(temp == null) continue;
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
                ds.add(temp.val);
            }
            ans.add(new ArrayList<>(ds));
        }
        return ans;
    } 
    
    // Alternate solution; time and complexity is same as above
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.remove();
            if(temp != null) {
                ds.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
            else if(ds.size() != 0) {
                ans.add(new ArrayList<>(ds));
                queue.add(null);
                ds.clear();
            }
        }
        return ans;
    }
}
