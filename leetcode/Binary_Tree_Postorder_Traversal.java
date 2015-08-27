/*Given a binary tree, return the post-order traversal of its nodes' values.
  For example:
  Given binary tree {1,#,2,3}, return [3,2,1]. Note: Recursive solution is trivial, could you do it iteratively?
   1
    \
     2
    /
   3   */

/*public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}*/

import java.util.ArrayList;

public class Binary_Tree_Postorder_Traversal {
    // Recursive solution
    ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        if(root.left!=null) result.addAll(postorderTraversal(root.left));
        if(root.right!=null) result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;        
    }
	
    // Iterative solution 1
    ArrayList<Integer> postorderTraversal2(TreeNode root) {
	ArrayList<Integer> postorder = new ArrayList<Integer>();
	if (root==null) return postorder;
	Stack<TreeNode> s = new Stack<TreeNode>();
	TreeNode cur = root;
	while(!s.isEmpty() || cur!=null){
		if(cur!=null) {
			postorder.add(0,cur.val);
			s.push(cur);
			cur = cur.right;
	        } else {
	              cur=s.pop();
	              cur=cur.left;
	        }
	}
	return postorder;
    }
	
    // Iterative solution 2
    ArrayList<Integer> postorderTraversal3(TreeNode root) {
	ArrayList<Integer> postorder = new ArrayList<Integer>();
	if (root==null) return postorder;
	Stack<TreeNode> s = new Stack<TreeNode>();
	TreeNode cur = root;
	s.push(cur);
	while(!s.isEmpty()){
		cur = s.pop();
		if(cur.left!=null) s.push(cur.left);  
		if(cur.right!=null) s.push(cur.right);
		postorder.add(0,cur.val);
	}
	return postorder;
    }
	
    //Iterative solution 3
    List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur = root, pre = null;
        while(cur != null || !s.isEmpty()) {
            if(cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                TreeNode temp = s.peek();
                if(temp.right!=null && pre!=temp.right) cur = temp.right;
                else {
                    result.add(temp.val);
                    pre = temp;
                    s.pop();
                }
            }
        }
        return result;
    }
}
