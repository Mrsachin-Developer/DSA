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
public int helperFunc(TreeNode root, int current){

    if(root== null) return 0;

    current=current*10+root.val;

    if(root.left == null && root.right ==null){
        return current;
    }
    return helperFunc(root.left,current)+helperFunc(root.right,current);
}

    public int sumNumbers(TreeNode root) {
        
 return helperFunc(root,0);


    }
}