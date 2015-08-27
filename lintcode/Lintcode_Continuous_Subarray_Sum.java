//http://www.lintcode.com/en/problem/continuous-subarray-sum/
import java.util.ArrayList;

public class Lintcode_Continuous_Subarray_Sum {
	/**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
	
	// similiar to maximum subarray sum, but needs to return the start/end index
	public ArrayList<Integer> continuousSubarraySum(int[] A) {
        ArrayList<Integer> result = new  ArrayList<Integer>();
        if(A==null||A.length==0) return result;
        result.add(0);
        result.add(0);
        int sum=A[0],maxSum=A[0],i=0,j=1,n=A.length;
        while(j<n) {
            sum+=A[j];
            if(sum<A[j]) {
                i=j;  //update start point
                sum=A[j];
            }
            if(maxSum<sum) {
                result.set(0,i);  // if find a maxSum, use previous recorded start point
                result.set(1,j);  //update end point
                maxSum=sum;
            }
            j++;
        }
        return result;
    }
}
