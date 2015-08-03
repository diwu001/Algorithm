//http://www.lintcode.com/en/problem/number-of-islands-ii/
/*
Given a n,m which means the row and column of the 2D matrix and an array of pair A( size k). 
Originally, the 2D matrix is all 0 which means there is only sea in the matrix. 
The list pair has k operator and each operator has two integer A[i].x, A[i].y 
means that you can change the grid matrix[A[i].x][A[i].y] from sea to island. 
Return how many island are there in the matrix after each operator.
Given n = 3, m = 3, array of pair A = [(0,0),(0,1),(2,2),(2,1)]. return [1,1,2,2].
Note: 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, 
we consider them in the same island. We only consider up/down/left/right adjacent.
 */
 
import java.util.*;
public class Number_of_IslandsII {  //Time Complexity: O(nlgn) n is the number of points in operators
    static class Point {
    	int x;
    	int y;
    	Point(int a, int b) { x = a; y = b; }
    }
    
    static class DJSetNode {
        int rank;
        DJSetNode parent;
        public DJSetNode(int r) {
            rank=r;
        }
    }
    
    static Set<DJSetNode> forest = new HashSet<DJSetNode>();
    
    // Create a new set and add it to forest
    static DJSetNode makeSet() {
        DJSetNode cur = new DJSetNode(0);    
        forest.add(cur);
        return cur;
    }
    
    // Find the root of current node
    static DJSetNode find(DJSetNode n) {
        if (n == null) return n;
        while (n.parent!=null) {
            n = n.parent;
        }
        return n;
    }
    
    // Given two nodes in two sets, merge these two sets to a single set, return its root
    static DJSetNode merge(DJSetNode n1, DJSetNode n2) {
        DJSetNode r1 = find(n1);   
        DJSetNode r2 = find(n2);
        if (r1 == r2) return r1;

        if (r1.rank > r2.rank) {  
            r2.parent = r1;        
            forest.remove(r2);       
            return r1;              
        }
        else if (r1.rank < r2.rank) { 
            r1.parent = r2;
            forest.remove(r1);
            return r2;
        }
        else {                      
            r2.parent = r1;        
            forest.remove(r2);
            r1.rank=r1.rank+1;             
            return r1;
        }
    }
    
    static int add(Point p,DJSetNode[][] seaMap ,int n, int m) {
        List<DJSetNode> nbs = new ArrayList<DJSetNode>();     
        
        if (p.x > 0 && seaMap[p.x-1][p.y]!=null) nbs.add(seaMap[p.x-1][p.y]);
        if (p.y > 0 && seaMap[p.x][p.y-1]!=null) nbs.add(seaMap[p.x][p.y-1]);
        if (p.x < n-1 && seaMap[p.x+1][p.y]!=null) nbs.add(seaMap[p.x+1][p.y]);
        if (p.y < m-1 && seaMap[p.x][p.y+1]!=null) nbs.add(seaMap[p.x][p.y+1]);

        DJSetNode cur = makeSet(); 
        seaMap[p.x][p.y] = cur;     
        
        for (int i = 0; i < nbs.size();++i) {
            cur = merge(cur, nbs.get(i));   
        }
        return forest.size();       
    }
    
    public static List<Integer> numIslands2(int n, int m, Point[] operators) {
        List<Integer> result = new ArrayList<Integer>();
        if(operators==null||operators.length==0) return result;
        DJSetNode[][] seaMap = new DJSetNode[n][m];  // Store the DJSetNode at specific position
        for(int i = 0; i < operators.length; ++i) {
            int a = add(operators[i],seaMap,n,m);
            result.add(a);
        }
        return result;
    }
}
