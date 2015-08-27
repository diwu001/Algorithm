import java.util.LinkedList;
/*Implement a max Queue, which can get the maximum element in the queue in O(1) time.
Solution: use LinkedList to mimic a Two way queue. Another solution is use two max stacks to implement a max queue.*/
public class MaxQueue {
	static LinkedList<Integer> data;  // Queue<Integer> doesn't have getLast()
	static LinkedList<Integer> max;
	
	public MaxQueue () {
		data = new LinkedList<Integer>();
		max = new LinkedList<Integer>();
	}
	
	void add(int x) {
		data.add(x);
		
		while(!max.isEmpty() && max.getLast()<x) max.poll(); 
		max.add(x);		
	}
	
	void poll(){
		if(max.isEmpty()) throw new NullPointerException("empty queue");
		if(max.peek()== data.peek()) max.poll();
		data.poll();
	}
	
	int max() {
		if(max.isEmpty()) throw new NullPointerException("empty queue");
		return max.peek();
	}
	
	public static void main(String[] args){
		MaxQueue q = new MaxQueue();
		q.add(5);
		q.add(4);
		q.add(6);
		System.out.println(q.max());
		q.poll();  //5
		System.out.println(q.max());
		q.poll();  //4
		System.out.println(q.max());
	}
}
