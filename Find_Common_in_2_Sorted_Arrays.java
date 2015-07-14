
import java.util.*;
public class Find_Common_in_2_Sorted_Arrays {
	public static List<Integer> common(int[] a, int[] b) {  //Two pointer, Time O(n), Space O(1)
		List<Integer> result = new ArrayList<Integer>();
		if(a==null) throw new NullPointerException("input is null");
		int i=0,j=0;
		while(i<a.length && j<b.length) {
			if(a[i]==b[j]) {
				result.add(a[i]);
				i++;
				j++;
			} else if(a[i]<b[j]) i++;
			else j++;
		}
		return result;
	}
	
	public static List<Integer> common2(int[] a, int[] b) { //HashSet, Time O(n), Space O(n)
		List<Integer> result = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<a.length;i++) set.add(a[i]);
		for(int j=0;j<b.length;j++) {
			if(set.contains(b[j])) result.add(b[j]);
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {1,2,2,3,4,5,8};
		int[] b = {2,3,4,6,8,9};
		List<Integer> result = common(a,b); //[2,3,4,8]
		for(int i:result) System.out.print(i+" ");
		System.out.println();
		List<Integer> result2 = common2(a,b); //[2,3,4,8]
		for(int i:result2) System.out.print(i+" ");
	}
}
