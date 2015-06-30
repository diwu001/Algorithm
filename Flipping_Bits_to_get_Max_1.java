/*  Input array a[] only contains 0 or 1. Choose any two index i, and j, 
	and flip all the elements between ith and jth bits. 
	What is the maximum number of 1-bits can be obtained.*/
	
public class flipping_bits_to_get_Max_1 {
	public static int flip(int[] a) {
		int n=a.length,sum=0;
		for(int i=0;i<n;i++) sum+=a[i];
		
		int count=0,maxCount=0;
		
		//find a subarray of the maximum count of (0-bits - 1-bits), 
		//so after flipping, we can get more 1 bits 
		for(int i=0;i<n;i++) {
			if(a[i]==0) count++;
			else count--;
			if(count<0) count=0;
			else maxCount=Math.max(count,maxCount);
		}
		return sum+maxCount;
	}
	
	public static void main(String[] args) {
		int[] a = {0,0,0,1,1,0,1,0,0,0,1,0,1,1};
		int[] a1={1,0,0,1,0,0,1,0};
		System.out.println(flip(a));
		System.out.println(flip(a1));
	}
}
