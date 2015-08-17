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

    // Solution 1: sort all points. Time O(nlgn) Space O(n), n is the input size
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
    
    // Solution2: Sort the input array by start value. 
    // Then go through the sorted array, find the earliest ending interval in O(1) time by using Priority Queue.
    // If no conflict between current interval and the earliest ending interval, pop the earliest interval out of queue.
    // Track the size of priority queue, the maximum size is the minimal number of rooms needed.
    // Time O(nlgn) Space O(m), n is the input size, m is the max size of priority queue
    int minMeetingRooms2(Interval[] intervals) {
        int n = intervals.length;
        if(n <= 1) return n;
         
        Comparator<Interval> c1 = new Comparator<Interval>() {
            public int compare(Interval i, Interval j) {
                return i.start - j.start;
            }
        };
        Comparator<Interval> c2 = new Comparator<Interval>() {
            public int compare(Interval i, Interval j) {
                return i.end - j.end;
            }
        };
        
        Arrays.sort(intervals, c1);
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(1, c2);
        
        pq.offer(intervals[0]);
        int conflict = 0;
        for(int i = 1; i < n; i++) {
            Interval cur = intervals[i];
            while(!pq.isEmpty()) {
                if(pq.peek().end <= cur.start) pq.poll();
                else break;
            }
            pq.add(cur);
            conflict = Math.max(conflict, pq.size());
        }
        return conflict;
    }
}
