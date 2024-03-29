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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int larger = Math.max(p.val, q.val);
        int smaller = Math.min(p.val, q.val);

        if(root.val >= smaller && root.val <= larger){
            return root;
        }
        else if(root.val > larger){
            return lowestCommonAncestor(root.left, p, q);
        }
        else{
            return lowestCommonAncestor(root.right, p, q);
        }
    }

}
