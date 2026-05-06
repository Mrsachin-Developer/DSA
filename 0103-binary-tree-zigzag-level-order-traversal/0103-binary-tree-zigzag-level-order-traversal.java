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

        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)
            return result;
        q.offer(root);
        boolean leftToRight = true;
        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> sublist = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();

                if (leftToRight) {
                    sublist.addLast(node.val);
                } else {
                    sublist.addFirst(node.val);
                }
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);

            }
            result.add(sublist);

            leftToRight = !leftToRight;
        }
        return result;
    }
}