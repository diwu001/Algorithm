//http://www.lintcode.com/en/problem/median/
public class Lintcode_Median {
	public int median(int[] nums) {
        if(nums==null||nums.length==0) return -1;
        int n=nums.length;
        if(n%2==1) return helper(nums,0,n-1,n/2+1);  
        else return helper(nums,0,n-1,n/2);
    }
    
	// find the kth smaller element
    public int helper(int[] nums, int s, int e, int k) {
        if(s==e) return nums[s];
        int pos = partition(nums,s,e);
        if(pos-s==k-1) return nums[pos];
        if(pos-s<k-1) return helper(nums,pos+1,e,k-(pos-s+1));
        else return helper(nums,s,pos-1,k);
    }
    
    public int partition(int[] nums, int s, int e) {
        int i=s;
        for(int j=s;j<e;j++) {
            if(nums[j]<=nums[e]) {
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
        int temp=nums[i];
        nums[i]=nums[e];
        nums[e]=temp;
        return i;
    }
}
