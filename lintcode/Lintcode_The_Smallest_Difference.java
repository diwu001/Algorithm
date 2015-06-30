//http://www.lintcode.com/en/problem/the-smallest-difference/
//difference between A[i] and B[j] (|A[i] - B[j]|) is as small as possible, return their smallest difference.
import java.util.Arrays;
public class Lintcode_The_Smallest_Difference {
	// Sort then use two pointers
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
}
