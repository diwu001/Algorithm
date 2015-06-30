//http://www.lintcode.com/en/problem/fast-power/
public class Lintcode_Fast_Power {
	public int fastPower(int a, int b, int n) {  //many corner cases
        if(a==0||b==0) return 0;
        if(a==1) return a%b;
        return (int)helper(a,b,n);
    }
    
     public long helper(int a, int b, int n) {
        if(n==0) return 1%b;
        if(n==1) return a%b;

        boolean neg=false;
        if(n<0) {
            neg=true;
            n=-n;
        }
        
        long val1 = helper(a,b,n/2)%b;
        long val2 = helper(a,b,n-2*(n/2))%b;
        
        return !neg? (((val1*val1)%b)*val2)%b :(1/(((val1*val1)%b)*val2))%b;
    }
}
