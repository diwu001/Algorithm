//http://www.lintcode.com/en/problem/continuous-subarray-sum-ii/

import java.util.ArrayList;

public class Lintcode_Continuous_Subarray_SumII {   
    /* Solution 1: Time O(n), Space O(1)
       For the max subarray sum with circle, find the min subarray sum without circle, 
       then the remaining elements yield a max subarray sum with cycle 
       Edge case: (1) min subarray.end==n-1, result2[1]=n, remaining max subarray is in [0, min subarray.start-1];
                  (2) min subarray.start==0, result2[0]=-1, remaining max subarray is in [min subarray.end+1, n-1] */
    public ArrayList<Integer> continuousSubarraySumII_2(int[] A) {
        ArrayList<Integer> result1 = new ArrayList<Integer>();
        ArrayList<Integer> result2 = new ArrayList<Integer>();
        if(A==null||A.length==0) return result1;
        int cand1 = maxSubarraySum(A,result1);  // no circle
        int totalSum = 0;
        for(int num: A) totalSum += num;
        int cand2 = totalSum - minSubarraySum(A, result2);
        if(result2.get(0)>=A.length || result2.get(1)<0) return result1;
        return (cand1>cand2)? result1:result2;
    }
    
    public int maxSubarraySum(int[] A, ArrayList<Integer> result) {
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
    
    public int minSubarraySum(int[] A, ArrayList<Integer> result) {
        result.add(0);
        result.add(0);
        int sum=A[0],minSum=A[0],i=0,j=1,n=A.length;
        while(j<n) {
            sum+=A[j];
            if(sum>A[j]) {
                i=j;  
                sum=A[j];
            }
            if(minSum>sum) {
                result.set(0,j+1);  
                result.set(1,i-1);  
                minSum=sum;
            }
            j++;
        }
        return minSum;
    }
    
/********************************************************************************/

    /* Solution 2: Time O(n), Space O(n)
       Calculate max subarray sum with / withour circle */
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
