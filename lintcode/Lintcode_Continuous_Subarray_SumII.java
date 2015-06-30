//http://www.lintcode.com/en/problem/continuous-subarray-sum-ii/

import java.util.ArrayList;

public class Lintcode_Continuous_Subarray_SumII {   
	/**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
	public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        if(A==null||A.length==0) return result1;
        int cand1 = noCircle(A,result1);
        int cand2 = withCircle(A,result2);
        return (cand1>cand2)? result1:result2;
    }
    
	// Same as Continuous_Subarray_Sum I
    public int noCircle(int[] A, ArrayList<Integer> result) {
        result.add(0);
        result.add(0);
        int sum=A[0],maxSum=A[0],i=0,j=1,n=A.length;
        while(j<n) {
            sum+=A[j];
            if(sum<A[j]) {
                i=j;  
                sum=A[j];
            }
            if(maxSum<sum) {
                result.set(0,i);  
                result.set(1,j);  
                maxSum=sum;
            }
            j++;
        }
        return maxSum;
    }
    
    public int withCircle(int[] A, ArrayList<Integer> result) {
        result.add(0);
        result.add(0);
        int n=A.length;
		
        int[] leftMax = new int[n];   //the maxSum from 0 to j 
        int[] endPos = new int[n];  //from 0 to j where the maxSum ends 
        int sum=A[0],j=1;
        endPos[0]=0;
        leftMax[0]=A[0];
        while(j<n) {
            sum+=A[j];
            if(leftMax[j-1]<sum) {
                leftMax[j]=sum;
                endPos[j]=j;
            } else {
                leftMax[j]=leftMax[j-1];
                endPos[j]=endPos[j-1];
            }
            j++;
        }
        
        int[] rightMax = new int[n];  //the maxSum from n-1 to j+1 
        int[] startPos = new int[n];  //from n-1 to j+1 where the maxSum starts 
        sum=0;  
        j=n-2;  
        startPos[n-1]=0;
        rightMax[n-1]=0;
        while(j>=0) {  
            sum+=A[j+1];
            if(rightMax[j+1]<sum) {
                rightMax[j]=sum;
                startPos[j]=j+1;  
            } else {
                rightMax[j]=rightMax[j+1];
                startPos[j]=startPos[j+1];
            }
            j--;
        }
        
        int circularMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; ++i) {
            if (leftMax[i] + rightMax[i] > circularMax) {
                circularMax = leftMax[i] + rightMax[i];
                result.set(0,startPos[i]);
                result.set(1,endPos[i]);
            }
        }

        return circularMax;
    }
}
