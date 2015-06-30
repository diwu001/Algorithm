//http://www.lintcode.com/en/problem/partition-array/
public class Lintcode_Partition_Array {
	// partition in quick sort
	public int partitionArray(int[] nums, int k) {
	    if(nums==null||nums.length==0) return 0;
	    int n=nums.length;
	    int i=0,j=n-1;
	    while(i<j) {
	        while(i<j&&nums[i]<k) i++;
	        while(i<j&&nums[j]>=k) j--;
	        if(i<j) {
	            int temp=nums[i];
	            nums[i]=nums[j];
	            nums[j]=temp;
	            i++;
	            j--;
	        }
	    }
	    return (nums[i]<k)?i+1:i;  //if i==j, we didn't check nums[i] in the while loop, so check it here
    }
}
