//http://www.lintcode.com/en/problem/segment-tree-modify/
public class Lintcode_Segment_Tree_Modify {
	public void modify(SegmentTreeNode root, int index, int value) {
        if(root==null||index<root.start||index>root.end) return;  //index is out of root's index range
        
        if(root.start==index&&root.end==index) {  //find the interval to modify it's max
            root.max=value;
            return;
        }
        
        int mid = root.start+(root.end-root.start)/2;
        if(index<=mid) {
            modify(root.left,index,value);
        } else {
            modify(root.right,index,value);
        }
        
        root.max=Math.max(root.left.max,root.right.max);  //update at the current level
    }
}
