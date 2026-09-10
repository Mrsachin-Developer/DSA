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

    int nodeMatchCnt = 0;

    class Pair {
        int sum;
        int count;

        Pair(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public Pair avgPathSum(TreeNode root) {
        if (root == null)
            return new Pair(0, 0);
        Pair left = avgPathSum(root.left);
        Pair right = avgPathSum(root.right);

        int sum = left.sum + right.sum + root.val;
        int count = left.count + right.count + 1;

        int avg = sum / count;
        if (avg == root.val) {
            nodeMatchCnt++;
        }

        return new Pair(sum, count);
    }

    public int averageOfSubtree(TreeNode root) {
        avgPathSum(root);
        return nodeMatchCnt;
    }
}