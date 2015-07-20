/*Compute the GCD of two numbers without using * / % 
a=3,b=6 (3,3) (3,0) b==0 return a=3
a=3,b=5 (3,2) (3,1) (2,1) (1,1) (1,0) b==0 return a=1*/
public class GCDusingBitOperation_5_10 {
	public static int GCDBit(int a, int b){
		if(a==0) return b;  
		if(b==0) return a;  
		if( ((a&1)==0) && ((b&1)==0) ) return GCDBit(a>>1,b>>1)<<1;  
		if( ((a&1)==1) && ((b&1)==0) ) return GCDBit(a,b>>1);
		if( ((a&1)==0) && ((b&1)==1) ) return GCDBit(a>>1,b);
		else {
			if(a>b) return GCDBit(a-b,b);
			else return GCDBit(a,b-a);
		}
	}
}
