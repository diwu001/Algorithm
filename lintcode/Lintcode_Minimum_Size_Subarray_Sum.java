// http://www.lintcode.com/en/problem/minimum-size-subarray-sum/
// Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. 
// If there isn't one, return -1 instead.
// Given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
public class Lintcode_Minimum_Size_Subarray_Sum {
	// nums[] only contains positive numbers, so use two pointer and sliding window,  Time O(n) 
	public int minimumSize(int[] nums, int s) {
	        if(nums==null) return 0;
	        int n=nums.length;
	        int i=0;
	        int sum=0,min=n+1;
	        for(int j=0;j<n;j++) {
	            sum+=nums[j];
	            while(i<=j&&sum>=s) {
	                min=Math.min(min,j-i+1); // update min with the current candidate
	                sum-=nums[i];
	                i++;  //shrink window size
	            }
	        }
	        return min==n+1?-1:min;
	}
	 
//-------------------------------------------------------	 
	 
	 //generate PreSum array which is in ascending order, then do Binary Search in preSum array,  Time O(nlgn) 
	 public static int minimumSize2(int[] nums, int s) {
	        if(nums==null||nums.length==0) return -1;
	        int n=nums.length;
	        int[] sum = new int[n];
	        sum[0]=nums[0];
	        for(int i=1;i<n;i++) sum[i]=sum[i-1]+nums[i];
	        if(sum[n-1]<s) return -1;
	        int min=n;	        
	        for(int i=0;i<n;i++) {
	            int end=search(sum,i+1,s+sum[i]);  // start from index i+1 to search for the position of s+sum[i]
	            if(end<n) min=Math.min(min,end-i);  // start index: i+1, end index: end; 
	            //if end==n means that s+sum[i]>sum[n-1], so the window size is n
	        }	        
	        return min;
	    }
	    
	    public static int search(int[] sum, int start, int target) {
	        int end=sum.length-1;
	        while(start<=end) {
	            int mid=start+(end-start)/2;
	            if(sum[mid]==target) return mid;
	            if(sum[mid]<target) start=mid+1;
	            else end=mid-1;
	        }
	        return start;
	    } 
	    
	    public static void main(String[] args) {
	    	int[] a = {2,3,1,2,4,3};
	    	minimumSize2(a,7);
	    	int[] b = {9,1,2,3,4,5,6,7,8,10};//sum[n-1]=55, then, i=0. target=55+9 end=n min=n
	    	minimumSize2(b,55);
	    }
}
