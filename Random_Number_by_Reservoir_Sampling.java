// Reservoir sampling: randomly choose k numbers in an integer stream of n numbers, 1<=k<=n

import java.util.*;
public class Random_Number_by_Reservoir_Sampling {
	public static int[] randSelectK(int[] stream, int k){//Time Complexity: O(n)
		int[] result = new int[k];
		int n=stream.length;
		for(int i=0;i<k;i++) { 
			result[i]=stream[i];
		} 
		for(int i=k;i<n;i++) {
			Random r = new Random();
			int j=r.nextInt(i+1);
			if(j<k) result[j]=stream[i];
		}
		for(int num:result) System.out.print(num+" ");
		return result;
	}
	
	public static void main(String[] args) {
		int[] stream = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
		int k=5;
		randSelectK(stream,k);
	}	
}
