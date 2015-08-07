
public class Count_Complete_TreeNodes {
    // Binary search, Time O(h^2), h is the height of the tree
    public int leftHeight(TreeNode root){
         if (null==root) return 0;
         return 1 + leftHeight(root.left);
     }
     public int rightHeight(TreeNode root){
         if (null==root ) return 0;
         return 1 + rightHeight(root.right);
     }
     public int countNodes(TreeNode root) {
        if (null==root) return 0;
        int hl = leftHeight(root);
        int rl = rightHeight(root);
        if (hl == rl) 
            return (1<<hl) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
     }
}
