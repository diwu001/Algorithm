//http://www.lintcode.com/en/problem/maximum-subarray-difference/
//Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest. Return the largest difference.
import java.util.ArrayList;
public class Lintcode_Maximum_Subarray_Difference {
	// DP forward-backward traversal
	// find max( |leftMax[i]-rightMin[i]|, |rightMax[i]-leftMin[i]|)
	public int maxDiffSubArrays(ArrayList<Integer> nums) {
        if(nums==null||nums.size()<=1) return 0;
        int n=nums.size();
        
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0]=nums.get(0);
        int sum=nums.get(0);
        for(int i=1;i<n;i++) {
            sum=Math.max(sum+nums.get(i),nums.get(i));  
            leftMax[i]=Math.max(leftMax[i-1],sum);
        }
        
        rightMax[n-1]=Integer.MIN_VALUE;
        sum=0;
        for(int i=n-2;i>=0;i--) {
            sum=Math.max(sum+nums.get(i+1),nums.get(i+1));  
            rightMax[i]=Math.max(rightMax[i+1],sum);
        }
        
        int[] leftMin = new int[n];
        int[] rightMin = new int[n];
        leftMin[0]=nums.get(0);
        sum=nums.get(0);
        for(int i=1;i<n;i++) {
            sum=Math.min(sum+nums.get(i),nums.get(i));  
            leftMin[i]=Math.min(leftMin[i-1],sum);
        }
        
        rightMin[n-1]=Integer.MAX_VALUE;
        sum=0;
        for(int i=n-2;i>=0;i--) {
            sum=Math.min(sum+nums.get(i+1),nums.get(i+1));  
            rightMin[i]=Math.min(rightMin[i+1],sum);
        }
        
        int maxDif=Math.abs(nums.get(0)-nums.get(n-1));  
        for(int i=0;i<n-1;i++) {
            int cand1=Math.abs(leftMax[i]-rightMin[i]);
            int cand2=Math.abs(rightMax[i]-leftMin[i]);
            maxDif=Math.max(maxDif,Math.max(cand1,cand2));  
        }
        return maxDif;
	}
}
