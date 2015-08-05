import java.util.Stack;
public class Basic_Calculator {
    // Time O(n)
    public int calculate(String s) {
        if(s==null||s.length()==0) return 0;
        int sum=0,last=1,bracket=1;
        Stack<Integer> stack=new Stack<Integer>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==' ') continue;
            if(Character.isDigit(s.charAt(i))) {
                int num=s.charAt(i)-'0';
                while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))) {
                    num=num*10+(s.charAt(i+1)-'0');
                    i++;
                }
                sum+=num*last*bracket;
            } else if(s.charAt(i)=='+'||s.charAt(i)=='-') {
                last= (s.charAt(i)=='-')?-1:1;
            } else if(s.charAt(i)=='(') {   
                stack.push(last);  //last is the op outside of (
                bracket=bracket*last;  //bracket is accumulative inside current bracket
                last=1;  //inside bracket, last starts from 1
                // 5-(4-(3+2)-6) 
                //last=-1 push(-1) bracket=-1 last=1  -> -4
                //last=-1 push(-1) bracket=(-1)*(-1)=1 last=1 -> 3
                //last=1 bracket=1 -> 2
            } else if(s.charAt(i)==')') {
                bracket/=stack.pop();  //restore
                //bracket=1/(-1)=-1;
                //then f=-1 -> 6                
            }
        }
        return sum;
    } 
}
