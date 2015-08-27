/*There are a row of n houses, each house can be painted with one of the three colors: red, blue or green. 
 * The cost of painting each house with a certain color is different. 
 * You have to paint all the houses such that no two adjacent houses have the same color.
 * The cost of painting each house with a certain color is represented by a n x 3 cost matrix. 
 * For example, costs[0][0] is the cost of painting house 0 with color red; costs[1][2] is the cost of painting house 1 with color green, 
 * and so on... Find the minimum cost to paint all houses.
 * All costs are positive integers.*/

public class PaintHouse {
	int minCost(int[][] costs) {
        int n = costs.length;
        if(n == 0) return 0;
        // dp[i][j] min cost of painting i houses (0,..,i-1) and the last house(i-1) is painted using j color
        // dp[0][j] = 0
        int[][] dp = new int[n + 1][3];
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if(j != k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + costs[i - 1][j]);
                    }
                }
            }
        }
        return Math.min(dp[n][0],Math.min(dp[n][1], dp[n][2]));
    }
}
