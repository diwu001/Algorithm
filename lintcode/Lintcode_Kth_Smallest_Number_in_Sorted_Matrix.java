//http://www.lintcode.com/en/problem/kth-smallest-number-in-sorted-matrix/
import java.util.*;
//Memory Limit Exceeded. Heapify k times which takes O(kLogn) time.

public class Lintcode_Kth_Smallest_Number_in_Sorted_Matrix {
	class Point{
        int val,x,y;
        public Point(int val, int x, int y) {
            this.val=val;
            this.x=x;
            this.y=y;
        }
    }
	
    public int kthSmallest(int[][] matrix, int k) {
        if(matrix==null||matrix.length==0) return 0;
        int m=matrix.length, n=matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        Comparator<Point> c =new Comparator<Point>(){
            public int compare(Point a, Point b) {
                return a.val- b.val;
            }
        };
        PriorityQueue<Point> heap = new PriorityQueue<Point>(k,c);// minheap 
        heap.add(new Point(matrix[0][0],0,0)); // 1st smallest in matrix
        visited[0][0] = true;
        while (k > 1) {
            Point p = heap.remove();
            int x = p.x;
            int y = p.y;
            
            // p is current smallest in heap, so go right/down can get next smaller element, add them to heap
            if (x+1 < m && visited[x+1][y] == false) {
                visited[x+1][y] = true;
                heap.add(new Point(matrix[x+1][y],x+1, y));
            }
            if (y+1 < n && visited[x][y+1] == false) {
                visited[x][y+1] = true;
                heap.add(new Point(matrix[x][y+1],x, y+1));
            }
            k--;
        }
        return heap.remove().val;
    }
}
