//http://www.lintcode.com/en/problem/building-outline/
import java.util.*;

public class Lintcode_Building_Outline {
	/**
	 * @param buildings: A list of lists of integers
	 * @return: Find the outline of those buildings
	 */
    class Point {
        int pos;
        boolean isS;
        int[] building;
        public Point(int pos, boolean isS, int[] building) {
            this.pos=pos;
            this.isS=isS;
            this.building=building;
        }
    }
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
    	//buildings [[1,3,3], [2,4,4], [5,6,1]] => temp [[1,2,3],[2,3,4],[3,4,4],[5,6,1]] => result [[1,2,3],[2,4,4],[5,6,1]]
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
        if(buildings==null||buildings.length==0) return result;
        int n=buildings.length;
        Point[] points = new Point[2*n];
        for(int i=0;i<n;i++) {
            points[2*i]=new Point(buildings[i][0],true,buildings[i]);
            points[2*i+1]=new Point(buildings[i][1],false,buildings[i]);
        }
        Comparator<Point> c1 = new Comparator<Point>(){
            public int compare(Point p1,Point p2) {
                return p1.pos-p2.pos;
            }  
        };
        Arrays.sort(points,c1); // sort points in ascending order
        
        Comparator<int[]> c2 = new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return b[2]-a[2];
            }  
        };
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(1,c2);  //max heap of buildings
        int open=1,pre=points[0].pos,i=1;
        pq.offer(points[0].building);
        while(i<2*n) {
            Point cur = points[i++];
            if(open==0) {
                pre=cur.pos;
            }
            if(pre!=cur.pos) {
                ArrayList<Integer> newB=new ArrayList<Integer>();
                newB.add(pre);
                newB.add(cur.pos);
                newB.add(pq.peek()[2]);
                temp.add(newB);
                pre=cur.pos;
            }
            if(cur.isS) {
                open++;
                pq.offer(cur.building);
            } else {
                open--;
                pq.remove(cur.building);
            }
        }
        
        //merge the adjacent outlines if they have the same height 
        if(temp.size()==0) return result;
        ArrayList<Integer> preB = temp.get(0);
        int s=preB.get(0),h=preB.get(2);
        int m=temp.size();
        for(int j=1;j<m;j++) {
            if(temp.get(j).get(2)!=h) {
                ArrayList<Integer> path = new ArrayList<Integer>();
                path.add(s);  //start position
                path.add(temp.get(j-1).get(1));  //end position
                path.add(h);  //height
                result.add(path);
                s=temp.get(j).get(0);
                h=temp.get(j).get(2);
            }
        }
        ArrayList<Integer> path = new ArrayList<Integer>();
        path.add(s);
        path.add(temp.get(m-1).get(1));
        path.add(h);
        result.add(path);
        return result;
    }
}
