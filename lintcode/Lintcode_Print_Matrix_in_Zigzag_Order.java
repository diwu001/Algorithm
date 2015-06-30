//http://www.lintcode.com/en/problem/matrix-zigzag-traversal/
public class Lintcode_Print_Matrix_in_Zigzag_Order {
    public int[] printZMatrix(int[][] matrix) {  // Time:  O((m + n)^2)  Space: O(1)
        if(matrix==null||matrix.length==0) return new int[1];
        int m=matrix.length,n=matrix[0].length;
        int[] result = new int[m*n];
        int index=0;
        boolean flag=false;
        for(int k=0;k<=m+n-2;k++) {
            if(!flag) {
                for(int j=0;j<n;j++) {
                    if(j<=k&&k-j<m)  // k-m<j<=k  e.g. 1<j<=4 11->8 j=2,3
                        result[index++]=matrix[k-j][j];
                }
            } else {
                for(int i=0;i<m;i++) {
                    if(i<=k&&k-i<n)
                        result[index++]=matrix[i][k-i];
                }
            }
            flag=!flag;
        } 
        return result;
    }
}
