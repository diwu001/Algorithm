//http://www.lintcode.com/en/problem/longest-increasing-continuous-subsequence-ii/
import java.util.Comparator;
import java.util.PriorityQueue;
public class Lintcode_Longest_Increasing_Continuous_SubsequenceII {
	//O(nm) time and space
    class Pair{
        int i,j,val;
        public Pair(int i, int j, int val){
            this.i=i;
            this.j=j;
            this.val=val;
        }
    }
    
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        if(A==null||A.length==0) return 0;
        int m = A.length,n=A[0].length;
        int[][] dp=new int[m][n];
        Comparator<Pair> c=new Comparator<Pair>(){
            public int compare(Pair p1, Pair p2) {
                return p1.val-p2.val;
            }  
        };
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(1,c);  //min heap
        
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                pq.offer(new Pair(i,j,A[i][j]));  
                dp[i][j]=1;
            }
        }
        
        int max=1;
        while(!pq.isEmpty()) {
            Pair p = pq.poll();  //smallest in heap
            int i=p.i,j=p.j;
            if(isValid(i,j,i+1,j,A)) { // A[i+1,j] > A[i,j]
                dp[i+1][j]=Math.max(dp[i+1][j],dp[i][j]+1);
            }
            if(isValid(i,j,i-1,j,A)) {
                dp[i-1][j]=Math.max(dp[i-1][j],dp[i][j]+1);
            }
            if(isValid(i,j,i,j+1,A)) {
                dp[i][j+1]=Math.max(dp[i][j+1],dp[i][j]+1);
            }
            if(isValid(i,j,i,j-1,A)) {
                dp[i][j-1]=Math.max(dp[i][j-1],dp[i][j]+1);
            }
            max=Math.max(dp[i][j],max);  
            // because A[i,j] is the current smallest element in the min heap, dp[i][j] won't be updated in the future, so it can be used to calculate max
        }
        return max;
    }
    
    public boolean isValid(int i, int j, int x, int y, int[][] A) {
        int m = A.length,n=A[0].length;
        if(x<0||x>=m||y<0||y>=n) return false;
        if(A[x][y]>A[i][j]) return true;
        return false;
    }
}
