/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int size = size(root.left);
        if(size == k-1){
            return root.val;
        }
        else if(size < k-1){
            return kthSmallest(root.right, k-size-1);
        }
        else{
            return kthSmallest(root.left, k);
        }
    }

    public int size(TreeNode root){
        if(root == null){
            return 0;
        }
        else{
            return 1 + size(root.left) + size(root.right);
        }
    }
}
