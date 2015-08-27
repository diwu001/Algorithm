import java.util.*;
public class Contains_DuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {  //TLE
        if(nums==null||nums.length<2) return false;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++) {
            for(Integer j:map.keySet()) {
            	if(i-map.get(j)<=k&&Math.abs(nums[i]-j)<=t) return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
//----------------------------------------------------------------------------------------	
	public static boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if ( nums == null || nums.length < 2 || k==0 )
            return false;
        TreeMap<Long,Integer> tree = new TreeMap<Long,Integer>();
         
        for ( int i=0; i<=k && i< nums.length; i++){
           if (check(tree, nums, i, t))
                return true;
        }
     
        for (int i=k+1; i<nums.length; i++){
            tree.remove((long)nums[i-1-k]);
            if (check(tree, nums, i, t))
                return true;
        }
        return false;
    }
 
    private static boolean check(TreeMap<Long,Integer> tree, int[] nums, int i, int t){
        long v = (long) nums[i];
        Long ceil = tree.ceilingKey(v);
        if ( ceil != null  && (ceil - v) <= t )
            return true;
        Long low = tree.lowerKey(v);
        if ( low != null  && (v-low) <= t )
            return true;
        tree.put(v,i);
        return false;
    }
    
    public static void main(String[] args) {
    	int[] a = {4,2};
    	System.out.println(containsNearbyAlmostDuplicate2(a,2,1));
    }
}
