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
    public int sumEvenGrandparent(TreeNode root) {
        if(root == null) {
            return 0;
        }
        if(root.val % 2 == 0){
            return sumTwoLevelsDown(root) + sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
        }

        return sumEvenGrandparent(root.left) + sumEvenGrandparent(root.right);
    }

    public int sumTwoLevelsDown(TreeNode root) {
        int count = 0;
        if(root.left != null) {
            if(root.left.left != null) {
                count += root.left.left.val;
            }
            if(root.left.right != null) {
                count += root.left.right.val;
            }
        }
        if(root.right != null) {
            if(root.right.left != null) {
                count += root.right.left.val;
            }
            if(root.right.right != null) {
                count += root.right.right.val;
            }
        }
        return count;
    }
}
