// http://www.lintcode.com/en/problem/minimum-subarray/
// similar to maximum subarray
import java.util.ArrayList;
public class Lintcode_Minimum_Subarray {
	public int minSubArray(ArrayList<Integer> nums) {
        if(nums==null||nums.size()==0) return 0;
        int n=nums.size();
        int sum=nums.get(0),min=nums.get(0);
        for(int i=1;i<n;i++) {
            sum=Math.min(sum+nums.get(i),nums.get(i));
            min=Math.min(sum,min);
        }
        return min;
    }
}
