//http://www.lintcode.com/en/problem/convert-expression-to-polish-notation/

import java.util.ArrayList;
import java.util.Stack;
import java.util.Collections;

public class Lintcode_Convert_Expression_to_Polish_Notation {
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
		       while(!temp.isEmpty()&&great(temp.peek(),s)) {  //  “9/3/3” -> “339//” -> “//933”, while RPN “9/3/3” -> “93/3/”
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
}
