//http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence/
import java.util.Arrays;
public class Lintcode_Longest_Increasing_Continuous_subsequence {
    public int longestIncreasingContinuousSubsequence(int[] A) { //Space O(n)
        if(A==null ||A.length==0 ) return 0;
        int n=A.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max=1;
        for(int i=1;i<n;i++) {
            if(A[i]>A[i-1]) dp[i]=dp[i-1]+1;
            max=Math.max(max,dp[i]);
        }
        Arrays.fill(dp,1);
         for(int i=n-2;i>=0;i--) {
            if(A[i]>A[i+1]) dp[i]=dp[i+1]+1;
            max=Math.max(max,dp[i]);
        }
        return max;
    }
    
//-------------------------------------------------------------------
    
    public int longestIncreasingContinuousSubsequence2(int[] A) {  //Space O(1)
        if(A==null ||A.length==0 ) return 0;
        int n=A.length;
        int pre=1, cur=1;
        int max=1;
        for(int i=1;i<n;i++) {
            if(A[i]>A[i-1]) {
                pre = cur;
                cur=pre+1;
            } else {
                cur=1;
            } 
            max=Math.max(max,cur);
        }
        
        cur=1;
        for(int i=n-2;i>=0;i--){
            if(A[i]>A[i+1]) {
                pre = cur;
                cur=pre+1;
            } else {
                cur=1;
            }
            max=Math.max(max,cur);
        }        
        return max;
    }
}
