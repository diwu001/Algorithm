
public class House_Rober {	
	public static int rob(int[] num) {  //Time O(n) Space O(n)
        if(num==null||num.length==0) return 0;
        int n=num.length;
        int[] dp =new int[n];
        dp[0]=num[0];
        if(n==1) return dp[0];
        dp[1] = Math.max(num[0],num[1]);
        for(int i=2;i<n;i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2]+num[i]);
        }
        return dp[n-1];
    }
	
    public int rob2(int[] num) {  //Time O(n) Space O(1)
        if(num==null||num.length==0) return 0;
        int n=num.length;
        int r0=num[0];
        if(n==1) return r0;
        int r1 = Math.max(num[0],num[1]);
        int r2=0;
        for(int i=2;i<n;i++) {
            r2 = Math.max(r1,r0+num[i]);
            r0=r1;
            r1=r2;
            r2=0;
        }
        return r1;
    }
}
