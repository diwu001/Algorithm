
public class DoubleSqrt {
	static int compare(double a, double b) {
		double diff=(a-b)/b;
		if(diff<-1e-12) return -1;
		if(diff>1e-12) return 1;
		return 0;
	}
	
	static double sqrt(double x) {
		double l,r;
		if(compare(x,1.0)<0) {
			l=x; r=1.0;
		} else {  //x>=1.0
			l=1.0; r=x;
		}
		int count=0;
		while(compare(l,r)<1) {
			double m=l+0.5*(r-l);
			double square=m*m;
			count++;
			System.out.println(count+" "+l+" "+m);
			if(compare(square,x)==0) {System.out.println("reached mid"); return m;}
			else if(compare(square,x)==1) r=m;
			else l=m;
		}	
		System.out.println("reached end");
		return l;
	}
	
	public static void main(String[] args) {
		System.out.println(sqrt(0.0001));
	}
}
