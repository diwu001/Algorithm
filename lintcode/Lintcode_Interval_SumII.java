//http://www.lintcode.com/en/problem/continuous-subarray-sum-ii/
//O(logN) time for query and modify.
public class Lintcode_Segment_Tree_Interval_SumII {
    class SegmentTreeNode {
    	public int start, end;
    	public SegmentTreeNode left, right;
    	public long sum;
    	public SegmentTreeNode(int start, int end) {
    	   this.start = start;
    	   this.end = end;
    	}
    	public SegmentTreeNode(int start, int end, long sum) {
    	   this.start = start;
    	   this.end = end;
    	   this.sum = sum;
    	}
    }

    public SegmentTreeNode build(int[] A, int start, int end) {
        if(start>end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start,end,(long)A[start]);
        if(start==end) return root;
        
        int mid=start+(end-start)/2;
        root.left= build(A,start,mid);
        root.right= build(A,mid+1,end); 
        
        long sum=0;
        if(root.left!=null) sum=root.left.sum;  // cannot use root.sum+=root.left.sum
        if(root.right!=null) sum+=root.right.sum;
        root.sum=sum;
        return root;
    }

    private  SegmentTreeNode root;
    public Lintcode_Segment_Tree_Interval_SumII(int[] A) {
        root = build(A,0,A.length-1);
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        return queryHelper(root,start,end);
    }
    
    public long queryHelper(SegmentTreeNode root, int start, int end) {
        if(root==null||root.end<start||root.start>end) return 0;
        if(root.start >= start && root.end <= end) return root.sum;  //start..root.start..root.end..end, i.e. [start,end] contains interval of root
        return queryHelper(root.left,start,end)+queryHelper(root.right,start,end);
    }
   
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        modifyHelper(root,index,value);
    }
    
    public void modifyHelper(SegmentTreeNode root, int index, int value) {
        if(root==null||index<root.start||index>root.end) return;
        if(root.start==index&&root.end==index) {
            root.sum=value;
            return;
        }
        int mid = root.start+(root.end-root.start)/2;
        if(index<=mid) {
            modifyHelper(root.left,index,value);
        } else {
            modifyHelper(root.right,index,value);
        }
        long sum=0;
        if(root.left!=null) sum=root.left.sum;
        if(root.right!=null) sum+=root.right.sum;
        root.sum=sum;  //update sum at current node
    }
}
