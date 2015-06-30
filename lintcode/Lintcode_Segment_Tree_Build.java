//http://www.lintcode.com/en/problem/segment-tree-build/
public class Lintcode_Segment_Tree_Build {
	/**
	 * Definition of SegmentTreeNode:
	 * public class SegmentTreeNode {
	 *     public int start, end;
	 *     public SegmentTreeNode left, right;
	 *     public SegmentTreeNode(int start, int end) {
	 *         this.start = start, this.end = end;
	 *         this.left = this.right = null;
	 *     }
	 * }
	 */
	public SegmentTreeNode build(int start, int end) {
        if(start>end) return null;
        int mid=start+(end-start)/2;
        SegmentTreeNode root = new SegmentTreeNode(start,end);
        if(start==end) return root;
        root.left= build(start,mid);
        root.right= build(mid+1,end); 
        return root;
    }
}
