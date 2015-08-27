/*Given a binary tree, return the pre-order traversal of its nodes' values.
  For example:
  Given binary tree {1,#,2,3}, return [1,2,3]. Recursive solution is trivial, could you do it iteratively? 
   1
    \
     2
    /
   3 */

/*public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}*/

package binary_tree_preorder_traversal;

import java.util.ArrayList;

public class Binary_Tree_Preorder_Traversal {
	// Recursive solution
	public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        result.add(root.val);
        if(root.left!=null) result.addAll(preorderTraversal(root.left));
        if(root.right!=null) result.addAll(preorderTraversal(root.right));
        return result;       
    }
	
	// Iterative solution 1
	public ArrayList<Integer> preorderTraversal2(TreeNode root) {
		ArrayList<Integer> preorder = new ArrayList<Integer>();
		if (root==null) return preorder;
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
		while(!s.isEmpty() || cur!=null){
			if(cur!=null){
				preorder.add(cur.val);
				s.push(cur);
				cur = cur.left;
			}
			else{
				cur=s.pop();
				cur = cur.right;
			}		
		}
		return preorder;
	}
	
	// Iterative solution 2
	public ArrayList<Integer> preorderTraversal3(TreeNode root) {
		ArrayList<Integer> returnList = new ArrayList<Integer>();
		if(root == null) return returnList;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while(!stack.empty()){
		    TreeNode n = stack.pop();
		    returnList.add(n.val);
		    if(n.right != null) stack.push(n.right);  	    
		    if(n.left != null) stack.push(n.left);
		}
		return returnList;
	}
}
