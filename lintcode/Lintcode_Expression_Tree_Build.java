//http://www.lintcode.com/en/problem/expression-tree-build/
import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;
public class Lintcode_Expression_Tree_Build {
    public ArrayList<String> convertToPN(String[] expression) {
        ArrayList<String> result = new  ArrayList<String>();
		if(expression==null||expression.length==0) return result;
		Stack<String> temp = new Stack<String>();
		for(int i=expression.length-1;i>=0;i--) {
		   String s = expression[i];
		   if(s.equals("(")) {
		       while(!temp.isEmpty()&&!temp.peek().equals(")")) {
		           result.add(temp.pop());
		       }
		       if(!temp.isEmpty()) temp.pop();
		   } else if(s.equals(")")) {
		       temp.push(s);
		   }  else if(isOp(s)) {
		       while(!temp.isEmpty()&&great(temp.peek(),s)) {  
		           result.add(temp.pop());
		       }
		       temp.push(s);
		   } else {
		       result.add(s);
		   }
		}
		while(!temp.isEmpty()) result.add(temp.pop());
		Collections.reverse(result);
		return result;
	}
		
	public boolean isOp(String s) {
		if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) return true;
		return false;
	}
		
	public boolean great(String pre, String cur){
		if (pre.equals("*") || pre.equals("/")) {  
			if(cur.equals("+") || cur.equals("-"))  return true;  
		}  
		return false; 
	}
		/* (2*6-(23+7)/(1+2)) -> - *26 / +237 +12
					    [ - ]
					/          \
			[ * ]                [ / ]
			/     \           /         \
		[ 2 ]  [ 6 ]      [ + ]        [ + ]
				         /    \       /      \
				      [ 23 ][ 7 ] [ 1 ]   [ 2 ]*/
	private int index;
	public ExpressionTreeNode helper(ArrayList<String> ss) {
	    if(index==ss.size()) return null;
	    ExpressionTreeNode root = new ExpressionTreeNode(ss.get(index));
	    index++;
	    if(isOp(ss.get(index-1))) {  //if cur index is op(root), it will have left and right subtree 
	        root.left=helper(ss);
	        root.right=helper(ss);
	    }
	    return root;
	}
	
    public ExpressionTreeNode build(String[] expression) {
        ArrayList<String> temp=convertToPN(expression);
        index=0;
        return helper(temp);
    }
}
