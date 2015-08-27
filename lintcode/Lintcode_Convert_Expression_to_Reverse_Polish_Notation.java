//http://www.lintcode.com/en/problem/convert-expression-to-reverse-polish-notation/

import java.util.ArrayList;
import java.util.Stack;

public class Lintcode_Convert_Expression_to_Reverse_Polish_Notation {
    public ArrayList<String> convertToRPN(String[] expression) {
       ArrayList<String> result = new  ArrayList<String>();
       if(expression==null||expression.length==0) return result;
       Stack<String> temp = new Stack<String>();
       for(int i=0;i<expression.length;i++) {
           String s = expression[i];
           if(s.equals("(")) {
               temp.push(s);
           } else if(s.equals(")")) {
               while(!temp.isEmpty()&&!temp.peek().equals("(")) {
                   result.add(temp.pop());
               }
               if(!temp.isEmpty()) temp.pop();
           }  else if(isOp(s)) {
               while(!temp.isEmpty()&&!temp.peek().equals("(")) {
                   if(greatOrEqual(temp.peek(),s)) {
                       result.add(temp.pop());
                   } else break;
               }
               temp.push(s);
           } else {
               result.add(s);
           }
       }
       while(!temp.isEmpty()) result.add(temp.pop());
       return result;
   }
   
   public boolean isOp(String s) {
       if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")) return true;
       return false;
   }
   
   public boolean greatOrEqual(String pre, String cur){
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
