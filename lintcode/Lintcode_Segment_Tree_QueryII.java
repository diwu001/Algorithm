//http://www.lintcode.com/en/problem/segment-tree-query-ii/
//find the number of elements in the in array's interval [start, end] by the given root of value SegmentTree.

public class Lintcode_Segment_Tree_QueryII {
	public int query(SegmentTreeNode root, int start, int end) {
        if(root==null||root.start>end||root.end<start) 
        	return 0;
        
        if(start<=root.start&&root.end<=end) 
        	return root.count;
        
        return query(root.left,start,end)+query（root.right,start,end);
    }
}
