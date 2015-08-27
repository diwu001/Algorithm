// http://www.lintcode.com/en/problem/segment-tree-query/
// find the maximum number in the interval [start, end] by the given root of segment tree.

public class Lintcode_Segment_Tree_Query {
	public int query(SegmentTreeNode root, int start, int end) {
        if(root==null||root.start>end||root.end<start) //[start,end] not intersect with interval of root
        	return Integer.MIN_VALUE;
        
        if(start<=root.start&&root.end<=end) // [start,end] contains interval of root
        	return root.max;
        
        return Math.max(query(root.left,start,end),query(root.right,start,end));  //[start,end] partly intersect with interval of root
    }
}
