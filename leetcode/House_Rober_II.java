
public class House_Rober_II {
	public int rob(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        int n=nums.length; 
		
        int[] sum = new int[n];		
        sum[0]=nums[0];
        sum[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<=n-2;i++) sum[i]=Math.max(sum[i-2]+nums[i],sum[i-1]);
        int sum1=sum[n-2];
		
        sum = new int[n];
        sum[1]=nums[1];
        for(int i=2;i<n;i++) sum[i]=Math.max(sum[i-2]+nums[i],sum[i-1]);
        int sum2=sum[n-1];

       return Math.max(sum1,sum2);
    }
}
