
public class Search_2D_MatrixII {
    // Brute force: search each row using binary search. Time Complexity O(mlgn), 
    // m is the number of rows in the matrix, n is the number of columns

    // Time Complexity O (m+n)
    public int searchMatrix0(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return 0;
        int m=matrix.length,n=matrix[0].length;
        int row = 0 ,col=n-1;
        int count=0;
        while(row>=0&&col>=0&&row<m&&col<n) {
            if(matrix[row][col]==target) {
                count++;
                row++;
                col--;
                
            } else if(matrix[row][col]<target){
                row++;
            } else col--;
        }
        return count;
    }
	
    //-----------------------------------------------------------------------------------------
    
    // At each search, remove 1/4 of the current search range. Time complexity T(n)=3*T(n/2)+c
    public boolean searchMatrix1(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return false;
        int m=matrix.length, n=matrix[0].length;
        return helper(matrix, target, 0, 0, n-1, m-1);
    }
    
    public boolean helper1(int[][] matrix, int target, int left, int up, int right, int down) {
        if(left>right || up>down) return false;
        if(target<matrix[up][left] || target>matrix[down][right]) return false;
        int col = left + (right-left)/2, row = up+(down-up)/2;
        if(matrix[row][col]==target) return true;
        if(left==right && up==down) return false;
        if(matrix[row][col]>target) {
            return helper1(matrix,target,left,up,col,row) 
            || helper1(matrix,target,col+1,up,right,row) 
            || helper1(matrix,target,left,row+1,col,down);
        } else {
            return helper1(matrix,target,col+1,row+1,right,down) 
            || helper1(matrix,target,col+1,up,right,row) 
            || helper1(matrix,target,left,row+1,col,down);
        }
    }
		
    //------------------------------------------------------------------------------------------------	
	
    //  At each search, remove 1/4 of the current search range. Time Complexity T(n)=2*T(n/2)+c*n = nlgn
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0) return false;
        int m=matrix.length, n=matrix[0].length;
        return helper(matrix, target, 0, 0, n-1, m-1);
    }
    
    public boolean helper2(int[][] matrix, int target, int left, int up, int right, int down) {
        if(left>right || up>down) return false;
        if(target<matrix[up][left] || target>matrix[down][right]) return false;
        int mid = left +(right-left)/2, row=up;
        while(row<=down && matrix[row][mid]<=target) {
            if(matrix[row][mid]==target) return true;
            row++;
        }
        return helper2(matrix,target,left,row,mid-1,down) 
            || helper2(matrix,target,mid+1,up,right,row-1);
    }
}

