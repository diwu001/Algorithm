/*Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), 
 * determine if a person could attend all meetings.
* For example, given [[0, 30],[5, 10],[15, 20]], return false.*/

import java.util.*;

public class MeetingRooms {	
	class Interval {
		 int start, end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	
	boolean canAttendMeetings(Interval[] intervals) {
        int n = intervals.length;
        if(n <= 1) return true;
        Comparator<Interval> c = new Comparator<Interval>() {
            public int compare(Interval i, Interval j) {
                return i.start - j.start;
            }
        };
        Arrays.sort(intervals, c);
        Interval pre = intervals[0];
        for(int i = 1; i < n; i++) {
            if(intervals[i].start < pre.end) return false;
            else pre = intervals[i];
        }
        return true;
    }
}
