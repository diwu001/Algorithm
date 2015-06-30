import java.util.List;
import java.util.ArrayList;
public class Leetcode_Majority_ElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if(nums==null||nums.length==0) return result;
        
		// Find the initial candidate 1 and candidate 2
		int cand1=nums[0], count1=1, n=nums.length;
        int cand2=0, i=1;
        while(i<n && nums[i]==cand1) {
            i++;
            count1++;
        }
        if(i==n) {
            result.add(cand1);
            return result;
        }
        cand2=nums[i]; 
        i++;
        int count2=1;
        
		// Update candidate 1 and candidate 2
        for(;i<n;i++){
            if(nums[i]==cand1) count1++;
            else if(nums[i]==cand2) count2++;
            else if(count1==0) {
                cand1=nums[i];
                count1++;
            } else if(count2==0) {
                cand2=nums[i];
                count2++;
            } else if(nums[i]!=cand1 && nums[i]!=cand2) {
                count1--;
                count2--;
            }
        }
        
		// Recalculate count1 and count2
        count1=0;
        count2=0;
        for(i=0;i<n;i++){
            if(nums[i]==cand1) count1++;
            if(nums[i]==cand2) count2++;
        }
        if(count1>n/3) result.add(cand1);
        if(count2>n/3) result.add(cand2);
        return result;
    }
}
