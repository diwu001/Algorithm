import java.util.*;

public class Serialize_and_Deserialize_Binary_Tree {
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        sb.append(root.val);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                sb.append(",");
                if(cur.left == null) {
                    sb.append("#");
                } else {
                    sb.append(cur.left.val);
                    queue.add(cur.left);
                }
                sb.append(",");
                if(cur.right == null) {
                    sb.append("#");
                } else {
                    sb.append(cur.right.val);
                    queue.add(cur.right);
                }
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] vals = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
        int index = 1;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty() && index < vals.length) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if(!vals[index].equals("#")) {
                    cur.left = new TreeNode(Integer.valueOf(vals[index]));
                    queue.add(cur.left);
                } 
                index++;
                if(!vals[index].equals("#")) {
                    cur.right = new TreeNode(Integer.valueOf(vals[index]));
                    queue.add(cur.right);
                } 
                index++;
            }
        }
        return root;
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
