//http://www.lintcode.com/en/problem/expression-evaluation/
import java.util.Stack;
public class Lintcode_Expression_Evaluation {
	/* Use intStack to store numbers, use opStack to store + - * / ( ).
	 * cur is number, push to intStack
	 * cur is "(", push to opStack
	 * cur is ")", pop out of opStack until meet "(", and pop "("
	 * cur if + - * /, compare precedence, 
	 * 		if cur<=opStack.peek(), e.g. 1*2+3: *push, for +, pre -> true, needs to calculate all greater op in op stack (1*2)
	 * 							   e.g. 1+2+3: +push, for next +, calculate 1+2 then push the next +
	 *      else cur>Stack.peek(), e.g. 1+2*3: +push, for *, pre->False, * also push to op
	 */
    public int evaluateExpression(String[] expression) {
        Stack<Integer> intStack = new Stack<Integer>();  
        Stack<String> opStack = new Stack<String>();  
          
        int cur = 0;  
        while (cur < expression.length) {  
            String curStr = expression[cur];  
            if (isOp(curStr)) {  
                if (curStr.equals("(")) {  
                    opStack.push(curStr);  
                } else if (curStr.equals(")")) {  
                    while (!opStack.peek().equals("(")) {  
                        intStack.push(calc(intStack.pop(), intStack.pop(), opStack.pop()));  
                    }  
                    opStack.pop();  
                } else {  
                    while (!opStack.isEmpty() && precedence(curStr, opStack.peek())) { 
                        intStack.push(calc(intStack.pop(), intStack.pop(), opStack.pop()));  
                    }  
                    opStack.push(curStr);  
                }  
            } else {  
                intStack.push(Integer.valueOf(curStr));  
            }  
            cur++;  
        }  
          
        while (!opStack.isEmpty()) {  
            intStack.push(calc(intStack.pop(), intStack.pop(), opStack.pop())); 
        }  
        return intStack.isEmpty() ? 0 : intStack.pop();  
    }  
  
    int calc(int a, int b, String op) {  
        if (op.equals("+")) {  
            return a + b;  
        } else if (op.equals("-")) {  
            return b - a;  
        } else if (op.equals("*")) {  
            return a * b;  
        } else {  
            return b/a;  
        }  
    }  
      
    boolean isOp(String str) {  
        if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")  
            || str.equals("(") || str.equals(")")) {  
            return true;  
        } else {  
            return false;  
        }  
    }  
  
    // if pre op takes precedence over cur op, return true.
    // for cur, pre:　*　＋ -> F,    + * -> T,    * * -> T, 　    + + -> T
    boolean precedence(String cur, String pre) {  
        if (pre.equals("*") || pre.equals("/")) {  
            return true;  
        }  
        if (pre.equals("+") || pre.equals("-")) {  
            if(cur.equals("*") || cur.equals("/")) {  
                return false;  
            } else {  
                return true;  
            }  
        }  
        return false;  
    }
}
