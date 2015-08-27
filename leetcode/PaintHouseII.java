
public class PaintHouseII {
	int minCostII(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        int k = costs[0].length;
        if(n == 1 && k == 1) return costs[0][0];
        int[][] dp = new int[n + 1][k];
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < k; j++) {
                for(int l = 0; l < k; l++) {
                    if(j != l) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + costs[i - 1][j]);
                    }
                }
                if(i ==n) min = Math.min(min, dp[n][j]); 
            }
        }
        return min;
    }
}
