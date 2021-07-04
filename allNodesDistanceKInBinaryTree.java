//This solution, in O(N) time, first does a dfs starting at root to get the parents of each TreeNode
//Then, we just do a dfs at target up to distance k to get all the k distance neighbours of target

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
    Map<TreeNode, TreeNode> parents;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parents = new HashMap<TreeNode, TreeNode>();
        fillParents(root.left, root);
        fillParents(root.right, root);
        parents.put(root, null);
        List<Integer> res = new ArrayList<Integer>();

        Set<TreeNode> visited = new HashSet<TreeNode>();
        findNodes(target, 0, k, visited, res);
        return res;
    }

    public void findNodes(TreeNode node, int curDistance, int goalDistance, Set<TreeNode> visited, List<Integer> res){
        if(node == null){
            return;
        }
        if(curDistance == goalDistance){
            res.add(node.val);
            return;
        }
        visited.add(node);
        if(!visited.contains(node.left)){
            findNodes(node.left, curDistance+1, goalDistance, visited, res);
        }
        if(!visited.contains(node.right)){
            findNodes(node.right, curDistance+1, goalDistance, visited, res);
        }
        if(!visited.contains(parents.get(node))){
            findNodes(parents.get(node), curDistance+1, goalDistance, visited, res);
        }
    }

    public void fillParents(TreeNode node, TreeNode parent){
        if(node == null){
            return;
        }
        parents.put(node, parent);
        fillParents(node.left, node);
        fillParents(node.right, node);
    }
}
