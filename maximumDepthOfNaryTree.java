/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int childDepth = 0;
        for(Node n: root.children){
            int nDepth = maxDepth(n);
            if(nDepth > childDepth){
                childDepth = nDepth;
            }
        }

        return 1 + childDepth;
    }
}
