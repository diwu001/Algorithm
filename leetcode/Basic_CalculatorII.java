import java.util.Stack;
public class Basic_CalculatorII {
    // Time O(n), Space O(1)
    public int calculate(String s) {
        if(s==null||s.length()==0) return 0;
        int n=s.length();
        int sum=0,m=1,num=0;
        boolean isDivide=false;
        for(int i=0;i<n;i++) {
            char c = s.charAt(i);
            if(c==' ') continue; 
            else if(Character.isDigit(c)) {
                num=c-'0';
                while(i+1<n&&Character.isDigit(s.charAt(i+1))) {
                    num=num*10+(s.charAt(i+1)-'0');
                    i++;
                }
                if(!isDivide) m=m*num;
                else m=m/num;
            } else {
                isDivide=false;
                if(c=='+') {
                    sum+=m;
                    m=1;
                } else if(c=='-') {
                    sum+=m;
                    m=-1;
                } else if(c=='/')  {
                    isDivide=true;
                } 
            }
        }
        sum+=m;
        return sum;
    }
}
