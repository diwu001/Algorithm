import java.util.List;
import java.util.ArrayList;
public class Summary_Ranges {
	// Time O(n), use pre to track the start point of current interval
	public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums==null||nums.length==0) return res;
        int n=nums.length;
        String s="";
        int pre=nums[0];
        for(int i=1;i<n;i++) {
            if(nums[i]!=nums[i-1]+1) {
                if(pre==nums[i-1]) {
                    s=pre+"";
                } else {
                    s = pre+"->"+nums[i-1];
                }
                res.add(s);
                pre=nums[i];
            } 
        }
        s=(pre==nums[n-1])? pre+"" : pre+"->"+nums[n-1];
        res.add(s);
        return res;
    }
}
