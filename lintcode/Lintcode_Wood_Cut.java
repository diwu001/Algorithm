//http://www.lintcode.com/en/problem/wood-cut/
public class Lintcode_Wood_Cut {
    // Binary search for the largest possible length to get K woods
    public int woodCut(int[] L, int k) {
        if(L==null||L.length==0||k==0) return 0;
        int max=-1;
        for(int i:L) max=Math.max(max,i);
        int low=1,high=max,n=L.length;
        int cand=0;
        while(low<=high) {
            int count=0;
            int mid=low+(high-low)/2;
            for(int i=0;i<n;i++) {
                count+=L[i]/mid;
                if(count>=k) break;
            }
            
            if(count>=k) { // current length can satisfy K woods, so search for a larger length
            	cand=Math.max(cand,mid);
            	low=mid+1; 
            } else { // current length can't satisfy K woods, so search for a smaller length
            	high=mid-1; 
            }
        }
        return cand; // If we can find a valid cut, return cand (cand>0); If there is no valid cut, return 0
    }
}
