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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        boolean LeftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> sublist = new LinkedList<>();
            for (int i = 0; i <size; i++) {
                TreeNode node = q.poll();
                if (LeftToRight) {
                    sublist.addLast(node.val);

                } else {
                    sublist.addFirst(node.val);
                }
                if (node.left != null) {
                    q.offer(node.left);
                }
                if (node.right != null) {
                    q.offer(node.right);
                }
            }
            result.add(sublist);
            LeftToRight = !LeftToRight;
        }
        return result;
    }
}