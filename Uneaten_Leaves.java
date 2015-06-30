/*K caterpillars are eating N leaves, e.g. N=10. 
Given int[] a = {2,4,5} as jump numbers, 
these caterpillars can eat leaves of 2,4,5,6,8,10, and leaves 1,3,7,9 are uneaten, 
so the number of uneaten leaves are 4*/

import java.util.*;
public class Uneaten_Leaves {
	public static int count(int total,int n, int[] a) {
		int result=0;
		ArrayList<ArrayList<Integer>> subset = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> path = new ArrayList<Integer>();
		findAllSubsets(subset,path,0,a);
		for(int i=0;i<subset.size();i++) System.out.println(subset.get(i));
				
		for(int i=0;i<subset.size();i++) {
			int temp = lcms(subset.get(i));
			if(temp>0){
				if(subset.get(i).size()%2==0) {		
					result-=total/temp;
				} else {
					result+=total/temp;
				}
			}			
		}
		return total-result;
	}
	
	public static void findAllSubsets(ArrayList<ArrayList<Integer>> subset,ArrayList<Integer> path,int index,int[] a) {
		if(path.size()>0) subset.add(new ArrayList<Integer>(path));
		if(path.size()==a.length) return;
		for(int i=index;i<a.length;i++) {
			path.add(a[i]);
			findAllSubsets(subset,path,i+1,a);
			path.remove(path.size()-1);		
		}
	}
	
	public static int lcms(ArrayList<Integer> path) {		
		if(path.size()==1) return path.get(0);
		long result=path.get(0);
		for(int i=1;i<path.size();i++) {
			long a=path.get(i);			
			result = a*result/gcd(a,result);
		}
		return (result<=100000)? (int)result:-1;
	}
	
	public static long gcd(long a,long b) {
		while(b>0) {
			long r=a%b;
			a=b;
			b=r;
		}
		return a;
	}
	
	public static void main(String[] args) {
		int[] a = {2,4,5};
		System.out.println(count(10,3,a));  //1 3 7 9->4 leaves
	}
}
