/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return cloneGraphHelp(node, new HashMap<Integer, Node>());
    }

    public Node cloneGraphHelp(Node node, HashMap<Integer, Node> map){
        if(node == null){
            return null;
        }
        else {
            if(map.containsKey(node.val)){
                return map.get(node.val);
            }
            else {
                ArrayList<Node> neighborList = new ArrayList<Node>();
                Node newNode = new Node(node.val, neighborList);
                map.put(newNode.val, newNode);
                for(Node neighbor: node.neighbors){
                    neighborList.add(cloneGraphHelp(neighbor, map));
                }

                return newNode;
            }
        }
    }
}
