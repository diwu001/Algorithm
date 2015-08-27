// There are many wood with different length. Each time we can connect 2 woods to a wood with the cost of the total length of these 2 woods.
// Find the minimum total cost to connect all woods in the array
// e.g. [3，4，6，9] first 3+4->7 cost 7; then 6+7->13, cost 13; finally 13+9->22. So the total minimum connect cost is 7+13+22=42

import java.util.*;
public class Min_Cost_Connect_Wood {
	public static int f(int[] a) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int sum=0;		
		for(int i=0;i<a.length;i++) {
			pq.offer(a[i]);
		}
		while(pq.size()>=2) {
			int w1=pq.poll();
			int w2 = pq.poll();
			sum+=w1+w2;
			pq.offer(w1+w2);
		}
		System.out.println(sum);
		return sum;
	}
}
