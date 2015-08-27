// http://www.lintcode.com/problem/count-of-smaller-number
// For [1,2,7,8,5], and queries [1,8,5], return [0,4,2]
import java.util.ArrayList;
import java.util.Arrays;

public class Lintcode_Count_of_Smaller_Number {
	// Use binary search to search for a range. Another solution is segment tree
	//Time complexity: O(nlgn+mlgn) n is the length of A, m is the length of queries, Space: O(1)
	public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {  
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(queries==null||queries.length==0) return result;
        int m=queries.length;
        if(A==null||A.length==0) {
            for(int i=0;i<m;i++) result.add(0);
            return result;
        }
        int n=A.length;
        Arrays.sort(A);  // no requirement about index order, so we can sort A
        for(int i=0;i<m;i++) {
            int pos = bs(queries[i],A,0,n-1);
            result.add(pos);
        }
        
        return result;
    }
    
    public int bs(int target, int[] A, int low, int high) { //find the last index of the number which is less than target
    // e.g. [1, 2, 3] target=3 return 2; target=1 return 0
        int pos=high+1;
        boolean flag=false;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(A[mid]==target) {
                pos=Math.min(pos,mid);   // in case of duplicate number of target. e.g. [1 2 3 3] target=3 return 2
                high=mid-1;
                flag=true;
            }
            if(A[mid]<target) low=mid+1;
            else high=mid-1;
        }
        return flag?pos:low;  // i.e. [1 2 5 7 8] target=4 flag=false return low=2
    }
    
    //------------------------------------------------------------------------
    //Time complexity: O(nlgn+mlgn) n is the length of A, m is the length of queries, Space: O(n)
	public ArrayList<Integer> countOfSmallerNumber2(int[] A, int[] queries) {  //Segment Tree
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null || queries == null || queries.length == 0)  return res;
        Arrays.sort(A);
        MaxNode root = buildTree(A, 0, A.length - 1);
        for (int q : queries)  res.add(query(A, root, q));
        return res;
    }
    
    private MaxNode buildTree(int[] A, int start, int end) {
        if (start > end)  return null;        
        MaxNode root = new MaxNode(start, end);  //[start=0 end=4], val is the max number in the interval 8
        if (start == end) root.val = A[start];   //[start=0 end=0], val=1  [start=1 end=1], val=2 ...
        else {
            root.left = buildTree(A, start, (start+end)/2);
            root.right = buildTree(A, (start+end)/2+1, end);
            root.val = root.left == null ? root.right.val : Math.max(root.left.val, root.right == null ? 0 : root.right.val);
        }
        return root;
    }
    /*                        [0,4]8
     *             [0,2]5               [3,4]8
     *       [0,1]2     [2,2]5      [3,3]7    [4,4]8
     *    [0,0]1 [1,1]2
     * */
    
    private int query(int[] A, MaxNode root, int val) {
        if (root == null || A[root.start] > val) {  //val is smaller than the smallest val in tree with root
            return 0;
        }
        if (root.val < val) {  //val is greater than the maximal val in tree with root, so all elements in root tree is smaller than val
            return root.end - root.start + 1; 
        }
        return query(A, root.left, val) + query(A, root.right, val);
    }
    
    class MaxNode {
        int start;
        int end;
        int val; //the maximal value in A[start] and A[end]
        MaxNode left;
        MaxNode right;
        public MaxNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
