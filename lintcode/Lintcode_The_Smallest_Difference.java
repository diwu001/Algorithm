//http://www.lintcode.com/en/problem/the-smallest-difference/
//difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.
import java.util.Arrays;
public class Lintcode_The_Smallest_Difference {
    // Solution1: Sort then use two pointers, Time O(n)
    public int smallestDifference(int[] A, int[] B) {
        if(A==null||A.length==0||B==null||B.length==0) return 0;
        int m=A.length,n=B.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int i=0,j=0;
        int dif=Integer.MAX_VALUE;
        while(i<m&&j<n) {
            if(A[i]==B[j]) {
                return 0;
            } else if(A[i]<B[j]) {
                dif=Math.min(dif,B[j]-A[i]);
                i++;
            } else {
                dif=Math.min(dif,A[i]-B[j]);
                j++;
            }
        }
        return dif;
    }
	
    //Solution2: Binary Search, Time O(nlng)
    public int smallestDifference2(int[] A, int[] B) {
        if(A==null||A.length==0||B==null||B.length==0) return 0;
        int m=A.length,n=B.length;
        Arrays.sort(A);

        int dif=Integer.MAX_VALUE;
        for(int i=0; i<B.length; i++) {
            int cand = helper(A, B[i]);
            if(cand<dif) dif=cand;
        }
        return dif;
    }
    
    public int helper(int[] A, int t) {
        int n=A.length, res1=-1, res2=n;
        int low=0, high=n-1;
        while(low<=high) {  // find the last index whose value <=t
            int mid=low+(high-low)/2;
            if(A[mid]<=t) {
                res1 = Math.max(res1,mid);
                low=mid+1;
            } else high=mid-1;
        }
        
        low=0; high=n-1;
        while(low<=high) {  // find the first index whose value >=t
            int mid=low+(high-low)/2;
            if(A[mid]>=t) {
                res2 = Math.min(res2,mid);
                high=mid-1;
            } else low=mid+1;
        }
        
        if(res1!=-1 && res2!=n) return Math.min(t-A[res1],A[res2]-t);
        else if(res2!=n) return A[res2]-t;
        else return t-A[res1];
    }
}
