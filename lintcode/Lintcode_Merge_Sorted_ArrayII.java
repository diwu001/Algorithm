// http://www.lintcode.com/en/problem/merge-sorted-array-ii/
import java.util.ArrayList;
public class Lintcode_Merge_Sorted_ArrayII {
	// normal merge
	public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> C = new ArrayList<Integer>();
        int i=0,j=0;
        while(i<A.size()||j<B.size()) {
            int numa = (i==A.size())? Integer.MAX_VALUE:A.get(i); 
            int numb = (j==B.size())? Integer.MAX_VALUE:B.get(j); 
            if(numa<numb) {
                C.add(numa);
                i++;
            } else {
                C.add(numb);
                j++;
            }
        }
        return C;
    }
	
//-----------------------------------------------------------------------------------
	
	// if one array is very large and the other is very small => binary search
	//A is longer, search B[j] in A to find an insertion position nlgm (m>>n)
	public ArrayList<Integer> mergeSortedArray2(ArrayList<Integer> A, ArrayList<Integer> B) {
		int m=A.size(),n=B.size();
        if(m<n) return mergeSortedArray(B,A);
        for(int i=0;i<n;i++) {
            int pos=find(A,B.get(i));
            A.add(pos,B.get(i));
        }
        return A;
    }
    
    public int find(ArrayList<Integer> A, int val) {
        int low=0,high=A.size()-1;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if(A.get(mid)==val) return mid;
            if(A.get(mid)<val) low=mid+1;
            else high=mid-1;
        }
        return low;
    }
}
