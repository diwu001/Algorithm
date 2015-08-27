import java.util.HashSet;
public class Contains_Duplicate {
	public boolean containsDuplicate(int[] nums) {
        if(nums==null||nums.length==0) return false;
        int n=nums.length;
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i=0;i<n;i++) {
            if(!set.add(nums[i])) return true;
            else continue;
        }
        
        return false;
    }
}
