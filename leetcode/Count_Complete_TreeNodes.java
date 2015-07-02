
public class Count_Complete_TreeNodes {
    public static int countNodes(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;
        int minDepth = helper1(root);
        int maxDepth = helper2(root);
        if(minDepth==maxDepth) return (int)Math.pow(2,maxDepth)-1;
       
        int low=0,high=(int)Math.pow(2,minDepth)-1;
        TreeNode n=root;
        int d=minDepth;
        while(low<high&&n!=null) {
            int mid=low+(high-low)/2;
            if(check(n,d)) {
                high=mid-1;
                n=n.left;
            } else {
                low=mid;
                n=n.right;
            }
            d=d-1;
        }
        return low+(int)Math.pow(2,minDepth);
    }
    
    public static boolean check(TreeNode root,int d) {
        TreeNode cur=root.left;
        while(cur!=null) {
            cur=cur.right;
            d--;
        }
        if(d==1) return true;  //nil at last level
        return false;
    }
    public static int helper1(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null||root.right==null) return 1;
        return 1+Math.min(helper1(root.left),helper1(root.right));
    }
    
    public static int helper2(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null&&root.right==null) return 1;       
        return 1+Math.max(helper2(root.left),helper2(root.right));
    }
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(1);
    	root.left=new TreeNode(2);
    	root.right=new TreeNode(3);
    	root.left.left=new TreeNode(4);
    	root.left.right=new TreeNode(5);
    	root.right.left=new TreeNode(6);
    	root.right.right=new TreeNode(7);
    	root.left.left.left=new TreeNode(8);
    	root.left.left.right=new TreeNode(9);
    	System.out.println(countNodes(root));
    }
}
