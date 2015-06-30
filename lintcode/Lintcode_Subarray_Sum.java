//http://www.lintcode.com/en/problem/subarray-sum/
import java.util.ArrayList;
import java.util.HashMap;

public class Lintcode_Subarray_Sum {
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
	// Similiar to "Two Sum" problem. 
	// Use a variable sum to store pre sum from nums[0] to nums[i]
	// Time Complexity: O(n) Space Complexity: O(n) 
    public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(nums==null||nums.length==0) return result;
        int n=nums.length;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,-1);
        int sum=0;
        for(int i=0;i<n;i++) {
            sum+=nums[i];
            if(!map.containsKey(sum)) map.put(sum,i);
            else {
                result.add(map.get(sum)+1);
                result.add(i);
                break;
            }
        }
        return result;
    }
}
