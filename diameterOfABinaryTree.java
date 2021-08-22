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

    int maxLength = 0;
    //so at each node we return the longest possible path from leaf to root's children (one way)
    //but we calculate the longest possible path
    public int diameterOfBinaryTree(TreeNode root) {
        longestPathIncluding(root);
        return maxLength-1;
    }

    public int longestPathIncluding(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = longestPathIncluding(root.left);
        int right = longestPathIncluding(root.right);
        maxLength = Math.max(maxLength, 1 + left + right);
        return 1 + Math.max(left, right);
    }
}
