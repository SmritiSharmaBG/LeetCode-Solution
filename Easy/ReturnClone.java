package com.dataStructure.binaryTree;

public class ReturnClone {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *      7
     *     / \
     *    4   3
     *       / \
     *      6  19
     */
    public static void main(String[] args) {
        TreeNode original = new TreeNode(7);
        original.left = new TreeNode(4);
        original.right = new TreeNode(3);
        original.right.left = new TreeNode(6);
        original.right.right = new TreeNode(19);

        TreeNode cloned = new TreeNode(7);
        cloned.left = new TreeNode(4);
        cloned.right = new TreeNode(3);
        cloned.right.left = new TreeNode(6);
        cloned.right.right = new TreeNode(19);

        TreeNode x = getTargetCopy(original, cloned, original.right);
        System.out.println(x.val);

    }

    static TreeNode node = null;

    public static TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target)
            return node;
        node = getTargetCopy(original.left, cloned.left, target);
        if (node != null)
            return node;
        node = getTargetCopy(original.right, cloned.right, target);
        return node;
    }
}
