//http://www.lintcode.com/en/problem/interleaving-positive-and-negative-numbers/
public class Lintcode_Interleaving_Positive_and_Negative_Numbers {
	// partition in quick sort
	// If total number of positives is greater than the total number of negatives, let the first number to be positive.
	// After interleaving, there may be more positive numbers at the end of A. All remaining numbers stay in the end of A.
	// e.g. [-1, -2, -3, 4, 5, 6] =>  posId = 1, negId = 0
	// -2 swap with 5, [-1, 5, -3, 4, -2, 6], since num[1] should >0, and num[4] should <0
	public void rerange(int[] A) {
        if(A==null||A.length<2) return;
        int n=A.length;
        int countPos=0 , countNeg=0;
        for(int i=0;i<n;i++) {
            if(A[i]>0) countPos++;
            else countNeg++;
        }
        int posId= (countPos>countNeg)? 0:1;
        int negId= (countPos<=countNeg)? 0:1;
        while(posId<n&&negId<n) {
            while(posId<n&&A[posId]>0) posId+=2;
            while(negId<n&&A[negId]<0) negId+=2;
            if(posId<n&&negId<n) {
                int temp=A[posId];
                A[posId]=A[negId];
                A[negId]=temp;
                posId+=2;
                negId+=2;
            }
        }
    }
}
