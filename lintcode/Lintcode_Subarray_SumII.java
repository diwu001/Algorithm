//http://www.lintcode.com/en/problem/subarray-sum-ii/
public class Lintcode_Subarray_SumII {
	/**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
	// Two points: i is the start point of the window, j is the end point
	// Time Complexity: O(n) Space Complexity: O(1) 
    public int subarraySumII(int[] A, int start, int end) {
        if(A==null||A.length==0) return 0;
        int n=A.length;
        int i=0,j=0,sum=0,count=0;
        while(j<n||i<n) {
            sum+=A[j];
            if(sum>=start&&sum<=end) {
                count++;  //find a valid pair
                j++;
            } else if(sum<start){
                 j++;
            } else {
                sum=0;
                i++;
                j=i;
            }
            
            //Even though pointer j reaches n, pointer i may still < n and there maybe some valid pairs starting from i
            if(j==n&&i<n) {  
                sum=0;
                i++;
                j=i;
            }
        }
        return count;
    }
}
