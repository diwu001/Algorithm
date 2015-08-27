//http://www.lintcode.com/en/problem/interval-minimum-number/
import java.util.ArrayList;
public class Lintcode_Segment_Tree_Interval_Minimum_Number {
    class SegmentTreeNode {
    	public int start, end;
    	public SegmentTreeNode left, right;
    	public int min;
    	public SegmentTreeNode(int start, int end) {
    	   this.start = start;
    	   this.end = end;
    	}
    	public SegmentTreeNode(int start, int end, int min) {
    	   this.start = start;
    	   this.end = end;
    	   this.min = min;
    	}
    }

    public SegmentTreeNode build(int[] A, int start, int end) {
        if(start>end) return null;
        SegmentTreeNode root = new SegmentTreeNode(start,end,A[start]);
        if(start==end) return root;
        
        int mid=start+(end-start)/2;
        root.left= build(A,start,mid);
        root.right= build(A,mid+1,end); 
        
        int min=Integer.MAX_VALUE;
        if(root.left!=null) min=root.left.min;  
        if(root.right!=null) min=Math.min(root.right.min,min);
        root.min=min;
        return root;
    }
    
    public int query(SegmentTreeNode root, int start, int end) {
        if(root==null||root.end<start||root.start>end) return Integer.MAX_VALUE;
        if(root.start >= start && root.end <= end) return root.min; 
        return Math.min(query(root.left,start,end),query(root.right,start,end));
    }
    
    public ArrayList<Integer> intervalMinNumber(int[] A, ArrayList<Interval> queries) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        SegmentTreeNode root = build(A,0,A.length-1);
        for(Interval i:queries) {
            result.add(query(root,i.start,i.end));
        }
        return result;
    }
}
