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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> acc = new ArrayList<List<Integer>>();
        if(root == null){
            return acc;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> lacc = new ArrayList<Integer>();
        //put root into the queue
        queue.add(root);
        //put a null afterwards to separate it from the next 'layer'
        queue.add(null);
        //while front of queue is not null, pop things and add to list accumulator
        TreeNode front = queue.poll();
        while(queue.size() > 0){
            if(front != null){
                lacc.add(front.val);
                //everything we pop, we add its children to the queue
                if(front.left != null){
                    queue.add(front.left);
                }
                if(front.right != null){
                    queue.add(front.right);
                }
            }
            //when we reach a null, add list accumulator to main accumulator
            //add a new null to the back
            //clear list accumulator
            else {
                acc.add(new ArrayList<Integer>(lacc));
                queue.add(null);
                lacc.clear();
            }

            front = queue.poll();
        }

        acc.add(lacc);

        return acc;

    }


}
