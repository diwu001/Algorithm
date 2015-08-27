import java.util.Stack;
public class Sort_Stack_3_6 {
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		while (!s.isEmpty()) {
			int tmp= s.pop(); 
			while (!r.isEmpty() && r.peek() > tmp) { 
				s.push(r.pop());
			}
			r.push(tmp); 
		}
		return r;
	}
	
	public static void main(String[] args) {		 
		Stack<Integer> test = new Stack<Integer>();
		test.push(2);
		test.push(1);
		test.push(5);
		Stack<Integer> result = sort(test);
		System.out.println(result.pop());
		System.out.println(result.pop());
		System.out.println(result.pop());
	}
}
