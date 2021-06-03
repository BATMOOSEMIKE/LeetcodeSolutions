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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
        }
        else return hasPathSumHelp(root, sum);
    }

    public boolean hasPathSumHelp(TreeNode root, int sum){
        if (root.val == sum && root.left == null && root.right == null){
            return true;
        }
        else if(root.left != null && root.right != null){
            return hasPathSumHelp(root.left, sum-root.val) || hasPathSumHelp(root.right, sum-root.val);
        }
        else if(root.left != null){
            return hasPathSumHelp(root.left, sum-root.val);
        }
        else if(root.right != null){
            return hasPathSumHelp(root.right, sum - root.val);
        }
        return false;
    }
}
