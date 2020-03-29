/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    //TreeNode to string
    //string to TreeNode
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null )return "null,";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val+",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));
        return sb.toString();
    }
    
    /*
    1,2,null,null,3,null,null
    */
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null,")) return null;
        String[] dataSplit = data.split(","); // each node;
        TreeNode node = parseNode(dataSplit);
        return node;
    }
    int index = 0;
    private TreeNode parseNode(String[] dataSplit){
        if(dataSplit[index].equals("null")){
            index++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(dataSplit[index++]));
        node.left = parseNode(dataSplit);
        node.right = parseNode(dataSplit);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));