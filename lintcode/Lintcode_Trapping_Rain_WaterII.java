//http://www.lintcode.com/en/problem/trapping-rain-water-ii/
import java.util.*;
public class Lintcode_Trapping_Rain_WaterII {
	class Cell{
        int x,y,height;
        public Cell(int x, int y, int height) {
            this.x=x;
            this.y=y;
            this.height=height;
        }
    }
	// Time:  O(m * n * log(m *n))  Space: O(m * n)
    public int trapRainWater(int[][] heights) {
        if(heights==null||heights.length<=2) return 0;
        int m=heights.length, n=heights[0].length;
        Comparator<Cell> comp = new Comparator<Cell>(){
            public int compare(Cell i, Cell j) {
                return i.height-j.height;
            }
        };
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(m,comp); //min heap
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0;i<m;i++) {
            pq.offer(new Cell(i,0,heights[i][0]));
            visited[i][0]=true;
            pq.offer(new Cell(i,n-1,heights[i][n-1]));
            visited[i][n-1]=true;
        }
        for(int i=0;i<n;i++) {
            pq.offer(new Cell(0,i,heights[0][i]));
            visited[0][i]=true;
            pq.offer(new Cell(m-1,i,heights[m-1][i]));
            visited[m-1][i]=true;
        }
        
        int sum=0;
        while(!pq.isEmpty()) {
            Cell c = pq.poll();
            sum+=(fill(c.x+1,c.y,c.height,heights,visited,pq)+
                fill(c.x-1,c.y,c.height,heights,visited,pq)+
                fill(c.x,c.y+1,c.height,heights,visited,pq)+
                fill(c.x,c.y-1,c.height,heights,visited,pq));
        }
        return sum;
    }
    
    public int fill(int x, int y, int h,int[][] heights, boolean[][] visited,PriorityQueue<Cell> pq) {
        int m=heights.length, n=heights[0].length;
        if(x<0||x>=m||y<0||y>=n) return 0;
        if(!visited[x][y]) {
            visited[x][y]=true;
            int val = Math.max(heights[x][y],h);
            pq.offer(new Cell(x,y,val));  //update the val at [x,y]
            return h>heights[x][y]? h-heights[x][y]:0;  //the amount of water to store at heights[x][y]
        }
        return 0;
    }
}
