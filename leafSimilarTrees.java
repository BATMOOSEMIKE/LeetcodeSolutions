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

    ArrayList<Integer> firstSequence = new ArrayList<Integer>();
    ArrayList<Integer> secondSequence = new ArrayList<Integer>();


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        firstCheck(root1);
        secondCheck(root2);

        if(firstSequence.size()!=secondSequence.size()){
            return false;
        }

        for(Integer i : firstSequence){
            System.out.println(i);
        }

        for(Integer i : secondSequence){
            System.out.println(i);
        }

        for(int i = 0; i<firstSequence.size();i++){
            System.out.println(firstSequence.get(i));
            System.out.println(secondSequence.get(i));
            if(!firstSequence.get(i).equals(secondSequence.get(i))){
                return false;
            }
        }

        return true;





    }

    public void firstCheck(TreeNode root){
        if (root.left == null && root.right == null){
            firstSequence.add(root.val);
        }

        else if(root.left != null && root.right != null)
        {
            firstCheck(root.left);
            firstCheck(root.right);
        }

        else if(root.left != null)
        {
            firstCheck(root.left);
        }
        else
        {
            firstCheck(root.right);
        }


    }


    public void secondCheck(TreeNode root){
        if (root.left == null && root.right == null){
            secondSequence.add(root.val);
        }

        else if(root.left != null && root.right != null)
        {
            secondCheck(root.left);
            secondCheck(root.right);
        }

        else if(root.left != null)
        {
            secondCheck(root.left);
        }
        else
        {
            secondCheck(root.right);
        }


    }
}
