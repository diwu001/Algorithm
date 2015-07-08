
public class Number_of_Digit_1 {
	public static int countDigitOne(int n) {
        if(n<=0) return 0;
        String temp=Integer.toString(n);
        int len=temp.length(), count=0;
        for(int i=0;i<len;i++) {
            count+=helper(n,i);
        }
        return count;
    }
    
    public static int helper(int n, int i) {  //61513 3
        long power = (int)Math.pow(10,i);  //1000
        long next=power*10; //10000
        long right=n%power; //513
        
        long down=(n-n%next); //60000
        long up=down+next; //70000
        
        int digit=(int)((n/power)%10); //1
        if(digit<1) return (int)(down/10);
        if(digit>1) return (int)(up/10);
        else return (int)(down/10+right+1);
    }
    
    public static void main(String[] args) {
    	System.out.println(countDigitOne(13));  //6
    }
}
