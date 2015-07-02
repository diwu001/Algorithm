import java.util.Stack;
public class kth_Smallest_in_BST {
	// Iteration - inorder traversal
	public int kthSmallest(TreeNode root, int k) {
        if(root==null) return -1;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null||!s.isEmpty()){
            if(cur!=null) {
                s.push(cur);
                cur=cur.left;
            } else {
                cur=s.pop();
                k--;
                if(k==0) break;
                cur=cur.right;
            }
        }
        return cur.val;
    }
	
	//-------------------------------------------------------------	
	
	//Recursion - inorder traversal
	public int kthSmallest2(TreeNode root, int k) {
        if(root==null) return -1;
        int[] index = {k};
        return helper(root,index).val;
    }
    
    public TreeNode helper(TreeNode cur, int[] index) {
        if(cur==null) return null;
        TreeNode left=helper(cur.left,index);
        if(left!=null) return left;
        index[0]--;
        if(index[0]==0) return cur;
        return helper(cur.right,index);
    }
}
