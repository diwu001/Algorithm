import java.util.PriorityQueue;
import java.util.Random;
public class Kth_Largest_Element_in_Array {
	public int findKthLargest(int[] nums, int k) {
        if(nums==null||nums.length==0) return -1;
        int n=nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i=0;i<k;i++) pq.offer(nums[i]);
        for(int i=k;i<n;i++) {
            if(nums[i]>pq.peek()) {
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }
	
//------------------------------------------------------------------	

	public static int findKthLargest2(int[] nums, int k) {
        if(nums==null||nums.length==0) return -1;
        int n=nums.length;
        return search(nums,n+1-k,0,n-1);
    }
    
	 public static int search(int[] nums, int k, int low, int high) {
	        if(low==high) return nums[low];
	        Random r = new Random();
	        int p = r.nextInt(high-low+1);
	        int temp=nums[low+p];
	        nums[low+p]=nums[high];
	        nums[high]=temp;
	        int pos = partition(nums,low,high);
	        if(pos-low==k-1) return nums[pos];
	        if(pos-low>k-1) return search(nums,k,low,pos-1);
	        else return search(nums,k-(pos-low+1),pos+1,high);
	    }
    
    public static int partition(int[] nums,int l, int h) {
    	int i=0;
    	for(int j=0;j<=h-1;j++) {
    		if(nums[j]<=nums[h]) {
    			int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
    		}
    	}
    	int temp=nums[i];
        nums[i]=nums[h];
        nums[h]=temp;
        return i;
    }  
}
