/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * find the minimum number of conference rooms required.
 * For example, given [[0, 30],[5, 10],[15, 20]], return 2.*/

import java.util.*;

public class MeetingRoomsII {
	class Interval {
		 int start, end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	
	class Point{
        int val;
        boolean isStart;
        Point(int val, boolean isStart) {
            this.val = val;
            this.isStart = isStart;
        }
    }
    
    int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        if(n <= 1) return n;
        Point[] points = new Point[2 * n];
        for(int i = 0; i < n; i++) {
            points[2 * i] = new Point(intervals[i].start, true);
            points[2 * i + 1] = new Point(intervals[i].end, false);
        }    
        Comparator<Point> c = new Comparator<Point>() {
            public int compare(Point pi, Point pj) {
                if(pi.val == pj.val) {
                    if(pi.isStart && !pj.isStart) return 1;
                    if(!pi.isStart && pj.isStart) return -1;
                    return 0;
                } else return pi.val - pj.val;
            }
        };
        Arrays.sort(points, c);
        int count = 0, conflict = 0;
        for(int i = 0; i < 2 * n; i++) {
            if(points[i].isStart) {
                count++;
            }else {
                count--;
            }
            conflict = Math.max(conflict, count);
        }
        return conflict;
    }
}
