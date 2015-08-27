import java.util.*;
public class MaxLenofLoop {
	static int maxLoop = 0;
	static void dfs(int[] a, int i, int len, HashSet<Integer> visited,int[] l) {
		if(visited.contains(i)) {
			maxLoop = Math.max(maxLoop,len-l[i]);
			return;
		}
		visited.add(i);
		l[i]=len;
		dfs(a,a[i],len+1,visited,l);
	}
	
	public static void main(String[] args) {
		int[] a = {3, 5, 1, 6, 2, 4, 0};
		int n=a.length;
		HashSet<Integer> visited = new HashSet<Integer>();
		int[] l= new int[n];
		for(int i=0;i<n;i++) dfs(a,i,0,visited, l);
		if(maxLoop<2) maxLoop=0;
		System.out.println(maxLoop);
	}
}
