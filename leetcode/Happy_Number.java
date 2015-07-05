import java.util.HashSet;

public class Happy_Number {
	public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<Integer>();
        int temp=0;
        while(temp!=1) {
            temp=0;
            while(n>0) {
                temp+=(n%10)*(n%10);
                n=n/10;
            }
            n=temp;
            if(!set.add(temp)) return false;
        }
        return true;
    }
	
//--------------------------------------------------------	
	
	public boolean isHappy2(int n) {
	        int slow=n,fast=n;
	        while(fast!=1) {
	            fast=helper(fast);
	            if(fast==1) return true;
	            fast=helper(fast);
	            slow=helper(slow);
	            if(fast==slow) return false;
	        }
	        return true;
	    }
	    
	    public int helper(int n) {
	        int temp=0;
	        while(n>0) {
	            temp+=(n%10)*(n%10);
	            n=n/10;
	        }
	        return temp;
	    }
}
