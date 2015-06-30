//http://www.lintcode.com/en/problem/maximum-subarray-ii/
import java.util.ArrayList;
public class Lintcode_Maximum_SubarrayII {
	 // DP forward-backward traversal
	 public int maxTwoSubArrays(ArrayList<Integer> nums) {
	        if(nums==null||nums.size()<=1) return 0;
	        int n=nums.size();
	        int[] left = new int[n];
	        int[] right = new int[n];
	        
	        left[0]=nums.get(0);
	        int sum=nums.get(0);
	        for(int i=1;i<n;i++) {
	            sum=Math.max(sum+nums.get(i),nums.get(i));  //left[i] is the largest subarray sum between 0~i
	            left[i]=Math.max(left[i-1],sum);
	        }
	        
	        right[n-1]=Integer.MIN_VALUE;
	        sum=0;
	        for(int i=n-2;i>=0;i--) {
	            sum=Math.max(sum+nums.get(i+1),nums.get(i+1));  //right[i] is the largest subarray sum between i+1~n-1
	            right[i]=Math.max(right[i+1],sum);
	        }
	        
	        int max=nums.get(0)+nums.get(n-1);  // for n=2, return max
	        for(int i=0;i<n-1;i++) {
	            max=Math.max(max,left[i]+right[i]);  //left[i] may end with i,  right[i] may start with i+1, so nums[i] wont be calculated twice
	        }
	        return max;
	}
}
