//http://www.lintcode.com/en/problem/subtree/
public class Lintcode_SubTree {
	public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if(T1==null&&T2==null) return true;
        if(T1==null) return false;
        return helper(T1,T2) ||  // T1 and T2 can totally match all nodes
        	   isSubtree(T1.left,T2)||  //search possible match in the left subtree of T1
        	   isSubtree(T1.right,T2);  //search possible match in the right subtree of T1
    }
    
    public boolean helper(TreeNode T, TreeNode T2) { // T and T2 can totally match all nodes
        if(T==null&&T2==null) return true;
        if(T==null||T2==null) return false;
        if(T.val!=T2.val) return false;
        return helper(T.left,T2.left)&&helper(T.right,T2.right);
    }
}
