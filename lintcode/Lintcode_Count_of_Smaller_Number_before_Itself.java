public class Lintcode_Count_of_Smaller_Number_before_Itself {
    class RankNode{
        RankNode left, right;
        int val;
        int leftSize;
        RankNode(int x) {
            val=x;
        }
        
		// insert to left/right subtree, O(lgn) for balance BST
        void insertRankNode(int x) {
            if(x<val) {
                if(left==null) left = new RankNode(x);
                else left.insertRankNode(x);
                leftSize++;
            } else {
                if(right==null) right = new RankNode(x);
                else right.insertRankNode(x);
            }
        }
        
        int getRankNode(int x){
            if(x==val) return leftSize;
            if(x<val) {
                if(left==null) return -1;
                return left. getRankNode(x);
            } else {
                if(right==null) return -1;
                int rightRank = right.getRankNode(x);
                return leftSize+1+rightRank;
            }
        }
    }
    
    RankNode root;
    
    void insert(int x) {
        if(root==null) root=new RankNode(x);
        else root.insertRankNode(x);
    }
    
    int getRank(int x) {
        return root.getRankNode(x);
    }
    
    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || A.length == 0) return res;
        
        for (int i = 0; i < A.length; i++) {
            insert(A[i]);
            res.add(getRank(A[i]));  // number of nodes in left subtree
        }
        return res;
    }
}
