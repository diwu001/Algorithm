//http://www.lintcode.com/en/problem/find-peak-element-ii/
import java.util.List;
import java.util.ArrayList;
public class Lintcode_Find_Peak_ElementII {
	public List<Integer> findPeakII(int[][] A) {  // Time Complexity O(n*lgm)
        int low = 1, high = A.length-2;
        List<Integer> ans = new ArrayList<Integer>();
        while(low <= high) {
            int mid = (low + high) / 2;
            int col = find(mid, A);  // find the column index that is the local peak in horizontal row
            if(A[mid][col] < A[mid - 1][col]) {
                high = mid - 1;
            } else if(A[mid][col] < A[mid + 1][col]) {
                low = mid + 1;
            } else {
                ans.add(mid);  //find the row index (mid) that is the local peak in vertical column
                ans.add(col);
                break;
            }
        }
        return ans;
    }
    int find(int row, int [][]A) {  //find the index of the first local peak in row mid
        int i = 1;
        for(; i < A[row].length-1; i++) {
            if(A[row][i] > A[row][i-1] && A[row][i] > A[row][i+1] ) {
                break;
            }
        }
        return i;
    }
    
//-------------------------------------------------------------------------   
	 /* Time Complexity O(n+m)
	  * Check whether each position is peak in 4 directions or not, if yes, return the position
	  * if not, go either down or right to check the next position, in worst case, we go to A[m-1][n-1]
	  */
    public List<Integer> findPeakII2(int[][] A) {
        List<Integer> res = new ArrayList<Integer>();
        if (A == null || A.length == 0 || A[0].length == 0) {
            return res;
        }
        int i = 1, j = 1;
        while (true) {
            if (isValid(A, i, j)) {
                res.add(i);
                res.add(j);
                return res;
            }
            if (A[i+1][j] > A[i][j+1]) {
                i++;
            } else {
                j++;
            }
        }
    }
    
    private boolean isValid(int[][] a, int i, int j) {
        if (i > 0 && i < a.length - 1 && j > 0 && j < a[0].length - 1 
            && a[i-1][j] < a[i][j] && a[i+1][j] < a[i][j] && a[i][j+1] < a[i][j] && a[i][j+1] < a[i][j]) {
            return true;
        }
        return false;
    }
}
