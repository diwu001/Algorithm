import java.util.*;
public class Leetcode_Implement_stack_using_Queues {
	//Time: push O(1), pop and peek O(n)
	static class MyStack{
	    Queue<Integer> q1=new LinkedList<Integer>();
	    Queue<Integer> q2=new LinkedList<Integer>();
	    public void push(int x) {
	        q1.offer(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        while(!q1.isEmpty()) {
	            int x=q1.poll();
	            if(q1.size()>0) q2.offer(x);
	        }
	        q1.poll();
	        Queue<Integer> temp = q1;
	        q1=q2;
	        q2=temp;
	    }

	    // Get the top element.
	    public int top() {
	        int x=0;
	        while(!q1.isEmpty()) {
	            x=q1.poll();
	            if(q1.size()>=0) q2.offer(x);
	        }
	        Queue<Integer> temp = q1;
	        q1=q2;
	        q2=temp;
	        return x;
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	        return q1.isEmpty();
	    }
	    
		//Time: push O(n), pop and peek O(1)
	    /* Queue<Integer> q1=new LinkedList<Integer>();
		   Queue<Integer> q2=new LinkedList<Integer>();
		   public void push(int x) {
		        q2.offer(x);
		        while(!q1.isEmpty()) {
		            q2.offer(q1.poll());
		        }
		        
		        Queue<Integer> temp = q1;
		        q1=q2;
		        q2=temp;
		    }
		
		    // Removes the element on top of the stack.
		    public void pop() {
		        if(q1.size()>0) {
		           q1.poll();
		        }
		    }
		
		    // Get the top element.
		    public int top() {
		        int x=-1;
		        if(q1.size()>0) {
		           x=q1.peek();
		        }
		        return x;
		    }
		
		    // Return whether the stack is empty.
		    public boolean empty() {
		        return q1.isEmpty();
    }*/	    
	}
}
