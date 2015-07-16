//Given a Binary search tree and a target value, write a function to find the node whose value is closest to target 
public class ClosestValueinBST {
	public static TreeNode closestNode(TreeNode root,int val){
		if(root==null) return null;
		if(root.val==val) return root;
		if(root.val>val) {
			TreeNode left = closestNode(root.left,val);
			return (left!=null&&Math.abs(left.val-val)<Math.abs(root.val-val))? left:root;
		} else {
			TreeNode right = closestNode(root.right,val);
			return (right!=null&&Math.abs(right.val-val)<Math.abs(root.val-val))? right:root;
		}
	}
}
