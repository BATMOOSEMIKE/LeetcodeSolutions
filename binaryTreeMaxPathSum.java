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

    int globalMax = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        maxPathSumStartingAtNode(root);
        return globalMax;
    }

    //returns the max path sum possible if we start at node (must contain node)
    public int maxPathSumStartingAtNode(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftSum = Math.max(0, maxPathSumStartingAtNode(node.left));
        int rightSum = Math.max(0, maxPathSumStartingAtNode(node.right));

        globalMax = Math.max(globalMax, node.val + leftSum + rightSum);
        return node.val + Math.max(leftSum, rightSum);
    }
}
