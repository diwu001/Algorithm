// http://www.lintcode.com/en/problem/submatrix-sum/
// Given an integer matrix, find a submatrix where the sum of numbers is zero.
// Your code should return the coordinate of the left-up and right-down number.
/* [1 ,5 ,7],
   [3 ,7 ,-8],
   [4 ,-8 ,9],
 * return [(1,1), (2,2)]
 * */

import java.util.HashMap;

public class Lintcode_Submatrix_Sum {
    public int[][] submatrixSum(int[][] matrix) {  //O(n3) time
        int[][] result = new int[2][2];
        if(matrix==null||matrix.length==0) return result;
        int m=matrix.length,n=matrix[0].length;        
        for(int i=0;i<n;i++) {
            int[] sum=new int[m]; // sum[] has m rows
            for(int j=i;j<n;j++) {
            	// sum[k] is the sum of matrix[0][j]~matrix[k][j]
            	// in the next inner for loop, sum[k] accumulate matrix[0][j+1]~matrix[k][j+1]
            	// therefore, sum[k] is the sum of matrix[0][i]~matrix[k][j]
                for(int k=0;k<m;k++) sum[k]+=matrix[k][j];
                
                HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
                map.put(0,-1);
                int lastSum=0;
                for(int v=0;v<m;v++) {  //traverse each row
                    lastSum += sum[v];  //lastSum is the presum of sum[v] at current row v
                    if(map.containsKey(lastSum)) {  
                        result[0][0]=map.get(lastSum)+1; //up row    
                        result[0][1]=i;  // left column               		
                        result[1][0]=v;  // down row				
                        result[1][1]=j;  // right column			 	 	
                        return result;  		
                    }  
                    map.put(lastSum,v);  
                }
            }
        }
        return result;
    }
}
