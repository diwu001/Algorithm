// http://www.lintcode.com/en/problem/recover-rotated-sorted-array/
//Given a rotated sorted array, recover it to sorted array in-place.
//[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]
import java.util.ArrayList;
public class Lintcode_Recover_Rotated_Sorted_Array {
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        if(nums==null||nums.size()==1) return;
        int pos=0;
        for(;pos<nums.size()-1;pos++) {
            if(nums.get(pos)>nums.get(pos+1)) break;  //find the rotation start point:  pos=1, nums[pos]=5
        }
        if(pos==0) return;  // already sorted, no need to recover
        reverse(nums,0,pos);
        reverse(nums,pos+1,nums.size()-1);
        reverse(nums,0,nums.size()-1);
    }
    
    public void reverse(ArrayList<Integer> nums, int s, int e) {
        for(;s<e;s++,e--) {
            int temp=nums.get(s);
            nums.set(s,nums.get(e));
            nums.set(e,temp);
        }   
    }

    //-----------------------------------------------------------------------
    
    // only work for sorted array without duplicates
    // mid may be the rotation index, so must update low/high=mid not mid+/-1
    public int findRotatePoint(ArrayList<Integer> nums, int low, int high) {
        int n=nums.size();
		while(low<high) {
			if(low+1==high) {
				if(nums.get(low)<nums.get(high)&&high==n-1) return 0;  // already sorted, no rotation
				else break;
			}
			
			int mid=low+(high-low)/2;
			if(nums.get(mid)>nums.get(low)) low=mid;  //[low,mid] is sorted, rotation point is in [mid~high]
			else high=mid;  //[low,mid] isn't sorted, rotation point is in [low~mid]	
		}
		return high;
    }
}
