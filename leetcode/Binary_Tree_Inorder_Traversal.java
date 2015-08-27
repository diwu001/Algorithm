/*Given a binary tree, return the in-order traversal of its nodes' values.
  For example:
  Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
  return [1,3,2].
  Note: Recursive solution is trivial, could you do it iteratively?*/

/* public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
} */

package binary_tree_inorder_traversal;

import java.util.ArrayList;

public class Binary_Tree_Inorder_Traversal {
	
	// Recursive solution
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        if(root.left!=null) result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        if(root.right!=null) result.addAll(inorderTraversal(root.right));
        return result;
    }
	
	// Iterative solution
	public ArrayList<Integer> inorderTraversal2(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null) return result;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode cur=root;
        while(cur!=null||!s.isEmpty()) {
            if(cur!=null) {
              s.push(cur);
              cur=cur.left;
            } else {
              cur=s.pop();
              result.add(cur.val);
              cur=cur.right;
            }
        }
        return result;
    }
}
