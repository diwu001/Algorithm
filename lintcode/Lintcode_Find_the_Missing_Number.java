
public class Lintcode_Find_the_Missing_Number {
    public int findMissing(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int n=nums.length;
        boolean flag=false;
        int mark=-1;
        for(int i=0;i<n;i++) {
            if(Math.abs(nums[i])==n) flag=true;
            else {
                if(Math.abs(nums[i])==0) mark=i;
                if(nums[Math.abs(nums[i])]>0) nums[Math.abs(nums[i])]=-nums[Math.abs(nums[i])];
            }
        }
        
        int i=0;
        for(;i<n;i++) {
            if(nums[i]>0) break;
        }
        return (!flag)? n : ((i==n)?mark:i);
    }
//-----------------------------------------------------------------	
	public int findMissing2(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int n=nums.length, xor=0;
        for(int i=0;i<n;i++) {
            xor^=nums[i];
        }
        for(int i=0;i<=n;i++) {
            xor^=i;
        }
        return xor;
	}
}
