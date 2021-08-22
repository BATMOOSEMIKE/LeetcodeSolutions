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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        else if(root == null || subRoot == null){
            return false;
        }
        else if(root.val == subRoot.val){
            if(equalTree(root, subRoot)){
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean equalTree(TreeNode first, TreeNode second){
        if(first == null && second == null){
            return true;
        }
        else if(first == null || second == null){
            return false;
        }
        else if(first.val != second.val){
            return false;
        }
        return equalTree(first.left, second.left) && equalTree(first.right, second.right);
    }
}
