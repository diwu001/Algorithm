import java.util.Stack;
public class Inver_Binary_Tree {
	//Iteration - preorder traversal
	public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        Stack<TreeNode> s=new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode cur=s.pop();
            TreeNode temp=cur.left;
            cur.left=cur.right;
            cur.right=temp;
            
            if(cur.right!=null) s.push(cur.right);
            if(cur.left!=null) s.push(cur.left);
        }
        return root;
    }
	
	//Recursion - preorder traversal
	public TreeNode invertTree2(TreeNode root) {
        if(root==null) return root;
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
