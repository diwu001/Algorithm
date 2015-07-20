/*Find and maintain the median value as new values are generated
 if totally even numbers, median=(mid1+mid2)/2; if odd, median=middle
 keep maxHeap size == minHeap size + 0/1*/
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Collections;
public class MedianMaxMinHeap_18_9 {
	static Comparator<Integer> c = Collections.reverseOrder(null);  
	static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1,c);
	static void insert(int num) {
		if(minHeap.size()==maxHeap.size()) {
			if(minHeap.peek()!=null && num>minHeap.peek()) {
				maxHeap.offer(minHeap.poll());
				minHeap.offer(num);
			} else maxHeap.offer(num);
		} else {
			if(num<maxHeap.peek()) {
				minHeap.offer(maxHeap.poll());
				maxHeap.offer(num);
			} else minHeap.offer(num);
		}
	}
	
	static double getMedian() {
		if(maxHeap.size()==0) return 0;
		if(minHeap.size()==maxHeap.size()) {
			return (maxHeap.peek()+minHeap.peek())*0.5;
		} else {
			return maxHeap.peek();
		}
	}
	
	public static void main(String[] args) {
		insert(1);
		insert(3);
		System.out.println(getMedian());
		insert(5);
		System.out.println(getMedian());
		insert(4);
		insert(6);
		insert(9);
		System.out.println(getMedian());
	}
}
