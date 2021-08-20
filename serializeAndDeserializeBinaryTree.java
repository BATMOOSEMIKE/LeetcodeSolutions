/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //This solution works by doing DFS (pre-order traversal) and then deserializing recursively
 //in the same order. 
public class Codec {

    private int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "n,";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        serializeHelp(root.left, sb);
        serializeHelp(root.right, sb);
        return sb.toString();
    }

    public void serializeHelp(TreeNode root, StringBuilder acc){
        if (root == null){
            acc.append("n");
            acc.append(",");
        }
        else {
            acc.append(root.val);
            acc.append(",");
            serializeHelp(root.left, acc);
            serializeHelp(root.right, acc);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        return deserializeHelper(dataArr);
    }

    public TreeNode deserializeHelper(String[] data){
        String cur = data[index];
        if(cur.equals("n")){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        index++;
        root.left = deserializeHelper(data);
        index++;
        root.right = deserializeHelper(data);
        return root;
    }


}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
