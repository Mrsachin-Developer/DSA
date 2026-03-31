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
    public int maxPathSum(TreeNode root) {

        if (root == null)
            return 0;
        int[] maxValue = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPath(root, maxValue);
        return maxValue[0];
    }

    private int maxPath(TreeNode root, int[] maxValue) {
        if (root == null)
            return 0;
        int leftsum = Math.max(0, maxPath(root.left, maxValue));// to avoid negative nodes
        int rightsum = Math.max(0, maxPath(root.right, maxValue));

        maxValue[0] = Math.max(maxValue[0], root.val + leftsum + rightsum);//Keeping track of maximun path for each node
        return Math.max(leftsum, rightsum) + root.val;// decides which path to choose to get maximum
    }
}