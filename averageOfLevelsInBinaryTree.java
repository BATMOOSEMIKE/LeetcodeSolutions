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
    Map<Integer, Double> levelSums = new HashMap<Integer, Double>();
    Map<Integer, Integer> levelCounts = new HashMap<Integer, Integer>();

    public List<Double> averageOfLevels(TreeNode root) {
        traverse(root, 0);
        List<Double> res = new ArrayList<Double>();
        for(int i = 0; i < levelSums.size(); i++){
            res.add(levelSums.get(i)/levelCounts.get(i));
        }
        return res;
    }

    public void traverse(TreeNode root, int level){
        if(root == null){
            return;
        }
        levelSums.put(level, levelSums.getOrDefault(level, 0.0) + root.val);
        levelCounts.put(level, levelCounts.getOrDefault(level, 0) + 1);
        traverse(root.left, level+1);
        traverse(root.right, level+1);
    }
}
